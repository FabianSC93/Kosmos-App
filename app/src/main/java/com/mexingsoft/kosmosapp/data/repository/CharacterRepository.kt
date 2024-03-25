package com.mexingsoft.kosmosapp.data.repository

import android.content.Context
import com.mexingsoft.kosmosapp.data.network.CharacterService
import com.mexingsoft.kosmosapp.data.network.mapper.toCharacterModel
import com.mexingsoft.kosmosapp.domain.DataResultError
import com.mexingsoft.kosmosapp.domain.ResponseState
import com.mexingsoft.kosmosapp.utils.Internet
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterService: CharacterService,
    private val context: Context
) {
    suspend fun getCharacters() = flow {
        if(Internet.isConnectedToInternet(context)){
            emit(ResponseState.Loading)
            characterService.getCharacters().let {
                if(it.isNotEmpty()){
                    it.map {characterResponse ->
                        characterResponse.toCharacterModel()
                    }.let { list ->
                        emit(ResponseState.Success(list))
                    }
                }else{
                    emit(ResponseState.Error(DataResultError.EmptyResult))
                }
            }
        }else{
            emit(ResponseState.Error(DataResultError.NoInternet))
        }
    }
}