package com.example.currentweather.data.response


import com.google.gson.annotations.SerializedName

data class TodayWeatherResponse(
    val description: String,
    val forecast: List<Forecast>,
    val temperature: String,
    val wind: String
)