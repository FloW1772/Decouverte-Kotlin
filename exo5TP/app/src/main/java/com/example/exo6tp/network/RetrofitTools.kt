package com.example.exo6tp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitTools {
    private const val BASE_URL =
        "https://raw.githubusercontent.com/Chocolaterie/EniWebService/main/api/"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL) // <- IMPORTANT : se termine toujours par /
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
