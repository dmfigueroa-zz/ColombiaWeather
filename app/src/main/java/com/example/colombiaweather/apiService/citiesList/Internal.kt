package com.example.colombiaweather.apiService.citiesList

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Internal(
    val type: Double?,
    @Json(name = "id") val internalId: Double?,
    val message: String?,
    val country: String?,
    val sunrise: Long?,
    val sunset: Long?,
    val timezone: Double?
) : Parcelable