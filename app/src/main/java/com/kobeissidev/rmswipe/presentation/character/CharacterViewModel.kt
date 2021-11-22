package com.kobeissidev.rmswipe.presentation.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kobeissidev.rmswipe.data.model.character.Character
import com.kobeissidev.rmswipe.domain.repository.RMRepository
import com.kobeissidev.rmswipe.domain.usecase.*
import com.kobeissidev.rmswipe.presentation.character.composables.swipe.SwipeResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: RMRepository,
    private val getNextCharacters: GetNextCharacters,
    private val updateCharacter: UpdateCharacter,
    private val getAcceptedCount: GetAcceptedCount,
    private val getRejectedCount: GetRejectedCount,
    private val getAllAcceptedCharacters: GetAllAcceptedCharacters,
    private val getAllRejectedCharacters: GetAllRejectedCharacters,
    getCharacterCount: GetCharacterCount
) : ViewModel() {

    val allAcceptedCharactersFlow get() = getAllAcceptedCharacters()
    val allRejectedCharactersFlow get() = getAllRejectedCharacters()
    val acceptedCountFlow get() = getAcceptedCount()
    val rejectedCountFlow get() = getRejectedCount()
    val characterFlow get() = repository.characterFlow

    init {
        viewModelScope.launch { getCharacterCount { fetchCharacter() } }
    }

    fun fetchCharacter() = viewModelScope.launch { getNextCharacters() }
    fun onSwiped(result: SwipeResult, character: Character) = viewModelScope.launch { updateCharacter(character, result) }
}