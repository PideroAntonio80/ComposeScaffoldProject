package com.example.composescaffoldproject.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composescaffoldproject.model.MediaItem
import com.example.composescaffoldproject.ui.ComposeScaffoldApp

@ExperimentalFoundationApi
@Composable
fun MainScreen(onMediaClick: (MediaItem) -> Unit) {
    ComposeScaffoldApp {
        Scaffold(
            topBar = { MainAppBar() }
        ) { padding ->
            MediaList(onMediaClick = onMediaClick, modifier = Modifier.padding(padding))
        }
    }
}
