package com.example.weatherforecast.data

import com.jumpou.weatherapp.util.WeatherUtil


/**
 * Created by zimburg on 18/09/16.
 */
class WeatherItem {
    val city: String
    val img: String
    val degreeCelsius: Float
    private val mHumidity: Int
    val rainLevel: Float
    val wind: Float

    constructor(
        city: String,
        img: String,
        degreeCelsius: Float,
        humidity: Int,
        rainLevel: Float,
        wind: Float
    ) {
        this.city = city
        this.img = img
        this.degreeCelsius = degreeCelsius
        mHumidity = humidity
        this.rainLevel = rainLevel
        this.wind = wind
    }

    constructor(
        city: String,
        img: String,
        kelvin: Double,
        humidity: Int,
        rainLevel: Float,
        wind: Float
    ) {
        this.city = city
        this.img = img
        degreeCelsius = WeatherUtil.convertKelvinInCelsius(kelvin)
        mHumidity = humidity
        this.rainLevel = rainLevel
        this.wind = wind
    }

    val humidity: Float
        get() = mHumidity.toFloat()

}