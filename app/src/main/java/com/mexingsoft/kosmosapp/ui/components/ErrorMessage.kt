package com.mexingsoft.kosmosapp.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mexingsoft.kosmosapp.R
import com.mexingsoft.kosmosapp.domain.DataResultError

@Composable
fun ErrorMessage(
    type: DataResultError
) {
    when (type) {
        DataResultError.NoInternet -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.message_no_internet),
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_no_internet),
                    contentDescription = "No Connexion"
                )
            }

        }
        DataResultError.EmptyResult -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.message_empty_result),
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_empty_result),
                    contentDescription = "No Result"
                )
            }
        }
        else -> {

        }
    }
}