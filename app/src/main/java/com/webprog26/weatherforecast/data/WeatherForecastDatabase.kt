package com.webprog26.weatherforecast.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserLocationData::class, DailyForecastData::class, HourlyForecastData::class], version = 1, exportSchema = false)
abstract class WeatherForecastDatabase :  RoomDatabase() {

    abstract val weatherForecastDao: WeatherForecastDao

    companion object {
        @Volatile
        private var INSTANCE: WeatherForecastDatabase? = null

        fun getInstance(context: Context): WeatherForecastDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            WeatherForecastDatabase::class.java,
                            "weather_forecast_database"
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}