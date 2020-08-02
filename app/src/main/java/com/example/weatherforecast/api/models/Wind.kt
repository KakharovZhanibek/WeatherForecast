package com.example.weatherforecast.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Wind {
    @SerializedName("speed")
    @Expose
    var speed: Float? = null

    @SerializedName("deg")
    @Expose
    var deg: Float? = null
}