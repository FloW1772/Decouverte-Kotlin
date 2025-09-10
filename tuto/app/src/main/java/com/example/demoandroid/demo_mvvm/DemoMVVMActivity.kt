package com.example.demoandroid.demo_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoandroid.demo_2.TemplatePage

class DemoMVVMActivity : ComponentActivity() {

    lateinit var viewModel : CounterViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Instancier le view model
        viewModel = CounterViewModel()

        setContent {
            DemoMVVMPage(viewModel)
        }
    }
}

@Composable
fun DemoMVVMPage(viewModel : CounterViewModel) {

    // Ecouter les changements (à chaque changement ca rafraichit le composant)
    val counterState by viewModel.counter.collectAsState()

    TemplatePage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
            .fillMaxSize()
            .padding(60.dp)
            .padding(top = 250.dp)) {
            Text("Demo MVVM")
            Text("Valeur du compteur: ${counterState}")
            ElevatedButton(onClick = {
                // Incrementer
                viewModel.incrementCounter()
            },
                modifier = Modifier.fillMaxWidth()) {
                Text("Incrementer le compteur")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoMVVMPagePreview() {
    DemoMVVMPage(CounterViewModel())
}