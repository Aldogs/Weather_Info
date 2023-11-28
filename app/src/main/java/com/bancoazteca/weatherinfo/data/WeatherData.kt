package com.bancoazteca.weatherinfo.data

import com.bancoazteca.weatherinfo.data.response.LocationData

interface WeatherData {
    suspend fun getWeatherData() : LocationData
}