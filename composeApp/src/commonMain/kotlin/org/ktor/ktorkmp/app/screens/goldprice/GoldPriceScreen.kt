package org.ktor.ktorkmp.app.screens.goldprice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.ktor.ktorkmp.app.components.GoldPriceItem
import org.ktor.ktorkmp.app.components.MainRow
import org.ktor.ktorkmp.app.components.SpacerVertical15
import org.ktor.ktorkmp.app.components.TopAppBarScreen
import org.ktor.ktorkmp.domain.entity.GoldPrice
import org.ktor.ktorkmp.domain.util.Result

@Composable
fun GoldPriceScreen(
    currencyPriceViewModel: GoldPriceViewModel
) {

    val currencyState by currencyPriceViewModel.goldPriceState.collectAsState()

    GoldPriceContent(currencyState)
}

@Composable
fun GoldPriceContent(
    goldState: Result<List<GoldPrice>>,
) {

    Column {

        TopAppBarScreen()

        SpacerVertical15()

        when (goldState) {
            is Result.Error -> {
                Text(text = goldState.message.toString())
            }

            is Result.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is Result.Success -> {

                Column {
                    MainRow("عيار")

                    LazyColumn {
                        items(goldState.data!!)
                        {
                            GoldPriceItem(
                                item = it
                            )
                        }
                    }
                }
            }
        }
    }
}