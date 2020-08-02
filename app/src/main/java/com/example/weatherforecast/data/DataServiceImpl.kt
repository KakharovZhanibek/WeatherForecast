package com.example.weatherforecast.data

import android.content.Context
import com.google.common.base.Preconditions
import com.jumpou.weatherapp.util.Constants
import java.util.*


/**
 * Created by zimburg on 19/09/16.
 */
class DataServiceImpl private constructor(context: Context) : Constants,
    DataService {
    private var mTinyDB: TinyDB? = null
    override fun saveWeatherCities(weatherCities: ArrayList<String?>?) {
        mTinyDB.putListString(KEY_WEATHER_ARRAY_LIST, weatherCities)
    }

    override val weatherCities: ArrayList<String>
        get() = mTinyDB.getListString(KEY_WEATHER_ARRAY_LIST)

    companion object {
        private var INSTANCE: DataServiceImpl? = null
        fun getInstance(context: Context): DataServiceImpl? {
            if (INSTANCE == null) {
                INSTANCE = DataServiceImpl(context)
            }
            return INSTANCE
        }
    }

    init {
        Preconditions.checkNotNull(context)
        mTinyDB = TinyDB(context)
    }
}