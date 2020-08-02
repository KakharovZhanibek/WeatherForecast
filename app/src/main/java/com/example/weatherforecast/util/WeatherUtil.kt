package com.example.weatherforecast.util

object WeatherUtil {
    fun convertKelvinInCelsius(kelvin: Double): Float {
        return (kelvin - 273.15).toFloat()
    }

    fun convertKelvinInFar(kelvin: Double): Float {
        return ((convertKelvinInCelsius(kelvin) - 32) / 1.8).toFloat()
    }

    fun getWeatherIcon(weatherIconAPI: String?): String {
        val weatherIcon: String
        weatherIcon = when (weatherIconAPI) {
            "01d" -> "sw_01"
            "01n" -> "sw_02"
            "02d" -> "sw_03"
            "02n" -> "sw_07"
            "03d" -> "sw_04"
            "03n" -> "sw_04"
            "04d" -> "sw_06"
            "04n" -> "sw_06"
            "09d" -> "sw_23"
            "09n" -> "sw_23"
            "10d" -> "sw_12"
            "10n" -> "sw_32"
            "11d" -> "sw_17"
            "11n" -> "sw_37"
            "12d" -> "sw_15"
            "12n" -> "sw_35"
            "13d" -> "sw_10"
            "13n" -> "sw_30"
            else -> "error_icon"
        }
        return weatherIcon
    }
}