package com.example.colombiaweather.apiService.citiesList

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wind(
    val speed: Double?,
    @Json(name = "deg") val degrees: Double?
) : Parcelable