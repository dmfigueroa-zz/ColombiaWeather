package com.example.colombiaweather.apiService

import com.example.colombiaweather.apiService.citiesList.WeatherApiResponse
import com.example.colombiaweather.apiService.cityDays.DailyForecast
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.openweathermap.org/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL).build()

interface WeatherApiService {
    @GET("data/2.5/group")
    fun getCities(@Query("id") cities: String, @Query("units") units: String, @Query("appid") apiKey: String = "2c7804174fc9d3105490eefb4ef143b0", @Query("lang") language: String = "es"): Deferred<WeatherApiResponse>

    @GET("data/2.5/forecast")
    fun getDailyForecast(@Query("id") id: Long?, @Query("units") units: String, @Query("appid") apiKey: String = "2c7804174fc9d3105490eefb4ef143b0", @Query("lang") language: String = "es"): Deferred<DailyForecast>
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }
}