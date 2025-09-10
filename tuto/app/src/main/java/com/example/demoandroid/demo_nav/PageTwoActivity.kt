package com.example.demoandroid.demo_nav

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoandroid.ui.theme.DemoAndroidTheme

class PageTwoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PageTwo()
        }
    }
}

@Composable
fun PageTwo() {
    val context = LocalContext.current  // ✅ récupérer le contexte

    DemoAndroidTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
                    .padding(innerPadding)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp)
                ) {
                    Text("Page 2")

                    ElevatedButton(
                        onClick = {
                            // ✅ utilisation correcte du contexte
                            val intent = Intent(context, PageOneActivity::class.java)
                            context.startActivity(intent)
                        },                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Revenir sur la page 1")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageTwoPreview() {
    PageTwo()
}