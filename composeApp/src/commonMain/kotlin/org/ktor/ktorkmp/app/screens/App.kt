package org.ktor.ktorkmp.app.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.ktor.ktorkmp.app.screens.currencyprice.CurrencyPriceScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        CurrencyPriceScreen()
    }
}