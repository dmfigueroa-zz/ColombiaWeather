package com.example.colombiaweather.apiService

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    @Json(name = "id") val weatherId: Double?,
    val main: String?,
    val description: String?,
    val icon: String?
) : Parcelable