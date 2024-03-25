package com.mexingsoft.kosmosapp.data.network.mapper

import androidx.compose.ui.res.stringResource
import com.mexingsoft.kosmosapp.R
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