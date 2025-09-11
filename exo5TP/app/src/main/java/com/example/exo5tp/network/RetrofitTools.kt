package com.example.exo5tp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitTools {
    private const val BASE_URL = "https://raw.githubusercontent.com/Chocolaterie/EniWebService/refs/heads/main/api/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
