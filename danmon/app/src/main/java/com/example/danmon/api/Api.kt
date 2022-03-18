package com.example.danmon.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.MINUTES

object ApiService {
    private var retrofit: Retrofit? = null
    val client: Retrofit
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client =
                OkHttpClient.Builder().connectTimeout(2, MINUTES).writeTimeout(2, MINUTES).readTimeout(2, MINUTES)
                    .addInterceptor(interceptor).build()

            retrofit =
                Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory
                    .create())
                    .client(client).build()
            return retrofit!!
        }
}