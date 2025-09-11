package com.example.demoandroid.demo_api
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    // Films ecoutable pour refresh la page
    // Vide par défaut
    var movies = MutableStateFlow<List<Movie>>(mutableListOf())

    fun callMovieApi(){

        // Il faut lancer une tâche async (dans un view model)
        viewModelScope.launch {

            // Appel l'api
            // Ecrase la liste des films par celle récupéré depuis l'api
            movies.value = MovieService.MovieServiceApi.movieService.getMovies()
        }
    }
}