package com.example.composescaffoldproject.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.composescaffoldproject.ui.theme.ComposeScaffoldProjectTheme

@Composable
fun ComposeScaffoldApp(content: @Composable () -> Unit) {
    ComposeScaffoldProjectTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}