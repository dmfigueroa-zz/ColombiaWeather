package com.example.colombiaweather.city

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.colombiaweather.apiService.citiesList.City

class CityViewModelFactory(private val city: City, private val application: Application) : ViewModelProvider.Factory {
    override fun <City : ViewModel?> create(modelClass: Class<City>): City {
        if (modelClass.isAssignableFrom(CityViewModel::class.java)) {
            return CityViewModel(city, application) as City
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}