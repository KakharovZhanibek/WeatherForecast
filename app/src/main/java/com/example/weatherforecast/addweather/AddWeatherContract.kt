package com.example.weatherforecast.addweather

import com.example.weatherforecast.BasePresenter
import com.example.weatherforecast.BaseView

class AddWeatherContract {
    internal interface View : BaseView<Presenter?> {
        fun closeView()
        fun displayErrorMessage(stringRessource: Int)
        fun displayLoadingIndicator(isVisible: Boolean?)
    }

    internal interface Presenter : BasePresenter {
        fun addCity(city: String?)
    }
}