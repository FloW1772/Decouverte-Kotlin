package com.example.demoandroid.demo_api

import com.example.demoandroid.demo_api.RetrofitTools.Companion.retrofit
import retrofit2.http.GET

interface MovieService {

    @GET("movies.json")
    suspend fun getMovies() : List<Movie>

    object MovieServiceApi {

        // Instancier une seule fois MovieService à l'aide de l'utilitiaire retrofit
        // Il faut utiliser l'utilitaire retrofit pour avoir le contexte de retrofit automatique
        val movieService : MovieService by lazy { retrofit.create(MovieService::class.java) }
    }
}