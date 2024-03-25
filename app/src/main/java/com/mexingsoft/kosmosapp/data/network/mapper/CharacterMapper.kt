package com.mexingsoft.kosmosapp.data.network.mapper

import com.mexingsoft.kosmosapp.data.network.response.CharacterResponse
import com.mexingsoft.kosmosapp.model.CharacterModel

fun CharacterResponse.toCharacterModel() = CharacterModel(
    image = image,
    name = name,
    status = status,
    species = species,
    type = type ?: "Desconocido",
    gender = gender,
    origin = origin,
    location = location
)