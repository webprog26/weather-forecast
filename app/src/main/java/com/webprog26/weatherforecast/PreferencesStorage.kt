package com.webprog26.weatherforecast

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import org.json.JSONObject

private const val KEY_CURRENT_LOCATION_DATA = "key_current_location_data"

class PreferencesStorage(context: Context) {

    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun setCurrentLocationData(data: String) {
        prefs.edit().putString(KEY_CURRENT_LOCATION_DATA, LocationDataConverter.getUserLocationDataString(data)).apply()
    }

    fun getCurrentCity(): String? {
        val locationData = prefs.getString(KEY_CURRENT_LOCATION_DATA, null)
        return if (locationData != null) {
            LocationDataConverter.getCity(locationData)
        } else {
            null
        }
    }

    fun getCurrentCountry(): String? {
        val locationData = prefs.getString(KEY_CURRENT_LOCATION_DATA, null)
        return if (locationData != null) {
            LocationDataConverter.getCountry(locationData)
        } else {
            null
        }
    }

    fun getLocationKey(): String? {
        val locationData = prefs.getString(KEY_CURRENT_LOCATION_DATA, null)
        return if (locationData != null) {
            LocationDataConverter.getLocationKey(locationData)
        } else {
            null
        }
    }

    private object LocationDataConverter {

        const val KEY_LOCATION_KEY = "Key"
        const val KEY_LOCALIZED_NAME = "LocalizedName"
        const val KEY_COUNTRY = "Country"

        fun getUserLocationDataString(origin: String) : String {
            val jsonObject = JSONObject(origin)
            val locationKey = jsonObject.get(KEY_LOCATION_KEY)
            val cityName = jsonObject.get(KEY_LOCALIZED_NAME)
            val countryName = jsonObject.getJSONObject(KEY_COUNTRY).getString(KEY_LOCALIZED_NAME)
            log("$locationKey $cityName $countryName")
            return JSONObject().put(KEY_LOCATION_KEY, locationKey)
                .put(KEY_LOCALIZED_NAME, cityName).put(KEY_COUNTRY, countryName).toString()
        }

        fun getCity(locationData: String): String {
            val jsonObject = JSONObject(locationData)
            return jsonObject.getString(KEY_LOCALIZED_NAME)
        }

        fun getCountry(locationData: String): String {
            val jsonObject = JSONObject(locationData)
            return jsonObject.getString(KEY_COUNTRY)
        }

        fun getLocationKey(locationData: String): String {
            val jsonObject = JSONObject(locationData);
            return jsonObject.getString(KEY_LOCATION_KEY)
        }
    }
}