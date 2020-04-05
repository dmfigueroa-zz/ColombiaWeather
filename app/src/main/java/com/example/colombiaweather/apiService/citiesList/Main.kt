package com.example.colombiaweather.apiService.citiesList

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Main(
    @Json(name = "temp") val temperature: Double,
    @Json(name = "feels_like") val feelsLike: Double?,
    val pressure: Double?,
    val humidity: Double?,
    @Json(name = "temp_min") val minTemperature: Double?,
    @Json(name = "temp_max") val maxTemperature: Double?,
    @Json(name = "sea_level") val seaLevelPressure: Double?,
    @Json(name = "grnd_level") val groundLevelPressure: Double?,
    @Json(name = "temp_kf") val tempKf: Double?
) : Parcelable