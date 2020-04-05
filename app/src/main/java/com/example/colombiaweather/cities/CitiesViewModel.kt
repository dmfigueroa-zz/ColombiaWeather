package com.example.colombiaweather.cities

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.colombiaweather.apiService.citiesList.City
import com.example.colombiaweather.apiService.WeatherApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CitiesViewModel : ViewModel() {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )
    private val _cities = MutableLiveData<List<City>>()

    private val _navigateToSelectedCity = MutableLiveData<City>()

    val navigateToSelectedCity: LiveData<City>
        get() = _navigateToSelectedCity

    val cities: LiveData<List<City>>
        get() = _cities

    init {
        getCitiesWeatherInfo()
    }

    private fun getCitiesWeatherInfo() {
        val cities = listOf<String>("3689147","3688689","3688465","3687925","3687238","3685533","3674962","3672486","3668605","3666304")
        coroutineScope.launch {
            var getPropertiesDeferred = WeatherApi.retrofitService.getCities(cities.joinToString(","), "metric")
            try {
                var weatherResult = getPropertiesDeferred.await()
                _cities.value = weatherResult.cities
                Log.d("API Success", weatherResult.toString())
            } catch (t: Throwable) {
                Log.e("API Error", t.message)
            }
        }
    }

    fun displayPropertyDetails(city: City) {
        _navigateToSelectedCity.value = city
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedCity.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}