package com.webprog26.weatherforecast.data

import androidx.room.*

@Entity(tableName = "hourly_forecast_table")
@TypeConverters(HourlyDataTypeConverter::class)
data class HourlyForecastData(

    @PrimaryKey
    val id: Long,

    @ColumnInfo(name = "time")
    val time: String,

    @ColumnInfo(name = "temp")
    val temp: Float,

    @ColumnInfo(name = "icon")
    val icon: Int,

    @ColumnInfo(name = "icon_phrase")
    val iconPhrase: String,

    @ColumnInfo(name = "has_precipitation")
    val hasPrecipitation: Boolean,

    @ColumnInfo(name = "precipitation_type")
    val precipitationType: String?,

    @ColumnInfo(name = "precipitation_intensity")
    val precipitationIntensity: String?,

    @ColumnInfo(name = "precipitation_probability")
    val precipitationProbability: Int,

    @ColumnInfo(name = "is_day_light")
    val isDayLight: String
)