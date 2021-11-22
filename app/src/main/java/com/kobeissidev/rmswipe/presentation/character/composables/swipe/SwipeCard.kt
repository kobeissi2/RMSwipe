package com.kobeissidev.rmswipe.presentation.character.composables.swipe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.kobeissidev.rmswipe.data.model.character.Character
import com.kobeissidev.rmswipe.presentation.character.composables.sections.CharacterLayout
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult.ACCEPT
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult.REJECT
import kotlinx.coroutines.CoroutineScope

/**
 * Original source: https://github.com/cyph3rcod3r/Tinder-Like
 * Modified it to meet my usecase
 */
@Composable
fun SwipeCard(
    character: Character,
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
    onSwiped: (result: SwipeResult) -> Unit
) {
    var swiped by remember { mutableStateOf(false) }

    BoxWithConstraints(modifier = modifier) {
        val swipeState = remember {
            Swipe(
                maxWidth = constraints.maxWidth.toFloat(),
                maxHeight = constraints.maxHeight.toFloat()
            )
        }

        if (swiped.not()) {
            Box(
                modifier = Modifier.swiper(
                    scope = scope,
                    state = swipeState,
                    onDragAccepted = {
                        swiped = true
                        onSwiped(ACCEPT)
                    },
                    onDragRejected = {
                        swiped = true
                        onSwiped(REJECT)
                    }
                ),
                content = {
                    CharacterLayout(
                        character = character,
                        scope = scope,
                        swipe = swipeState,
                        onChanged = {
                            swiped = true
                            onSwiped(it)
                        }
                    )
                }
            )
        }
    }
}