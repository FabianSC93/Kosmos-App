package com.mexingsoft.kosmosapp.features.characters

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mexingsoft.kosmosapp.R
import com.mexingsoft.kosmosapp.domain.DataResultError
import com.mexingsoft.kosmosapp.model.CharacterModel
import com.mexingsoft.kosmosapp.ui.components.Character
import com.mexingsoft.kosmosapp.ui.components.ErrorMessage
import com.mexingsoft.kosmosapp.ui.components.Loading

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = viewModel()
) {
    var characters by remember {
        mutableStateOf(emptyList<CharacterModel>())
    }

    var isLoading by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<DataResultError>(DataResultError.NoError) }


    viewModel.uiCharacterState.collectAsState().value.let {
        when (it) {
            is CharactersViewState.Error -> {
                error = it.type
                isError = true
                isLoading = false
            }

            CharactersViewState.Loading -> {
                isLoading = true
            }

            CharactersViewState.Start -> {
                Log.i("CharactersScreen", "Start")
            }

            is CharactersViewState.Success -> {
                characters = it.data
                isLoading = false
                isError = false
            }
        }
    }


    Scaffold() {
        when {
            isError -> {
                ErrorMessage(type = error)
            }

            isLoading -> {
                Loading()
            }

            else -> {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    text = stringResource(id = R.string.ricky_and_morty),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                LazyRow(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(characters){
                        Character(
                            image = it.image,
                            name = it.name,
                            status = it.status,
                            species = it.species,
                            type = it.type,
                            gender = it.gender,
                            origin = it.origin.name,
                            location = it.location.name
                        )
                    }
                }
            }
        }
    }
}