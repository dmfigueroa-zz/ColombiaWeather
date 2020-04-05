package com.example.colombiaweather.apiService.cityDays

import android.os.Parcelable
import com.example.colombiaweather.apiService.Coordinates
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City (
    @Json(name = "id") val cityId: Long?,
    @Json(name = "coord") val coordinates: Coordinates?,
    val name: String,
    val country: String?,
    val timezone: String?,
    val sunrise: Long?,
    val sunset: Long?
): Parcelable