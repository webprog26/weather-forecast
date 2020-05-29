package com.webprog26.weatherforecast.data

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

    @Insert(entity = HourlyForecastData::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertHourlyForecastData(hourlyForecastData: List<HourlyForecastData>)

    @Update(entity = HourlyForecastData::class)
    fun updateHourlyForecastData(hourlyForecastData: List<HourlyForecastData>)

    @Query("SELECT * from hourly_forecast_table")
    fun getHourlyData() : List<HourlyForecastData?>

    @Insert(entity = FiveDaysDailyForecastData::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertFiveDaysDailyForecastData(fiveDaysDailyForecastData: List<FiveDaysDailyForecastData>)

    @Update(entity = FiveDaysDailyForecastData::class)
    fun updateFiveDaysDailyForecastData(hourlyForecastData: List<FiveDaysDailyForecastData>)

    @Query("SELECT * from five_days_daily_forecast_table")
    fun getFiveDaysDailyForecastData() : List<FiveDaysDailyForecastData?>

}