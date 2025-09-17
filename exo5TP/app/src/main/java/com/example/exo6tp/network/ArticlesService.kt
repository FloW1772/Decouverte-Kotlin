package com.example.exo6tp.network

import com.example.exo6tp.model.Article
import retrofit2.Response
import retrofit2.http.*

interface ArticleService {
    @GET("articles")
    suspend fun getArticles(): List<Article>

    @GET("article/{id}")
    suspend fun getArticleById(@Path("id") id: String): Article

    @POST("save-article")
    suspend fun saveArticle(@Body article: Article): Response<Article>

    @DELETE("article/{id}")
    suspend fun deleteArticle(@Path("id") id: String): Response<Unit>
}
