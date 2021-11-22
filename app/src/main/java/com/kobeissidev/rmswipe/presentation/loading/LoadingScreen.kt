package com.kobeissidev.rmswipe.presentation.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import com.kobeissidev.rmswipe.R.drawable

@Composable
fun LoadingScreen() {
    val painter = rememberImagePainter(data = drawable.bg_loading)

    Column(modifier = Modifier.fillMaxSize()) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.995f),
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}