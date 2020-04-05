package com.example.colombiaweather.apiService.citiesList

import android.os.Parcelable
import com.example.colombiaweather.apiService.Coordinates
import com.example.colombiaweather.apiService.Weather
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlin.math.roundToInt

@Parcelize
data class City(
    @Json(name = "coord") val coordinates: Coordinates?,
    val weather: List<Weather>?,
    val base: String?,
    val main: Main?,
    val wind: Wind?,
    val clouds: Clouds?,
    val rain: Rain?,
    val snow: Snow?,
    @Json(name = "dt") val timeOfDataCalculation: Long?,
    @Json(name = "sys") val internal: Internal??,
    @Json(name = "id") val cityId: Long?,
    val name: String?,
    val visibility: Double?,
    var iconUrl: String?,
    var displayTemperature: String?
): Parcelable {
    init {
        iconUrl = "http://openweathermap.org/img/wn/${weather?.get(0)?.icon}@2x.png"
        displayTemperature = "${main?.temperature!!.roundToInt()}°"
    }
}

