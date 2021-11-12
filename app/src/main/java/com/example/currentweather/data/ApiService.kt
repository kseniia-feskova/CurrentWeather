package com.example.currentweather.data

import com.example.currentweather.data.response.TodayWeatherResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("weather/London")
    suspend fun getTodayWeather(): Response<TodayWeatherResponse>

}
