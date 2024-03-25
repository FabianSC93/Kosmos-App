package com.mexingsoft.kosmosapp.domain

import com.mexingsoft.kosmosapp.data.repository.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend fun GetCharacters() = characterRepository.getCharacters()
}