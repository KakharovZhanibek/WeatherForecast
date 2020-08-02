package com.example.weatherforecast.addweather

import android.R
import com.example.weatherforecast.addweather.AddWeatherContract.Presenter


class AddWeatherPresenter(
    view: AddWeatherContract.View,
    weatherAPI: WeatherAPI,
    dataService: DataServiceImpl
) :
    Presenter {
    private val mView: AddWeatherContract.View
    private val mWeatherAPI: WeatherAPI
    private val mDataService: DataServiceImpl
    private var isDoingRequest = false
    override fun addCity(city: String?) {
        if (mView.isActive() && !isDoingRequest) {
            isDoingRequest = true
            mView.displayLoadingIndicator(true)
            val call: Call<WeatherData> = mWeatherAPI.getWeatherCity(city)
            call.enqueue(object : Callback<WeatherData?>() {
                fun onResponse(
                    call: Call<WeatherData?>?,
                    response: Response<WeatherData?>
                ) {
                    if (response.isSuccessful()) {
                        if (response.body().cod === 200) {
                            val weatherCities: ArrayList<String?>
                            weatherCities =
                                if (mDataService.getWeatherCities() != null) mDataService.getWeatherCities() else ArrayList()
                            weatherCities.add(city)
                            mDataService.saveWeatherCities(weatherCities)
                            mView.closeView()
                        } else {
                            mView.displayErrorMessage(R.string.country_not_found)
                        }
                    } else {
                        mView.displayErrorMessage(R.string.error_msg_internet)
                    }
                    isDoingRequest = false
                    mView.displayLoadingIndicator(false)
                }

                fun onFailure(call: Call<WeatherData?>?, t: Throwable?) {
                    mView.displayErrorMessage(R.string.error_msg_internet)
                    isDoingRequest = false
                    mView.displayLoadingIndicator(false)
                }
            })
        }
    }

    fun start() {}

    init {
        mView = checkNotNull(view, "AddWeatherView cannot be null!")
        mWeatherAPI = checkNotNull(weatherAPI, "WeatherAPI cannot be null!")
        mDataService = checkNotNull(dataService, "DataService cannot be null!")
        mView.setPresenter(this)
    }
}