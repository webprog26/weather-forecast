package com.webprog26.weatherforecast.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_location_table")
data class UserLocationData(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "current_city")
    val currentCity: String,

    @ColumnInfo(name = "current_country")
    val currentCountry: String,

    @ColumnInfo(name = "location_key")
    val locationKey: String
)