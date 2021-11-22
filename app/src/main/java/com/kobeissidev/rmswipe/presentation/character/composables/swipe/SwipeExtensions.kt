package com.kobeissidev.rmswipe.presentation.character.composables.swipe

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.CoroutineScope
import kotlin.math.abs

/**
 * Original source: https://github.com/cyph3rcod3r/Tinder-Like
 * Modified it to meet my usecase
 * Actual custom Modifier which handles the transition states from drog start to drag end
 * As mentioned in android dev blog here: https://developer.android.com/jetpack/compose/gestures#dragging
 * detectDragGestures has been used to continuously listen to touch pointer and perform action on drag events
 */
@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.swiper(
    scope: CoroutineScope,
    state: Swipe,
    onDragReset: () -> Unit = {},
    onDragAccepted: () -> Unit,
    onDragRejected: () -> Unit
) = composed {
    Modifier
        .pointerInput(Unit) {
            detectDragGestures(
                onDragEnd = {
                    when {
                        abs(state.offsetX.targetValue) < state.maxWidth / 4 -> {
                            state
                                .reset(scope)
                                .invokeOnCompletion { onDragReset() }
                        }
                        state.offsetX.targetValue > 0 -> {
                            state
                                .accepted(scope)
                                .invokeOnCompletion { onDragAccepted() }
                        }
                        state.offsetX.targetValue < 0 -> {
                            state
                                .rejected(scope)
                                .invokeOnCompletion { onDragRejected() }
                        }
                    }
                },
                onDrag = { change, dragAmount ->
                    val original = Offset(state.offsetX.targetValue, state.offsetY.targetValue)
                    val summed = original + dragAmount
                    val newValue = Offset(
                        x = summed.x.coerceIn(-state.maxWidth, state.maxWidth),
                        y = summed.y.coerceIn(-state.maxHeight, state.maxHeight)
                    )
                    change.consumePositionChange()
                    state.drag(scope, newValue.x, newValue.y)
                }
            )
        }
        /**
         * Doing translation on the graphics layer
         * which mimics the rotation and translation of tinder swipe-able card. This can be improved
         * if I start swiping a card it first rotates along edges left or right according to drag and
         * slowly decrease alpha to look it more like dismissing
         */
        .graphicsLayer(
            translationX = state.offsetX.value,
            translationY = state.offsetY.value,
            rotationZ = (state.offsetX.value / 60).coerceIn(-40f, 40f),
            alpha = ((state.maxWidth - abs(state.offsetX.value)) / state.maxWidth).coerceIn(0f, 1f)
        )
}