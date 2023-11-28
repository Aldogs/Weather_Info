package com.bancoazteca.weatherinfo.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bancoazteca.weatherinfo.data.response.LocationData
import com.bancoazteca.weatherinfo.data.response.Temperature
import com.bancoazteca.weatherinfo.repository.WeatherInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherInfoViewModel @Inject constructor(
     val repository: WeatherInfoRepository
) : ViewModel() {

    var weatherInfoData = mutableStateOf(Temperature(listOf(),""))
    private val _temperatureData = MutableLiveData<LocationData>()
    val temperatureData: LiveData<LocationData> get() = _temperatureData

    fun loadWeatherInfo() {
        viewModelScope.launch {
            val data = repository.getWeatherData()
            _temperatureData.postValue(data)
        }
    }
}