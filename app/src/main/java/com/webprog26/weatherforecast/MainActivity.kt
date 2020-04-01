package com.webprog26.weatherforecast

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.webprog26.weatherforecast.databinding.ActivityMainBinding
import java.util.*

const val ACCESS_COARSE_LOCATION_PERMISSION_REQUEST_CODE = 0
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val viewModelFactory = ViewModelFactory(application)

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        mainViewModel.userLocation.observe(this, Observer {
            if (it != null) {
                log("Location received. latitude: ${it.latitude}, longitude: ${it.longitude}")
                binding.progressBar.visibility = View.VISIBLE
                binding.tvMessage.visibility = View.VISIBLE
                binding.tvMessage.text = getString(R.string.detecting_user_location_text)
                mainViewModel.onUserLocationDetected(getString(R.string.accuweather_api_key),
                    "${it.latitude}, ${it.longitude}", Locale.getDefault().language,
                "false", "true")
            } else {
                log("Location is null")
            }
        })
        mainViewModel.currentCity.observe(this, Observer {
            it?.let {
                binding.tvMessage.text = getString(R.string.loading_forecast_text, it);
            }
        })

        checkLocationPermissionIfNeededAndProceed()
    }

    override fun onRestart() {
        super.onRestart()
        log("onRestart")
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
                    binding.tvMessage.text = getString(R.string.location_permission_request_explanation)
                }
                return
            }
        }

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
        log("initLocationFetching")
        mainViewModel.detectUserLocation()
    }
}
