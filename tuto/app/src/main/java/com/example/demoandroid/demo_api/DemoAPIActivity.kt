package com.example.demoandroid.demo_api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoandroid.demo_2.TemplatePage

class DemoAPIActivity : ComponentActivity() {

    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel = MovieViewModel()

        setContent {
            DemoAPIPage(viewModel)
        }
    }
}

@Composable
fun DemoAPIPage(viewModel: MovieViewModel) {
    // Ecouter la liste des films
    val moviesState by viewModel.movies.collectAsState()

    TemplatePage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(60.dp)
                .padding(top = 250.dp)
        ) {
            Text("Demo API (List Movies)")
            ElevatedButton(
                onClick = {
                    viewModel.callMovieApi()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Appel API")
            }
            LazyColumn {
                items(moviesState) { movie ->
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        Text(movie.title, modifier = Modifier.padding(10.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoMVVMPagePreview() {
    DemoAPIPage(MovieViewModel())
}