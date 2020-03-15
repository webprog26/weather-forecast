package com.webprog26.weatherforecast

import android.util.Log

const val DEBUG_TAG = "weath_deb"

fun log(message: String) {
    if (BuildConfig.DEBUG) {
        Log.i(DEBUG_TAG, message)
    }
}