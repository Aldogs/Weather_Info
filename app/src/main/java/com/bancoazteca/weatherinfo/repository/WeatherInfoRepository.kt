package com.bancoazteca.weatherinfo.repository

import com.bancoazteca.weatherinfo.data.WeatherData
import com.bancoazteca.weatherinfo.data.response.Data
import com.bancoazteca.weatherinfo.data.response.LocationData
import com.bancoazteca.weatherinfo.data.response.Temperature
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class WeatherInfoRepository @Inject constructor(
    private val weatherData: WeatherData
){
    suspend fun getWeatherData(): LocationData {
        val response = try {
            weatherData.getWeatherData()
        } catch (e: Exception) {
            return LocationData(Temperature(listOf(),""))
        }
        return response
    }
}