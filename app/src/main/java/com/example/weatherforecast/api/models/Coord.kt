package com.example.weatherforecast.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Coord {
    @SerializedName("lon")
    @Expose
    var lon: Double? = null

    @SerializedName("lat")
    @Expose
    var lat: Double? = null
}