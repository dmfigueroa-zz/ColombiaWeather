package com.example.colombiaweather.apiService.citiesList

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Clouds(
    val all: Double?
) : Parcelable