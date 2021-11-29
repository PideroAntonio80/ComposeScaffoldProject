package com.example.composescaffoldproject.ui.screens.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.rememberImagePainter
import com.example.composescaffoldproject.R
import com.example.composescaffoldproject.model.MediaItem

@Composable
fun Thumb(mediaItem: MediaItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(dimensionResource(R.dimen.box_image_icon_height))
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(
                data = mediaItem.thumb,
                /* Esto de debajo por si quiero darle forma redonda a la foto y efecto de fading
                builder = {
                    transformations(CircleCropTransformation())
                    crossfade(true)
                }*/
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        if (mediaItem.type == MediaItem.Type.VIDEO) {
            Icon(
                imageVector = Icons.Default.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.icon_size))
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
    }
}