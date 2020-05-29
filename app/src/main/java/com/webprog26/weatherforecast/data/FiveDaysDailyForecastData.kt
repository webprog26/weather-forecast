package com.webprog26.weatherforecast.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "five_days_daily_forecast_table")
@TypeConverters(FiveDaysDailyDataTypeConverter::class)
data class FiveDaysDailyForecastData (

    @PrimaryKey
    val id: Long = 0L,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "min_temp")
    val minTemp: Float,

    @ColumnInfo(name = "max_temp")
    val maxTemp: Float,

    @ColumnInfo(name = "icon_day")
    val iconDay: Int,

    @ColumnInfo(name = "icon_phrase_day")
    val iconPhraseDay: String,

    @ColumnInfo(name = "has_precipitation_day")
    val hasPrecipitationDay: Boolean,

    @ColumnInfo(name = "precipitation_type_day")
    val precipitationTypeDay: String?,

    @ColumnInfo(name = "precipitation_intensity_day")
    val precipitationIntensityDay: String?,

    @ColumnInfo(name = "icon_night")
    val iconNight: Int,

    @ColumnInfo(name = "icon_phrase_night")
    val iconPhraseNight: String,

    @ColumnInfo(name = "has_precipitation_night")
    val hasPrecipitationNight: Boolean,

    @ColumnInfo(name = "precipitation_type_night")
    val precipitationTypeNight: String?,

    @ColumnInfo(name = "precipitation_intensity_night")
    val precipitationIntensityNight: String?
)