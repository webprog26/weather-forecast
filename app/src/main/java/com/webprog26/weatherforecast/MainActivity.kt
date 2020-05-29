package com.webprog26.weatherforecast

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import java.util.*

const val ACCESS_COARSE_LOCATION_PERMISSION_REQUEST_CODE = 0

class MainActivity : AppCompatActivity(), LocationFetchingFragment.OnLocationDataObtainedListener,
    ForecastFragment.OnForecastUpdateRequestedListener {

    private val locationFetchingFragment = LocationFetchingFragment()
    private val forecastFragment = ForecastFragment()

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = ViewModelFactory(application)

        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.userLocation.observe(this, Observer {
            it?.let {
                mainViewModel.onUserLocationDetected(
                    getString(R.string.accuweather_api_key),
                    "${it.latitude}, ${it.longitude}", Locale.getDefault().language,
                    "false", "true", true
                )
                if (locationFetchingFragment.isAdded) {
                    locationFetchingFragment.onCoordinatesReceived()
                }
            }
        })

        mainViewModel.userLocationData.observe(this, Observer {
            if (it == null) {
                supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, locationFetchingFragment).commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, forecastFragment).commit()
            }
        })

        mainViewModel.dailyForecastData.observe(this, Observer {
            it?.let {
                if (forecastFragment.isAdded) {
                    forecastFragment.setDailyForecastData(it)
                }
            }
        })

        mainViewModel.hourlyForecastData.observe(this, Observer {
            it?.let {
                if (forecastFragment.isAdded) {
                    forecastFragment.setHourlyForecastData(it)
                }
            }
        })

        mainViewModel.fiveDaysDailyForecastData.observe(this, Observer {
            it?.let {
                if (forecastFragment.isAdded) {
                    forecastFragment.setFiveDaysDailyForecastData(it)
                }
            }
        })

        checkLocationPermissionIfNeededAndProceed()
    }

    override fun onRestart() {
        super.onRestart()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                )
                != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                    ACCESS_COARSE_LOCATION_PERMISSION_REQUEST_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            ACCESS_COARSE_LOCATION_PERMISSION_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    initLocationFetching()
                } else {
                    Toast.makeText(this, R.string.location_permission_request_explanation, Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    override fun onLocationDataObtained() {

    }

    override fun onForecastUpdateRequested() {
        mainViewModel.loadDailyForecast(
            getString(R.string.accuweather_api_key),
            Locale.getDefault().language, "false", "true", true
        )
        mainViewModel.loadHourlyForecast(
            getString(R.string.accuweather_api_key),
            Locale.getDefault().language, "false", "true", true)
        mainViewModel.load5DaysForecast( getString(R.string.accuweather_api_key),
            Locale.getDefault().language, "false", "true", true)
    }

    private fun checkLocationPermissionIfNeededAndProceed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                )
                != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                    ACCESS_COARSE_LOCATION_PERMISSION_REQUEST_CODE
                )

            } else {
                initLocationFetching()
            }
        } else {
            initLocationFetching()
        }
    }

    private fun initLocationFetching() {
        mainViewModel.detectUserLocation()
    }
}
