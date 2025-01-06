package org.ktor.ktorkmp.app.screens.goldprice

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel

class GoldScreen : Screen {

    @Composable
    override fun Content() {
        val currencyPriceViewModel = koinScreenModel<GoldPriceViewModel>()
        GoldPriceScreen(currencyPriceViewModel)
    }
}