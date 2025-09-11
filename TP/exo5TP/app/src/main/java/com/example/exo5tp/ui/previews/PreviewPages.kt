package com.example.exo5tp.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
//import com.example.exo1tp.ui.theme.DemoAndroidTheme
//import com.example.exo1tp.ui.screens.*
import com.example.exo5tp.ui.screens.ConnexionPage
import com.example.exo5tp.ui.screens.ForgotPasswordPage
import com.example.exo5tp.ui.screens.InscriptionPage
import com.example.exo5tp.ui.screens.ListeArticlesPage
import com.example.exo5tp.ui.screens.MainPage
import com.example.exo5tp.ui.theme.DemoAndroidTheme

@Preview(showBackground = true)
@Composable
fun PreviewConnexionPage() {
    DemoAndroidTheme { ConnexionPage(onNavigate = {}) }
}

@Preview(showBackground = true)
@Composable
fun PreviewInscriptionPage() {
    DemoAndroidTheme { InscriptionPage(onNavigate = {}) }
}

@Preview(showBackground = true)
@Composable
fun PreviewForgotPasswordPage() {
    DemoAndroidTheme { ForgotPasswordPage(onNavigate = {}) }
}

@Preview(showBackground = true)
@Composable
fun PreviewListeArticlesPage() {
    DemoAndroidTheme { ListeArticlesPage(onNavigate = {}) }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainPage() {
    DemoAndroidTheme { MainPage() }
}