package com.example.exo6tp.network

import com.example.exo6tp.model.Article
import com.example.exo6tp.model.ArticlesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("articles")
    suspend fun getArticles(): ArticlesResponse

    @GET("article/{id}")
    suspend fun getArticle(@Path("id") id: String): Article

    @POST("save-article")
    suspend fun saveArticle(@Body article: Article): Article

    @DELETE("article/{id}")
    suspend fun deleteArticle(@Path("id") id: String)
}

// Singleton Retrofit
object ApiClient {

    private const val BASE_URL = "http://127.0.0.1:3000/" // Mets l'IP de ton PC + port serveur

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
