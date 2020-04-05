package com.example.colombiaweather.apiService.citiesList

import android.os.Parcelable
import com.example.colombiaweather.apiService.citiesList.City
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class WeatherApiResponse(
    @Json(name = "cnt") val citiesCount: Double?,
    @Json(name = "list") val cities: List<City>?
) : Parcelable