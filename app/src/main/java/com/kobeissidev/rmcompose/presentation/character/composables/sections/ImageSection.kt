package com.kobeissidev.rmswipe.presentation.character.composables.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.kobeissidev.rmswipe.data.model.character.Character

@Composable
fun ImageSection(character: Character) {
    Card(
        modifier = Modifier.padding(all = 16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Black,
        ),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.65f),
            painter = rememberImagePainter(
                character.image,
                builder = { crossfade(true) }
            ),
            contentDescription = character.name,
            contentScale = ContentScale.FillHeight
        )
    }
}