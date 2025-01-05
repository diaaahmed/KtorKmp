package org.ktor.ktorkmp.app.screens.goldprice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class GoldScreen : Screen {

    @Composable
    override fun Content() {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val navigator = LocalNavigator.current

            Text(text = "Gold price screen")
            Button(onClick = { navigator?.pop() }){

                Text(text = "Click to back ")
            }
        }
    }
}