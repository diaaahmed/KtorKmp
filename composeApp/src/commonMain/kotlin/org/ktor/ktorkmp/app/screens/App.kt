package org.ktor.ktorkmp.app.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.ktor.ktorkmp.app.screens.currencyprice.CurrencyPriceScreen
import org.ktor.ktorkmp.app.screens.currencyprice.CurrencyScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(CurrencyScreen())
        // CurrencyPriceScreen()
    }
}