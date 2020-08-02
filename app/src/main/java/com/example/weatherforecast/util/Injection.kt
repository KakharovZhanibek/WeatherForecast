package com.example.weatherforecast.util

import android.content.Context
import com.example.weatherforecast.api.NetworkService
import com.example.weatherforecast.data.DataServiceImpl
import com.google.common.base.Preconditions

object Injection {
    fun provideNetworkService(context: Context): NetworkService? {
        Preconditions.checkNotNull(context)
        return NetworkService.getInstance(context)
    }

    fun provideDataService(context: Context): DataServiceImpl? {
        Preconditions.checkNotNull(context)
        return DataServiceImpl.getInstance(context)
    }
}