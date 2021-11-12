package com.example.currentweather.repository

import com.example.currentweather.data.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTodayWeather() = apiService.getTodayWeather()
}