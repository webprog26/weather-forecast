package com.webprog26.weatherforecast.data

import androidx.room.TypeConverter
import org.json.JSONArray
import org.json.JSONObject

private const val KEY_HOURLY_DATE_TIME = "DateTime"
private const val KEY_HOURLY_TEMP = "Temp"
private const val KEY_HOURLY_ICON = "Icon"
private const val KEY_HOURLY_ICON_PHRASE = "IconPhrase"
private const val KEY_HOURLY_HAS_PRECIPITATION = "HasPrecipitation"
private const val KEY_HOURLY_PRECIPITATION_TYPE = "PrecipitationType"
private const val KEY_HOURLY_PRECIPITATION_INTENSITY = "PrecipitationIntensity"
private const val KEY_HOURLY_PRECIPITATION_PROBABILITY = "PrecipitationProbability"
private const val KEY_HOURLY_IS_DAY_LIGHT = "IsDayLight"

class HourlyDataTypeConverter {

    @TypeConverter
    fun fromHourlyDataList(list: List<HourlyForecastData>): String {
        val jsonArray = JSONArray()
        for (data in list) {
            val dataObject = JSONObject()
            dataObject.put(KEY_HOURLY_DATE_TIME, data.time)
            dataObject.put(KEY_HOURLY_TEMP, data.temp)
            dataObject.put(KEY_HOURLY_ICON, data.icon)
            dataObject.put(KEY_HOURLY_ICON_PHRASE, data.iconPhrase)
            dataObject.put(KEY_HOURLY_HAS_PRECIPITATION, data.hasPrecipitation)
            dataObject.put(KEY_HOURLY_PRECIPITATION_TYPE, data.precipitationType)
            dataObject.put(KEY_HOURLY_PRECIPITATION_INTENSITY, data.precipitationIntensity)
            dataObject.put(KEY_HOURLY_PRECIPITATION_PROBABILITY, data.precipitationProbability)
            dataObject.put(KEY_HOURLY_IS_DAY_LIGHT, data.isDayLight)
            jsonArray.put(dataObject)
        }
        return jsonArray.toString()
    }

    @TypeConverter
    fun fromJsonString(origin: String): List<HourlyForecastData> {
        val jsonArray= JSONArray(origin)
        val hourlyDataList = ArrayList<HourlyForecastData>()
        for (i in 0 until jsonArray.length()) {
            val dataObject = jsonArray.getJSONObject(i)
            val hourlyForecastData = HourlyForecastData(
                id = i.toLong(),
                time = dataObject.getString(KEY_HOURLY_DATE_TIME),
                temp = dataObject.getString(KEY_HOURLY_TEMP).toFloat(),
                icon = dataObject.getInt(KEY_HOURLY_ICON),
                iconPhrase = dataObject.getString(KEY_HOURLY_ICON_PHRASE),
                hasPrecipitation = dataObject.getBoolean(KEY_HOURLY_HAS_PRECIPITATION),
                precipitationType = dataObject.getString(KEY_HOURLY_PRECIPITATION_TYPE),
                precipitationIntensity = dataObject.getString(KEY_HOURLY_PRECIPITATION_INTENSITY),
                precipitationProbability = dataObject.getInt(KEY_HOURLY_PRECIPITATION_PROBABILITY),
                isDayLight = dataObject.getString(KEY_HOURLY_IS_DAY_LIGHT)
            )
            hourlyDataList.add(hourlyForecastData)
        }
        return hourlyDataList
    }
}