package com.example.currentweather.fragments.today

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currentweather.data.response.TodayWeatherResponse
import com.example.currentweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodayViewModel
@Inject constructor(private val repository: WeatherRepository) : ViewModel() {


    private val _response = MutableLiveData<TodayWeatherResponse>()
    val todayWeatherResponse: LiveData<TodayWeatherResponse>
        get() = _response

    init {
        getTodayWeather()
    }

    private fun getTodayWeather() = viewModelScope.launch {
        repository.getTodayWeather().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("Tag", "getTodayWeather Error Response:${response.message()}")
            }

        }
    }
}