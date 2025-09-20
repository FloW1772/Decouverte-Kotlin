package com.example.demoandroid.demo_nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class DemoNavHostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoNavHost()
        }
    }
}

@Composable
fun DemoNavHost() {

    val navController = rememberNavController()
    // Changer de page
    // navController.navigate("page-two")

    NavHost(
        navController = navController,
        startDestination = "page-one"
    ){
        composable("page-one") { NavPageOne() }
        composable("page-two") { NavPageTwo() }
    }
}

@Composable
fun NavPageOne() {
    Text("One")
}

@Composable
fun NavPageTwo() {
    Text("Two")
}

@Preview(showBackground = true)
@Composable
fun DemoNavHostPreview() {
    DemoNavHost()
}