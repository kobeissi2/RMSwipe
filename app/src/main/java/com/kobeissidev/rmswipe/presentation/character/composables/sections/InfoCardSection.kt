package com.kobeissidev.rmswipe.presentation.character.composables.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kobeissidev.rmswipe.data.model.character.Character
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.Swipe
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult
import com.kobeissidev.rmswipe.util.capitalized
import kotlinx.coroutines.CoroutineScope

@Composable
fun InfoCardSection(
    character: Character,
    scope: CoroutineScope,
    swipe: Swipe,
    onChanged: (SwipeResult) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 4.dp
            ),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Black
        ),
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        with(character) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .padding(all = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${name.capitalized} | ${status.capitalized}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "${gender.capitalized} ${species.capitalized}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = location.name.capitalized,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                ActionButtonSection(
                    scope = scope,
                    swipe = swipe,
                    onChanged = onChanged
                )
            }
        }
    }
}
