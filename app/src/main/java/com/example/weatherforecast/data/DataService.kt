package com.example.weatherforecast.data

interface DataService {
    fun saveWeatherCities(weatherCities: ArrayList<String?>?)
    val weatherCities: ArrayList<String?>?
}