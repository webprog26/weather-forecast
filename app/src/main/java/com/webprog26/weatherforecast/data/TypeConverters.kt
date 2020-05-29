package com.webprog26.weatherforecast.data

import androidx.room.TypeConverter
import org.json.JSONArray
import org.json.JSONObject

private const val KEY_DATE = "Date"
private const val KEY_MIN_TEMP = "MinTemp"
private const val KEY_MAX_TEMP = "MaxTemp"
private const val KEY_ICON_DAY = "IconDay"
private const val KEY_ICON_PHRASE_DAY = "IconPhraseDay"
private const val KEY_HAS_PRECIPITATION_DAY = "HasPrecipitationDay"
private const val KEY_PRECIPITATION_TYPE_DAY = "PrecipitationTypeDay"
private const val KEY_PRECIPITATION_INTENSITY_DAY = "PrecipitationIntensityDay"
private const val KEY_ICON_NIGHT = "IconNight"
private const val KEY_ICON_PHRASE_NIGHT = "IconPhraseNight"
private const val KEY_HAS_PRECIPITATION_NIGHT = "HasPrecipitationNight"
private const val KEY_PRECIPITATION_TYPE_NIGHT = "PrecipitationTypeNight"
private const val KEY_PRECIPITATION_INTENSITY_NIGHT = "PrecipitationIntensityNight"



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
    fun fromList(list: List<HourlyForecastData>): String {
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

class FiveDaysDailyDataTypeConverter {

    @TypeConverter
    fun fromList(list: List<FiveDaysDailyForecastData>) : String {
        val jsonArray = JSONArray()
        for (data in list) {
            val dataObject = JSONObject()
            dataObject.put(KEY_DATE, data.date)
            dataObject.put(KEY_MIN_TEMP, data.minTemp)
            dataObject.put(KEY_MAX_TEMP, data.maxTemp)
            dataObject.put(KEY_ICON_DAY, data.iconDay)
            dataObject.put(KEY_ICON_PHRASE_DAY, data.iconPhraseDay)
            dataObject.put(KEY_HAS_PRECIPITATION_DAY, data.hasPrecipitationDay)
            dataObject.put(KEY_PRECIPITATION_TYPE_DAY, data.precipitationTypeDay)
            dataObject.put(KEY_PRECIPITATION_INTENSITY_DAY, data.precipitationIntensityDay)
            dataObject.put(KEY_ICON_NIGHT, data.iconNight)
            dataObject.put(KEY_ICON_PHRASE_NIGHT, data.iconPhraseNight)
            dataObject.put(KEY_HAS_PRECIPITATION_NIGHT, data.hasPrecipitationNight)
            dataObject.put(KEY_PRECIPITATION_TYPE_NIGHT, data.precipitationTypeNight)
            dataObject.put(KEY_PRECIPITATION_INTENSITY_NIGHT, data.precipitationIntensityNight)
            jsonArray.put(dataObject)
        }
        return jsonArray.toString()
    }

    @TypeConverter
    fun fromJsonString(origin: String): List<FiveDaysDailyForecastData> {
        val jsonArray = JSONArray(origin)
        val fiveDaysDailyForecastDataList = ArrayList<FiveDaysDailyForecastData>()
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val fiveDaysDailyForecastData = FiveDaysDailyForecastData(
                id = i.toLong(),
                date =  jsonObject.getString(KEY_DATE),
                minTemp = jsonObject.getString(KEY_MIN_TEMP).toFloat(),
                maxTemp = jsonObject.getString(KEY_MAX_TEMP).toFloat(),
                iconDay = jsonObject.getInt(KEY_ICON_DAY),
                iconPhraseDay = jsonObject.getString(KEY_ICON_PHRASE_DAY),
                hasPrecipitationDay = jsonObject.getBoolean(KEY_HAS_PRECIPITATION_DAY),
                precipitationTypeDay = jsonObject.getString(KEY_PRECIPITATION_TYPE_DAY),
                precipitationIntensityDay = jsonObject.getString(KEY_PRECIPITATION_INTENSITY_DAY),
                iconNight = jsonObject.getInt(KEY_ICON_NIGHT),
                iconPhraseNight = jsonObject.getString(KEY_ICON_PHRASE_NIGHT),
                hasPrecipitationNight = jsonObject.getBoolean(KEY_HAS_PRECIPITATION_NIGHT),
                precipitationTypeNight = jsonObject.getString(KEY_PRECIPITATION_TYPE_NIGHT),
                precipitationIntensityNight = jsonObject.getString(KEY_PRECIPITATION_INTENSITY_NIGHT)
            )
            fiveDaysDailyForecastDataList.add(fiveDaysDailyForecastData)
        }
        return fiveDaysDailyForecastDataList
    }
}