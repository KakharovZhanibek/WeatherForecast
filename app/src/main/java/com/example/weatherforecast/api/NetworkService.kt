package com.example.weatherforecast.api

import android.provider.SyncStateContract
import com.sun.net.httpserver.Filter.Chain
import org.omg.PortableInterceptor.Interceptor
import javax.xml.ws.Response


class NetworkService private constructor(context: Context) {
    val weatherAPI: WeatherAPI

    companion object {
        private var INSTANCE: NetworkService? = null
        fun getInstance(context: Context): NetworkService? {
            if (INSTANCE == null) {
                INSTANCE = NetworkService(context)
            }
            return INSTANCE
        }
    }

    init {
        checkNotNull(context)
        val httpClient: OkHttpClient.Builder = Builder()
        httpClient.addInterceptor(object : Interceptor() {
            @Throws(IOException::class)
            fun intercept(chain: com.sun.net.httpserver.Filter.Chain): Response {
                val original: Request = chain.request()
                val originalHttpUrl: HttpUrl = original.url()
                val url: HttpUrl = originalHttpUrl.newBuilder()
                    .addQueryParameter("APPID", "488525857914c89234b2259c86caf061")
                    .addQueryParameter("lang", "fr")
                    .build()

                // Request customization: add request headers
                val requestBuilder: Request.Builder = original.newBuilder()
                    .url(url)
                val request: Request = requestBuilder.build()
                return chain.proceed(request)
            }
        })
        val retrofit: Retrofit = Builder()
            .baseUrl(SyncStateContract.Constants.API_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        weatherAPI = retrofit.create(WeatherAPI::class.java)
    }
}