package com.example.demoandroid.demo_2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.demoandroid.R
import com.example.demoandroid.ui.theme.DemoAndroidTheme

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(R.drawable.mobile_bg_01),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun TemplatePage(content: @Composable () -> Unit) {
    DemoAndroidTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                BackgroundImage()
                content()
            }
        }
    }
}
