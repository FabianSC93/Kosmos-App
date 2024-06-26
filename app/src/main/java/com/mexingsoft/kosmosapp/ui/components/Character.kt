package com.mexingsoft.kosmosapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mexingsoft.kosmosapp.R

/**
 * Este componente contendrá al personaje de la serie, mostrando su información
 */
@Composable
fun Character(
    image: String,
    name: String,
    status: String,
    species: String,
    type: String,
    gender: String,
    origin: String,
    location: String
) {
    var showDetail by remember {
        mutableStateOf(false)
    }
    Card {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .width(350.dp)
                    .padding(8.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.image_character)
            )

            Text(
                modifier = Modifier.padding(8.dp),
                text = name,
            )

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = { showDetail = !showDetail }) {
                Text(
                    text = if (showDetail) stringResource(id = R.string.hide_detail)
                    else stringResource(id = R.string.show_detail)
                )
            }

            /**
             * Se valida si el botón a sido presionado para saber si mostrar la información adicional o no
             */

            if(showDetail){
                Column {
                    Text(modifier = Modifier.padding(4.dp), text = stringResource(id = R.string.status, status))
                    Text(modifier = Modifier.padding(4.dp),text = stringResource(id = R.string.species, species))
                    Text(modifier = Modifier.padding(4.dp),text = stringResource(id = R.string.type, type))
                    Text(modifier = Modifier.padding(4.dp),text = stringResource(id = R.string.gender, gender))
                    Text(modifier = Modifier.padding(4.dp),text = stringResource(id = R.string.origin, origin))
                    Text(modifier = Modifier.padding(4.dp),text = stringResource(id = R.string.location, location))
                }
            }
        }
    }
}

/**
 * Se agrega la preview para visualizar el componente
 */
@Preview(showSystemUi = true)
@Composable
fun PrevCharacter() {
    Character(
        image = "",
        name = "Ricky",
        status = "Vivo",
        species = "Humano",
        type = "Desconocido",
        gender = "Hombre",
        origin = "Tierra",
        location = "Tierra"
    )
}