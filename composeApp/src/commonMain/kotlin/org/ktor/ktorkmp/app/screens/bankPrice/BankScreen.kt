package org.ktor.ktorkmp.app.screens.bankPrice

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel

class BankScreen : Screen {

    @Composable
    override fun Content() {
        val bankViewModel = koinScreenModel<BankPriceViewModel>()
        BankPriceScreen(bankViewModel)
    }
}