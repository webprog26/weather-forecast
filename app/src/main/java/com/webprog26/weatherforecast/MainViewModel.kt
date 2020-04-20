package com.webprog26.weatherforecast

import android.app.Application
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.webprog26.weatherforecast.data.DailyForecastData
import com.webprog26.weatherforecast.data.UserLocationData
import com.webprog26.weatherforecast.network.WeatherApi
import kotlinx.coroutines.*
import org.json.JSONObject
import java.lang.Exception

private const val KEY_LOCATION_KEY = "Key"
private const val KEY_LOCALIZED_NAME = "LocalizedName"
private const val KEY_COUNTRY = "Country"

private const val KEY_DAILY_FORECASTS = "DailyForecasts"
private const val KEY_DATE = "Date"
private const val KEY_TEMP = "Temperature"
private const val KEY_TEMP_MIN = "Minimum"
private const val KEY_TEMP_MAX = "Maximum"
private const val KEY_VALUE = "Value"
private const val KEY_DAY = "Day"
private const val KEY_NIGHT = "Night"
private const val KEY_ICON = "Icon"
private const val KEY_ICON_PHRASE = "IconPhrase"

class MainViewModel(application: Application) : AbstractViewModel(application) {

    private val fusedLocationProvider: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application.applicationContext)

    private val _userLocation = MutableLiveData<Location?>()
    val userLocation: LiveData<Location?>
        get() = _userLocation

    private val _userLocationData = MutableLiveData<UserLocationData?>()
    val userLocationData: LiveData<UserLocationData?>
        get() = _userLocationData

    private val _dailyForecastData = MutableLiveData<DailyForecastData?>()
    val dailyForecastData: LiveData<DailyForecastData?>
    get() = _dailyForecastData


    init {
       coroutineScope.launch {
           _dailyForecastData.value = getDailyForecastDataFromDb()
           _userLocationData.value = getUserLocationDataFromDb()
       }
    }

    fun loadDailyForecast(apiKey: String,
                          language: String,
                          details: String,
                          metric: String) {
        coroutineScope.launch {
            getDailyForecast(apiKey, language, details, metric)
            _dailyForecastData.value = getDailyForecastDataFromDb()
        }
    }

    private suspend fun getDailyForecastDataFromDb(): DailyForecastData? {
        return withContext(Dispatchers.IO) {
            weatherForecastDao.getDailyForecastData()
        }
    }

    private suspend fun getDailyForecast(
        apiKey: String,
        language: String,
        details: String,
        metric: String
    ) {
        withContext(Dispatchers.IO) {
            weatherForecastDao.getUserLocationData()
                .let {
                    if (it != null) {
                        coroutineScope.launch {

                            val getDailyForecast = WeatherApi.retrofitService.getDailyForecastAsync(
                                it.locationKey,
                                apiKey,
                                language,
                                details,
                                metric
                            )

                            try {
                                val dailyForecastOrigin = getDailyForecast.await()
                                log("dailyForecastOrigin: $dailyForecastOrigin")
                                val forecast = JSONObject(dailyForecastOrigin).getJSONArray(
                                    KEY_DAILY_FORECASTS).getJSONObject(0)
                                val updatedAt = forecast.getString(KEY_DATE)
                                val temp = forecast.getJSONObject(KEY_TEMP)
                                val minTemp = temp.getJSONObject(KEY_TEMP_MIN).getString(KEY_VALUE)
                                val maxTemp = temp.getJSONObject(KEY_TEMP_MAX).getString(KEY_VALUE)
                                val day = forecast.getJSONObject(KEY_DAY)
                                val iconDay = day.getString(KEY_ICON)
                                val iconDayPhrase = day.getString(KEY_ICON_PHRASE)
                                val night = forecast.getJSONObject(KEY_NIGHT)
                                val iconNight = night.getString(KEY_ICON)
                                val iconNightPhrase = night.getString(KEY_ICON_PHRASE)

                                val dailyForecastData = DailyForecastData(
                                    0,
                                    updatedAt,
                                    minTemp.toFloat(),
                                    maxTemp.toFloat(),
                                    iconDay.toInt(),
                                    iconDayPhrase,
                                    iconNight.toInt(),
                                    iconNightPhrase,
                                    it.currentCity
                                )
                                insertDailyForecastDataToDb(dailyForecastData)
                                _dailyForecastData.value = getDailyForecastDataFromDb()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                }
        }
    }

    private suspend fun insertDailyForecastDataToDb(dailyForecastData: DailyForecastData) {
        withContext(Dispatchers.IO) {
            weatherForecastDao.insertDailyForecastData(dailyForecastData)
        }
    }

    private suspend fun getUserLocationDataFromDb(): UserLocationData? {
        return withContext(Dispatchers.IO) {
            weatherForecastDao.getUserLocationData()
        }
    }
    fun detectUserLocation() {
        log("${javaClass.simpleName} detectUserLocation()")
        try {
            fusedLocationProvider.lastLocation.addOnSuccessListener {
                it?.let {
                    _userLocation.value = it
                    log("location received ${it.latitude} ${it.longitude}")
                }
            }
        } catch (se: SecurityException) {
            se.printStackTrace()
        }
    }

    fun onUserLocationDetected(
        apiKey: String,
        coordinates: String,
        language: String,
        details: String,
        topLevel: String
    ) {
        getLocationDataFromApi(apiKey, coordinates, language, details, topLevel)
    }

    private fun getLocationDataFromApi(
        apiKey: String,
        coordinates: String,
        language: String,
        details: String,
        topLevel: String
    ) {
        coroutineScope.launch {
            val getLocationDataDeferred = WeatherApi.retrofitService.getLocationDataAsync(
                apiKey,
                coordinates,
                language,
                details,
                topLevel
            )
            try {
                val locationData = getLocationDataDeferred.await()
                log("location request successful: $locationData")
                val jsonObject = JSONObject(locationData)
                val locationKey = jsonObject.getString(KEY_LOCATION_KEY)
                val cityName = jsonObject.getString(KEY_LOCALIZED_NAME)
                val countryName = jsonObject.getJSONObject(KEY_COUNTRY).getString(KEY_LOCALIZED_NAME)
                val userLocationData = UserLocationData(0, cityName, countryName, locationKey)
                insertUserLocationDataToDb(userLocationData)
                _userLocationData.value = getUserLocationDataFromDb()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun insertUserLocationDataToDb(userLocationData: UserLocationData) {
        log("${javaClass.simpleName} insertUserLocationDataToDb")
        withContext(Dispatchers.IO) {
            weatherForecastDao
                .insertUserLocationData(userLocationData)
        }
    }
}