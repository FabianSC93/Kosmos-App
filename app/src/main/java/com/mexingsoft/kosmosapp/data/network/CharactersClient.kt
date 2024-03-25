package com.mexingsoft.kosmosapp.data.network

import com.mexingsoft.kosmosapp.data.network.response.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharactersClient {

    @GET("character/?page=1")
    suspend fun getCharacters(): Response<CharactersResponse>
}