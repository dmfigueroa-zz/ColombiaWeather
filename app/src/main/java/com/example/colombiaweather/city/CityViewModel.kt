package com.example.colombiaweather.city

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.colombiaweather.apiService.WeatherApi
import com.example.colombiaweather.apiService.citiesList.City
import com.example.colombiaweather.apiService.cityDays.Day
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CityViewModel(city: City, app: Application) : AndroidViewModel(app) {
    private val _selectedCity = MutableLiveData<City>()
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )
    private val _forecast = MutableLiveData<List<Day>>()

    val selectedCity: LiveData<City>
        get() = _selectedCity

    val forecast: LiveData<List<Day>>
        get() = _forecast

    init {
        _selectedCity.value = city
        getCitiesWeatherInfo()
    }

    private fun getCitiesWeatherInfo() {
        coroutineScope.launch {
            var getPropertiesDeferred = WeatherApi.retrofitService.getDailyForecast(selectedCity.value?.cityId, "metric")
            try {
                var cityForecast = getPropertiesDeferred.await()
                _forecast.value = cityForecast.forecast
                Log.d("API Success", cityForecast.toString())
            } catch (t: Throwable) {
                Log.e("API Error", t.message)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}