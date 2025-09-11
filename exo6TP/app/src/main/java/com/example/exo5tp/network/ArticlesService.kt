package com.example.exo5tp.network

import com.example.exo5tp.model.Article
import retrofit2.http.GET

interface ArticleService {
    @GET("articles.json")
    suspend fun getArticles(): List<Article>
}
