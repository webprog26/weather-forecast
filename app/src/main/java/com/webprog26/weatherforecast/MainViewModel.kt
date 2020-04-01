package com.webprog26.weatherforecast

import android.app.Application
import android.location.Location
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.webprog26.weatherforecast.network.WeatherApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val storage = PreferencesStorage(application.applicationContext)

    private val fusedLocationProvider: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(application.applicationContext)

    private val _userLocation =  MutableLiveData<Location?>()

    val userLocation: LiveData<Location?>
    get() = _userLocation

    private val _currentCity = MutableLiveData<String?>()

    val currentCity: LiveData<String?>
    get() = _currentCity

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

    fun onUserLocationDetected(apiKey: String, coordinates: String, language: String, details: String, topLevel: String) {
        getLocationDataFromApi(apiKey, coordinates, language, details, topLevel)
    }

    private fun getLocationDataFromApi(apiKey: String, coordinates: String, language: String, details: String, topLevel: String) {
        coroutineScope.launch {
            val getLocationDataDeferred = WeatherApi.retrofitService.getLocationDataAsync(
                apiKey,
                coordinates,
                language,
                details,
                topLevel
            );
            try {
                val locationData = getLocationDataDeferred.await()
                log("request successful: $locationData")
                storage.setCurrentLocationData(locationData)
                _currentCity.value = "${storage.getCurrentCity()}, ${storage.getCurrentCountry()}"
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}