package com.bancoazteca.weatherinfo.di

import com.bancoazteca.weatherinfo.data.WeatherData
import com.bancoazteca.weatherinfo.repository.WeatherInfoRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideInfoRepository(
        weatherData: WeatherData
    ) = WeatherInfoRepository(weatherData)

    @Singleton
    @Provides
    fun provideWeatherData(): WeatherInfoRepository {
        val jsonData = """{
            "temperature": {
            "data": [
            {
                "place": "King's Park",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Hong Kong Observatory",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Wong Chuk Hang",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Ta Kwu Ling",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Lau Fau Shan",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Tai Po",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Sha Tin",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Tuen Mun",
                "value": 27,
                "unit": "C"
            },
            {
                "place": "Tseung Kwan O",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Sai Kung",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Cheung Chau",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Chek Lap Kok",
                "value": 27,
                "unit": "C"
            },
            {
                "place": "Tsing Yi",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Shek Kong",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Tsuen Wan Shing Mun Valley",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Hong Kong Park",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Shau Kei Wan",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Kowloon City",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Happy Valley",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Wong Tai Sin",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Stanley",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Kwun Tong",
                "value": 25,
                "unit": "C"
            },
            {
                "place": "Sham Shui Po",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Kai Tak Runway Park",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Yuen Long Park",
                "value": 26,
                "unit": "C"
            },
            {
                "place": "Tai Mei Tuk",
                "value": 25,
                "unit": "C"
            }
            ],
            "recordTime": "2023-11-09T17:00:00+08:00"
          }
        }"""
        val temperatureData = Gson().fromJson(jsonData, WeatherData::class.java)
        return provideInfoRepository(temperatureData)
    }
}