package com.webprog26.weatherforecast.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "http://dataservice.accuweather.com"

val httpLoggingInterceptor = HttpLoggingInterceptor()
val httpClient = OkHttpClient.Builder()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(
        httpClient.addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    )
    .build()

object WeatherApi {
    val retrofitService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}

interface WeatherApiService {

    @GET("/locations/v1/cities/geoposition/search")
    fun getLocationDataAsync(
        @Query("apikey") apiKey: String,
        @Query("q") coordinates: String,
        @Query("language") language: String,
        @Query("details") details: String,
        @Query("topLevel") topLevel: String
    ): Deferred<String>

    @GET("/forecasts/v1/daily/1day/{location_key}")
    fun getDailyForecastAsync(
        @Path("location_key") locationKey: String,
        @Query("apikey") apiKey: String,
        @Query("language") language: String,
        @Query("details") details: String,
        @Query("metric") metric: String
    ): Deferred<String>
}