package com.example.colombiaweather.apiService.cityDays

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Temperatures (
    @Json(name = "eve") val evening: Double?,
    @Json(name = "morn") val morning: Double?,
    val day: Double?,
    val min: Double?,
    val max: Double?,
    val night: Double?
): Parcelable