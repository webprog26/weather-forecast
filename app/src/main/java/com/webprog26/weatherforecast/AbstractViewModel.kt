package com.webprog26.weatherforecast

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.webprog26.weatherforecast.data.WeatherForecastDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class AbstractViewModel(application: Application) : AndroidViewModel(application) {

    protected val weatherForecastDao = WeatherForecastDatabase.getInstance(application).weatherForecastDao

    private val viewModelJob = Job()
    protected val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}