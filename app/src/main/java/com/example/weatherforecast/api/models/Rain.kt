package com.example.weatherforecast.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by zimburg on 19/09/16.
 */
class Rain {
    @SerializedName("3h")
    @Expose
    var rainLevelLastThreeHours: Float? = null
}