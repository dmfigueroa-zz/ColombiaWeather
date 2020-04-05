package com.example.colombiaweather.apiService

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coordinates(
    @Json(name = "lon") val longitude: Double?,
    @Json(name = "lat") val latitude: Double?
) : Parcelable