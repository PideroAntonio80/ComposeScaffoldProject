package com.example.composescaffoldproject.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.composescaffoldproject.R
import com.example.composescaffoldproject.model.MediaItem
import com.example.composescaffoldproject.model.getMedia
import com.example.composescaffoldproject.ui.screens.shared.Thumb

@ExperimentalFoundationApi
@Composable
fun MediaList(onMediaClick: (MediaItem) -> Unit, modifier: Modifier = Modifier) {
    LazyVerticalGrid (
        cells = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        //verticalArrangement = Arrangement.spacedBy(4.dp)  <-- Esto si uso LazyColumn y lo de encima lo quitaría (cells)
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaListItem(item, onClick = {onMediaClick(item)} , Modifier.padding(dimensionResource(R.dimen.padding_xsmall)))
        }
    }
}

@Composable
fun MediaListItem(mediaItem: MediaItem, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
                        /******EMPEZAMOS AQUÍ******/
            .clickable(onClick = onClick)
    ) {
        Thumb(mediaItem)
        Title(mediaItem)
    }
}

@Composable
fun Title (mediaItem: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(R.dimen.padding_default))
    ) {
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.h6
        )
    }
}

/*@ExperimentalFoundationApi
@Preview
@Composable
fun MediaListPreview() {
    MediaList(navController)
}*/
