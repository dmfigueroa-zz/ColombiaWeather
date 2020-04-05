package com.example.colombiaweather.apiService.cityDays

import android.os.Parcelable
import com.example.colombiaweather.apiService.Weather
import com.example.colombiaweather.apiService.citiesList.*
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat

@Parcelize
data class Day(
    @Json(name = "dt") val timeOfData: Long?,
    val main: Main?,
    @Json(name = "feels_like") val feelsLike: FeelsLike?,
    @Json(name = "deg") val degrees: Double?,
    val pressure: Double?,
    val humidity: Double?,
    val weather: List<Weather>,
    val speed: Double?,
    val clouds: Clouds?,
    val rain: Rain?,
    val wind: Wind?,
    val snow: Snow?,
    var iconUrl: String?,
    @Json(name = "dt_txt") val date: String?
): Parcelable {
    init {
        iconUrl = "http://openweathermap.org/img/wn/${weather[0].icon}@2x.png"
    }
}