package org.ktor.ktorkmp.app.screens.goldprice

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.ktor.ktorkmp.app.components.CircleIndicator
import org.ktor.ktorkmp.app.components.MainLazyColumn
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
    {
        currencyPriceViewModel.getGoldPrice(true)
    }
}

@Composable
fun GoldPriceContent(
    goldState: Result<List<GoldPrice>>,
    onRefreshClick : () -> Unit = {}
) {

    Column {

        TopAppBarScreen{
            onRefreshClick()
        }

        SpacerVertical15()

        when (goldState) {
            is Result.Error -> {
                Text(text = goldState.message.toString())
            }

            is Result.Loading -> {
                CircleIndicator()
            }

            is Result.Success -> {

                Column {
                    MainRow("عيار")

                    MainLazyColumn(
                        list = goldState.data!!
                    )
                }
            }
        }
    }
}