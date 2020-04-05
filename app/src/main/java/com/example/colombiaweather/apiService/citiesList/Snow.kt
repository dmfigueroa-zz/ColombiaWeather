package com.example.colombiaweather.apiService.citiesList

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Snow(
    @Json(name = "1h") val snow1h: Double?,
    @Json(name = "3h") val snow3h: Double?
) : Parcelable