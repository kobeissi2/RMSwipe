package com.kobeissidev.rmswipe.presentation.character.composables.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kobeissidev.rmswipe.data.model.character.Character
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.Swipe
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult
import kotlinx.coroutines.CoroutineScope

@Composable
fun CharacterLayout(
    scope: CoroutineScope,
    character: Character,
    swipe: Swipe,
    onChanged: (SwipeResult) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ImageSection(character = character)
        InfoCardSection(
            character = character,
            scope = scope,
            swipe = swipe,
            onChanged = onChanged
        )
    }
}