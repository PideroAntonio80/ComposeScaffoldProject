package com.example.composescaffoldproject.ui.screens.detail

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composescaffoldproject.model.getMedia
import com.example.composescaffoldproject.ui.screens.shared.ArrowBackIcon
import com.example.composescaffoldproject.ui.screens.shared.Thumb

@Composable
fun DetailScreen(mediaId: Int, onUpClick: () -> Unit) {
    /*Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Detail Screen $mediaId",
            style = MaterialTheme.typography.h4
        )
    }*/
    val mediaItem = remember { getMedia().first {it.id == mediaId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick) }
            )
        }
    ) { padding ->
        Thumb(mediaItem = mediaItem,
            Modifier
                .padding(padding)
                .height(400.dp))
    }
}