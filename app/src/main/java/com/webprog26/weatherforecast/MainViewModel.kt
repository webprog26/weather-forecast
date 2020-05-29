package com.webprog26.weatherforecast

import android.app.Application
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.webprog26.weatherforecast.data.*
import com.webprog26.weatherforecast.network.WeatherApi
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

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

private const val KEY_HOURLY_DATE_TIME = "DateTime"
private const val KEY_HOURLY_WEATHER_ICON = "WeatherIcon"
private const val KEY_HAS_PRECIPITATION = "HasPrecipitation"
private const val KEY_PRECIPITATION_TYPE = "PrecipitationType"
private const val KEY_PRECIPITATION_INTENSITY = "PrecipitationIntensity"
private const val KEY_HOURLY_PRECIPITATION_PROBABILITY = "PrecipitationProbability"
private const val KEY_HOURLY_IS_DAY_LIGHT = "IsDaylight"


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

    private val _hourlyForecastData = MutableLiveData<HourlyForecastDataWrapper>()
    val hourlyForecastData: LiveData<HourlyForecastDataWrapper>
        get() = _hourlyForecastData

    private val _fiveDaysDailyForecastData = MutableLiveData<FiveDaysDailyForecastDataWrapper>()
    val fiveDaysDailyForecastData : LiveData<FiveDaysDailyForecastDataWrapper>
    get() = _fiveDaysDailyForecastData

    init {
        coroutineScope.launch {
            _userLocationData.value = getUserLocationDataFromDb()
            _dailyForecastData.value = getDailyForecastDataFromDb()
            _hourlyForecastData.value = HourlyForecastDataWrapper(getHourlyForecastDataFromDb())
            _fiveDaysDailyForecastData.value = FiveDaysDailyForecastDataWrapper(getFiveDaysDailyForecastDataFromDb())
        }
    }

    fun loadDailyForecast(
        apiKey: String,
        language: String,
        details: String,
        metric: String,
        useMockData: Boolean
    ) {
        coroutineScope.launch {
            getDailyForecast(apiKey, language, details, metric, useMockData)
        }
    }

    fun loadHourlyForecast(
        apiKey: String,
        language: String,
        details: String,
        metric: String,
        useMockData: Boolean
    ) {
        coroutineScope.launch {
            getHourlyForecast(apiKey, language, details, metric, useMockData)
        }
    }

    fun load5DaysForecast(apiKey: String,
    language: String,
    details: String,
    metric: String,
    useMockData: Boolean) {
        log("load5DaysForecast")
        coroutineScope.launch {
            get5DaysForecast(apiKey, language, details, metric, useMockData)
        }
    }

    private suspend fun get5DaysForecast(apiKey: String,
                                         language: String,
                                         details: String,
                                         metric: String,
                                         useMockData: Boolean) {
        withContext(Dispatchers.IO) {
            weatherForecastDao.getUserLocationData()?.let { it ->
                try {
                    val fiveDaysForecastOrigin = if (useMockData) {
                        get5DaysForecastMockData()
                    } else {
                        WeatherApi.retrofitService.get5DaysForecastAsync(it.locationKey, apiKey, language, details, metric
                        ).await()
                    }

                    val jsonArray = JSONObject(fiveDaysForecastOrigin).getJSONArray("DailyForecasts")
                    val fiveDaysDailyForecastsList = ArrayList<FiveDaysDailyForecastData>()

                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val dateString = jsonObject.getString(KEY_DATE)
                        val dateLocal = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
                            .parse(dateString.substring(0, dateString.indexOf('+')))
                        val date = SimpleDateFormat("EEE, MMM d", Locale.getDefault()).format(dateLocal!!)
                        val minTemp = jsonObject.getJSONObject(KEY_TEMP).getJSONObject(KEY_TEMP_MIN).getString(
                            KEY_VALUE)
                        val maxTemp = jsonObject.getJSONObject(KEY_TEMP).getJSONObject(KEY_TEMP_MAX).getString(
                            KEY_VALUE)
                        val iconDay = jsonObject.getJSONObject(KEY_DAY).getString(KEY_ICON)
                        val iconPhraseDay = jsonObject.getJSONObject(KEY_DAY).getString(
                            KEY_ICON_PHRASE)
                        val hasPrecipitationDay = jsonObject?.getJSONObject(KEY_DAY)?.getString(
                            KEY_HAS_PRECIPITATION)?.toBoolean()
                        var precipitationTypeDay : String? = null
                        var precipitationIntensityDay : String? = null
                        hasPrecipitationDay?.let {
                            if (hasPrecipitationDay) {
                                precipitationTypeDay = jsonObject.getJSONObject(KEY_DAY).getString(
                                    KEY_PRECIPITATION_TYPE)
                                precipitationIntensityDay = jsonObject.getJSONObject(KEY_DAY).getString(
                                    KEY_PRECIPITATION_INTENSITY
                                )
                            }
                        }
                        val iconNight = jsonObject.getJSONObject(KEY_NIGHT).getString(KEY_ICON)
                        val iconPhraseNight = jsonObject.getJSONObject(KEY_NIGHT).getString(
                            KEY_ICON_PHRASE)
                        val hasPrecipitationNight = jsonObject?.getJSONObject(KEY_NIGHT)?.getString(
                            KEY_HAS_PRECIPITATION)?.toBoolean()
                        var precipitationTypeNight : String? = null
                        var precipitationIntensityNight : String? = null
                        hasPrecipitationNight?.let {
                            if (hasPrecipitationNight) {
                                precipitationTypeNight = jsonObject.getJSONObject(KEY_NIGHT).getString(
                                    KEY_PRECIPITATION_TYPE)
                                precipitationIntensityNight = jsonObject.getJSONObject(KEY_NIGHT).getString(
                                    KEY_PRECIPITATION_INTENSITY
                                )
                            }
                        }

                        val fiveDaysDailyForecastData = FiveDaysDailyForecastData(
                            id = i.toLong(),
                            date = date,
                            minTemp = minTemp.toFloat(),
                            maxTemp = maxTemp.toFloat(),
                            iconDay = iconDay.toInt(),
                            iconPhraseDay = iconPhraseDay,
                            hasPrecipitationDay = hasPrecipitationDay!!,
                            precipitationTypeDay = precipitationTypeDay,
                            precipitationIntensityDay = precipitationIntensityDay,
                            iconNight = iconNight.toInt(),
                            iconPhraseNight = iconPhraseNight,
                            hasPrecipitationNight = hasPrecipitationNight!!,
                            precipitationTypeNight = precipitationTypeNight,
                            precipitationIntensityNight = precipitationIntensityNight
                        )
                        fiveDaysDailyForecastsList.add(fiveDaysDailyForecastData)
                    }

                    insertFiveDaysDailyForecastDataToDb(fiveDaysDailyForecastsList)
                   withContext(Dispatchers.Main) {
                       _fiveDaysDailyForecastData.value = FiveDaysDailyForecastDataWrapper(fiveDaysDailyForecastsList)
                   }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
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
        metric: String,
        useMockData: Boolean
    ) {
        withContext(Dispatchers.IO) {
            weatherForecastDao.getUserLocationData()
                ?.let {
                    coroutineScope.launch {

                        try {
                            val dailyForecastOrigin = if (useMockData) {
                                getDailyMockData()
                            } else {
                                WeatherApi.retrofitService.getDailyForecastAsync(
                                    it.locationKey,
                                    apiKey,
                                    language,
                                    details,
                                    metric
                                ).await()
                            }
                            val forecast = JSONObject(dailyForecastOrigin).getJSONArray(
                                KEY_DAILY_FORECASTS
                            ).getJSONObject(0)
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
                                1,
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

    private suspend fun getHourlyForecast(
        apiKey: String,
        language: String,
        details: String,
        metric: String,
        useMockData: Boolean
    ) {
        withContext(Dispatchers.IO) {
            weatherForecastDao.getUserLocationData()
                ?.let {
                    coroutineScope.launch {
                        try {
                            val hourlyForecastOrigin = if (useMockData) {
                                getHourlyMockData()
                            } else {
                                WeatherApi.retrofitService.get12HoursForecastAsync(
                                    it.locationKey, apiKey, language, details, metric
                                ).await()
                            }
                            val jsonArray = JSONArray(hourlyForecastOrigin)
                            val hourlyForecastsList = ArrayList<HourlyForecastData>()

                            for (i in 0 until jsonArray.length()) {
                                val jsonObject = jsonArray.getJSONObject(i)
                                val dateTime = jsonObject.getString(KEY_HOURLY_DATE_TIME)

                                val timeStartIndex = dateTime.indexOf('T') + 1
                                val timeEndIndex = timeStartIndex + 5

                                val time = dateTime.substring(timeStartIndex, timeEndIndex)

                                val temp = jsonObject.getJSONObject(KEY_TEMP).getString(KEY_VALUE)
                                val icon = jsonObject.getInt(KEY_HOURLY_WEATHER_ICON)
                                val iconPhrase = jsonObject.getString(KEY_ICON_PHRASE)
                                val hasPrecipitation =
                                    jsonObject?.getString(KEY_HAS_PRECIPITATION)?.toBoolean()
                                var precipitationType: String? = null
                                var precipitationIntensity: String? = null

                                hasPrecipitation?.let {
                                    if (hasPrecipitation) {
                                        precipitationType = jsonObject.getString(
                                            KEY_PRECIPITATION_TYPE
                                        )
                                        precipitationIntensity = jsonObject.getString(
                                            KEY_PRECIPITATION_INTENSITY
                                        )
                                    }
                                }

                                val precipitationProbability = jsonObject.getInt(
                                    KEY_HOURLY_PRECIPITATION_PROBABILITY
                                )

                                val isDayLight = jsonObject.getString(KEY_HOURLY_IS_DAY_LIGHT)

                                val hourlyForecastData = HourlyForecastData(
                                    id = i.toLong(),
                                    time = time,
                                    temp = temp.toFloat(),
                                    icon = icon,
                                    iconPhrase = iconPhrase,
                                    hasPrecipitation = hasPrecipitation!!,
                                    precipitationType = precipitationType,
                                    precipitationIntensity = precipitationIntensity,
                                    precipitationProbability = precipitationProbability,
                                    isDayLight = isDayLight
                                )
                                hourlyForecastsList.add(hourlyForecastData)
                            }

                            insertHourlyForecastDataToDb(hourlyForecastsList)
                            withContext(Dispatchers.Main) {
                                _hourlyForecastData.value =
                                    HourlyForecastDataWrapper(hourlyForecastsList)
                            }

                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                    }
                }
        }
    }

    private suspend fun insertFiveDaysDailyForecastDataToDb(fiveDaysDailyForecastDataList : List<FiveDaysDailyForecastData>) {
        withContext(Dispatchers.IO) {
            weatherForecastDao.insertFiveDaysDailyForecastData(fiveDaysDailyForecastDataList)
        }
    }

    private suspend fun getFiveDaysDailyForecastDataFromDb() : List<FiveDaysDailyForecastData?> {
        return withContext(Dispatchers.IO) {
            weatherForecastDao.getFiveDaysDailyForecastData()
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

    private suspend fun insertHourlyForecastDataToDb(hourlyForecastData: List<HourlyForecastData>) {
        withContext(Dispatchers.IO) {
            weatherForecastDao.insertHourlyForecastData(hourlyForecastData)
        }
    }

    private suspend fun getHourlyForecastDataFromDb(): List<HourlyForecastData?> {
        return withContext(Dispatchers.IO) {
            weatherForecastDao.getHourlyData()
        }
    }

    fun detectUserLocation() {
        try {
            fusedLocationProvider.lastLocation.addOnSuccessListener {
                it?.let {
                    _userLocation.value = it
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
        topLevel: String,
        useMockData: Boolean
    ) {
        getLocationDataFromApi(apiKey, coordinates, language, details, topLevel, useMockData)
    }

    private fun getLocationDataFromApi(
        apiKey: String,
        coordinates: String,
        language: String,
        details: String,
        topLevel: String,
        useMockData: Boolean
    ) {
        coroutineScope.launch {
            try {
                val locationData = if (useMockData) {
                    getLocationMockData()
                } else {
                    WeatherApi.retrofitService.getLocationDataAsync(
                        apiKey,
                        coordinates,
                        language,
                        details,
                        topLevel
                    ).await()
                }

                val jsonObject = JSONObject(locationData)
                val locationKey = jsonObject.getString(KEY_LOCATION_KEY)
                val cityName = jsonObject.getString(KEY_LOCALIZED_NAME)
                val countryName =
                    jsonObject.getJSONObject(KEY_COUNTRY).getString(KEY_LOCALIZED_NAME)
                val userLocationData = UserLocationData(0, cityName, countryName, locationKey)
                insertUserLocationDataToDb(userLocationData)
                _userLocationData.value = getUserLocationDataFromDb()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun insertUserLocationDataToDb(userLocationData: UserLocationData) {
        withContext(Dispatchers.IO) {
            weatherForecastDao
                .insertUserLocationData(userLocationData)
        }
    }
}