package com.example.exo4tp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
//import com.example.exo1tp.ui.theme.DemoAndroidTheme
//import com.example.exo1tp.ui.screens.MainPage
import com.example.exo4tp.ui.screens.MainPage
import com.example.exo4tp.ui.theme.DemoAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAndroidTheme {
                MainPage()
            }
        }
    }
}
