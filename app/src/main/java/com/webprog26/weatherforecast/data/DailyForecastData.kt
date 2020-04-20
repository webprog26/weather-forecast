package com.webprog26.weatherforecast.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_forecast_table")
data class DailyForecastData(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "updated_at")
    val updatedAt: String,

    @ColumnInfo(name = "min_temp")
    val minTemp: Float,

    @ColumnInfo(name = "max_temp")
    val maxTemp: Float,

    @ColumnInfo(name = "icon_day")
    val iconDay: Int,

    @ColumnInfo(name = "icon_phrase_day")
    val iconPhraseDay: String,

    @ColumnInfo(name = "icon_night")
    val iconNight: Int,

    @ColumnInfo(name = "icon_phrase_night")
    val iconPhraseNight: String
)