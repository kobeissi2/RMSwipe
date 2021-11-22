package com.kobeissidev.rmswipe.presentation.character.composables.swipe

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Original source: https://github.com/cyph3rcod3r/Tinder-Like
 * Modified it to meet my usecase
 * Setting the offset with animation
 */
class Swipe(val maxWidth: Float, val maxHeight: Float) {

    val offsetX = Animatable(0f)
    val offsetY = Animatable(0f)

    fun reset(scope: CoroutineScope) = scope.launch {
        launch { offsetX.animateTo(0f, tween(400)) }
        launch { offsetY.animateTo(0f, tween(400)) }
    }

    fun accepted(scope: CoroutineScope) = scope.launch { offsetX.animateTo(maxWidth * 2, tween(400)) }

    fun rejected(scope: CoroutineScope) = scope.launch { offsetX.animateTo(-(maxWidth * 2), tween(400)) }

    fun drag(scope: CoroutineScope, x: Float, y: Float) = scope.launch {
        launch { offsetX.animateTo(x) }
        launch { offsetY.animateTo(y) }
    }
}