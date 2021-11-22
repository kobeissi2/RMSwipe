package com.kobeissidev.rmswipe.presentation.character.composables.header

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kobeissidev.rmswipe.R
import com.kobeissidev.rmswipe.presentation.character.CharacterViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainHeader(viewModel: CharacterViewModel = hiltViewModel()) {
    var showRejected by remember { mutableStateOf(false) }
    var showAccepted by remember { mutableStateOf(false) }
    val acceptedSize by viewModel.acceptedCountFlow.collectAsState(initial = 0)
    val rejectedSize by viewModel.rejectedCountFlow.collectAsState(initial = 0)
    val acceptedList by viewModel.allAcceptedCharactersFlow.collectAsState(initial = listOf())
    val rejectedList by viewModel.allRejectedCharactersFlow.collectAsState(initial = listOf())

    TopAppBar(
        elevation = 8.dp,
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = {
            if (rejectedSize != 0) {
                IconButton(onClick = {
                    showRejected = false
                    showRejected = true
                }) {
                    BadgeBox(badgeContent = { Text("$rejectedSize") }) {
                        Icon(
                            imageVector = Filled.Close,
                            contentDescription = stringResource(id = R.string.rejected)
                        )
                    }
                }
            }
            if (acceptedSize != 0) {
                IconButton(onClick = {
                    showAccepted = true
                    showRejected = false
                }) {
                    BadgeBox(badgeContent = { Text("$acceptedSize") }) {
                        Icon(
                            imageVector = Outlined.Favorite,
                            contentDescription = stringResource(id = R.string.accepted)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    )

    PopupDialog(
        shouldShow = showAccepted,
        iconVector = Outlined.Favorite,
        list = acceptedList
    ) { showAccepted = false }

    PopupDialog(
        shouldShow = showRejected,
        iconVector = Filled.Close,
        list = rejectedList
    ) { showRejected = false }
}