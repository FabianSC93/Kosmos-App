package com.mexingsoft.kosmosapp.features.characters

import com.mexingsoft.kosmosapp.domain.DataResultError
import com.mexingsoft.kosmosapp.model.CharacterModel

sealed class CharactersViewState {
    data object Start : CharactersViewState()
    data object Loading : CharactersViewState()
    data class Error(val type: DataResultError) : CharactersViewState()
    data class Success(val data: List<CharacterModel>) : CharactersViewState()
}