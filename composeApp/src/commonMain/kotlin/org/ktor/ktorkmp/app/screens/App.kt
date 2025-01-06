package org.ktor.ktorkmp.app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import network.chaintech.sdpcomposemultiplatform.sdp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.ktor.ktorkmp.app.tabs.CurrencyTab
import org.ktor.ktorkmp.app.tabs.GoldTab

@Composable
@Preview
fun App() {
    MaterialTheme {
     //   Navigator(CurrencyScreen())

        TabNavigator(CurrencyTab)
        {
            Scaffold(
                content = {
                    Box(
                        modifier = Modifier
                            .padding(it)
                    ) {

                        CurrentTab()
                    }
                },
                bottomBar = {
                    BottomNavigation(
                        backgroundColor = Color(0xFFD0956F),
                        modifier = Modifier
                            .padding(
                                horizontal = 30.sdp,
                                vertical = 6.sdp
                            )
                            .clip(shape = RoundedCornerShape(10.sdp))
                    ) {

                        TabNavigationItem(CurrencyTab)
                        TabNavigationItem(GoldTab)
                    }
                }
            )
        }

    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        label = { Text(text = tab.options.title) },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter = it,
                    contentDescription = tab.options.title,
                )
            }
        }
    )
}