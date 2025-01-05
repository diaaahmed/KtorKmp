package org.ktor.ktorkmp.app.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import ktorkmp.composeapp.generated.resources.Res
import ktorkmp.composeapp.generated.resources.ic_home
import org.jetbrains.compose.resources.painterResource
import org.ktor.ktorkmp.app.screens.currencyprice.CurrencyScreen

object CurrencyTab: Tab {

    @Composable
    override fun Content()
    {
        Navigator(CurrencyScreen())
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.ic_home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Currency",
                    icon = icon
                )
            }
        }
}