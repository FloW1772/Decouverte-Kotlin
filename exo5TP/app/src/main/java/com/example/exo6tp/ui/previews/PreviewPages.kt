package com.example.exo6tp.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.exo6tp.ui.screens.ListeArticlesPage

@Preview(showBackground = true)
@Composable
fun PreviewListeArticlesPage() {
    ListeArticlesPage() // Pas besoin de passer onNavigate ici grâce à la valeur par défaut
}
