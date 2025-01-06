package org.ktor.ktorkmp.app.screens.currencyprice

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel

class CurrencyScreen : Screen {

    @Composable
    override fun Content() {
        val currencyPriceViewModel = koinScreenModel<CurrencyPriceViewModel>()
        CurrencyPriceScreen(currencyPriceViewModel)
    }
}