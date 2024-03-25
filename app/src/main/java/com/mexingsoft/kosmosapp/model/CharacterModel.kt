package com.mexingsoft.kosmosapp.model

import com.mexingsoft.kosmosapp.data.network.response.Location
import com.mexingsoft.kosmosapp.data.network.response.Origin

data class CharacterModel(
    val image: String,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
)