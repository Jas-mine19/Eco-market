package com.example.eco_market

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Api {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    private val retrofit = Retrofit
        .Builder()
        .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
        .baseUrl("http://142.93.101.70:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): ApiInterface {

        return retrofit.create(ApiInterface::class.java)

    }
}