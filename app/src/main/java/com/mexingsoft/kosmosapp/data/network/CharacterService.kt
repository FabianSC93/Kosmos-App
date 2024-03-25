package com.mexingsoft.kosmosapp.data.network

import com.mexingsoft.kosmosapp.data.network.response.CharacterResponse
import javax.inject.Inject

class CharacterService @Inject constructor(
    private val charactersClient: CharactersClient
) {
    suspend fun getCharacters(): List<CharacterResponse>{
        val response = charactersClient.getCharacters().body()?.results
        return response ?: emptyList()
    }
}