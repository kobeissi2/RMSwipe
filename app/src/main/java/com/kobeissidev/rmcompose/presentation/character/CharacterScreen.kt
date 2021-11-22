package com.kobeissidev.rmswipe.presentation.character

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.kobeissidev.rmswipe.R
import com.kobeissidev.rmswipe.presentation.character.composables.header.MainHeader
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeCard
import com.kobeissidev.rmswipe.presentation.loading.LoadingScreen
import kotlinx.coroutines.delay

@Composable
fun CharacterScreen(viewModel: CharacterViewModel = hiltViewModel()) {
    var swipedCount by remember { mutableStateOf(0) }
    val characters by viewModel.characterFlow.collectAsState()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    if (swipedCount == characters.size) {
        LoadingScreen()
        LaunchedEffect(true) {
            delay(1000)
            if (characters.isNotEmpty()) {
                viewModel.fetchCharacter()
                swipedCount = 0
            }
        }
    } else {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { MainHeader() },
            content = {
                if (characters.isEmpty()) {
                    Text(stringResource(id = R.string.no_more_characters))
                } else {
                    characters.forEach { character ->
                        SwipeCard(
                            character = character,
                            scope = scope,
                            onSwiped = { result ->
                                viewModel.onSwiped(result, character)
                                swipedCount++
                            }
                        )
                    }
                }
            },
        )
    }
}
