package org.ktor.ktorkmp.app.screens.currencyprice

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class CurrencyScreen : Screen {

    @Composable
    override fun Content() {
        CurrencyPriceScreen()
    }
}