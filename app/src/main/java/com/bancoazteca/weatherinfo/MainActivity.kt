package com.bancoazteca.weatherinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bancoazteca.weatherinfo.ui.theme.WeatherInfoTheme
import com.bancoazteca.weatherinfo.viewmodel.WeatherInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherInfoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TemperatureUI()
                }
            }
        }
    }
}

@Composable
fun TemperatureUI(viewModel: WeatherInfoViewModel = hiltViewModel()) {
    //val viewModel = hiltViewModel<WeatherInfoViewModel>()
    viewModel.loadWeatherInfo()
    val temperatureData by viewModel.temperatureData.observeAsState()
    val size = temperatureData!!.temperature.data.size - 1
    var random = (0..size).random()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        temperatureData?.let {
            Text(text = "Location: ${it.temperature.data[random].place}")
            Text(text = "Temperature: ${it.temperature.data[random].value}C")
        }

        Button(onClick = {
            random = (0..size).random();
        }) {
            Text("Next Location")
        }
    }
}