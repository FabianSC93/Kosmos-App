package com.mexingsoft.kosmosapp.features.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexingsoft.kosmosapp.domain.GetCharactersUseCase
import com.mexingsoft.kosmosapp.domain.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private var _uiCharacterState = MutableStateFlow<CharactersViewState>(CharactersViewState.Start)
    val uiCharacterState = _uiCharacterState.asStateFlow()

    init {
        getCharacters()
    }

    private fun getCharacters(){
        viewModelScope.launch (Dispatchers.IO) {
            getCharactersUseCase.GetCharacters().collectLatest { result ->
                _uiCharacterState.value = when(result){
                    ResponseState.Loading -> CharactersViewState.Loading
                    is ResponseState.Success -> CharactersViewState.Success(result.result)
                    is ResponseState.Error -> CharactersViewState.Error(result.errorType)
                }
            }
        }
    }
}