package com.example.colombiaweather.apiService.citiesList

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rain(
    @Json(name = "1h") val rain1h: Double?,
    @Json(name = "3h") val rain3h: Double?
) : Parcelable