package com.webprog26.weatherforecast.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface WeatherForecastDao {

    @Insert(entity = UserLocationData::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertUserLocationData(userLocationData: UserLocationData)

    @Update(entity = UserLocationData::class)
    fun updateUserLocationData(userLocationData: UserLocationData)

    @Query("SELECT * from user_location_table")
    fun getUserLocationData(): UserLocationData?

    @Insert(entity = DailyForecastData::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertDailyForecastData(dailyForecastData: DailyForecastData)

    @Update(entity = DailyForecastData::class)
    fun updateDailyForecastData(dailyForecastData: DailyForecastData)

    @Query("SELECT * from daily_forecast_table")
    fun getDailyForecastData(): DailyForecastData?
}