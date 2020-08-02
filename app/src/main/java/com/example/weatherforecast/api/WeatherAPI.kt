package com.example.weatherforecast.api

import android.telecom.Call
import jdk.nashorn.internal.runtime.PropertyDescriptor.GET

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherAPI {
    @GET("weather")
    fun getWeatherCity(@Query("q") city: String?): Call<WeatherData?>?
}
