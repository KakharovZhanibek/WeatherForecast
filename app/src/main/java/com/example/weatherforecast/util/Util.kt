package com.example.weatherforecast.util

import android.content.res.Resources
import android.graphics.drawable.Drawable

object Util {
    fun getDrawable(
        name: String?,
        resources: Resources,
        packageName: String?
    ): Drawable {
        val resourceId = resources.getIdentifier(name, "drawable", packageName)
        return resources.getDrawable(resourceId)
    }
}