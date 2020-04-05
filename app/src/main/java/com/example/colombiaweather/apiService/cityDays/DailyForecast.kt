package com.example.colombiaweather.apiService.cityDays

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DailyForecast (
    @Json(name = "cod") val internalCode: Long?,
    @Json(name = "cnt") val count: Int?,
    @Json(name = "list") val forecast: List<Day>?,
    val message: String?,
    val city: City?
): Parcelable