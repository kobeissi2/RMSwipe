package com.kobeissidev.rmswipe.presentation.character.composables.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kobeissidev.rmswipe.R
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.Swipe
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult.ACCEPT
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult.REJECT
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ActionButtonSection(
    scope: CoroutineScope,
    swipe: Swipe,
    onChanged: (SwipeResult) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FloatingActionButton(
            modifier = Modifier.padding(end = 4.dp),
            onClick = {
                scope.launch {
                    swipe.rejected(scope)
                    delay(100)
                    onChanged(REJECT)
                }
            },
            backgroundColor = Color.Black,
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Filled.Close,
                contentDescription = stringResource(id = R.string.rejected),
                tint = Color.White
            )
        }
        FloatingActionButton(
            modifier = Modifier.padding(start = 4.dp),
            onClick = {
                scope.launch {
                    swipe.accepted(scope)
                    delay(100)
                    onChanged(ACCEPT)
                }
            },
            backgroundColor = Color.Black,
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Filled.Favorite,
                contentDescription = stringResource(id = R.string.accepted),
                tint = Color.Red
            )
        }
    }
}