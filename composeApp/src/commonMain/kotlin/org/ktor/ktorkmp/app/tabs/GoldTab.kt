package org.ktor.ktorkmp.app.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import ktorkmp.composeapp.generated.resources.Res
import ktorkmp.composeapp.generated.resources.ic_explore
import ktorkmp.composeapp.generated.resources.ic_gold_new_item
import org.jetbrains.compose.resources.painterResource
import org.ktor.ktorkmp.app.screens.goldprice.GoldScreen

object GoldTab: Tab {

    @Composable
    override fun Content()
    {
       Navigator(GoldScreen())
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(Res.drawable.ic_gold_new_item)

            return remember {
                TabOptions(
                    index = 1u,
                    title = "Gold",
                    icon = icon
                )
            }
        }
}