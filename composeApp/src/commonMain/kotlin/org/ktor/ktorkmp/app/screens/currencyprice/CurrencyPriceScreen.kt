package org.ktor.ktorkmp.app.screens.currencyprice

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.ktor.ktorkmp.app.components.CircleIndicator
import org.ktor.ktorkmp.app.components.MainLazyColumn
import org.ktor.ktorkmp.app.components.MainRow
import org.ktor.ktorkmp.app.components.SpacerVertical15
import org.ktor.ktorkmp.app.components.TopAppBarScreen
import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.data.settings.getData
import org.ktor.ktorkmp.data.settings.saveData
import org.ktor.ktorkmp.domain.util.Result

@Composable
fun CurrencyPriceScreen(
    currencyPriceViewModel: CurrencyPriceViewModel
) {

    val scope = rememberCoroutineScope()

    scope.launch {

        println("diaa ${getData()}")
        delay(2000)
        saveData()
        delay(2000)
        println("diaa ${getData()}")
    }

    val currencyState by currencyPriceViewModel.currencyPriceState.collectAsState()

    CurrencyPriceContent(currencyState)
    {
        currencyPriceViewModel.getCurrencyPrice(true)
    }
}

@Composable
fun CurrencyPriceContent(
    currencyState: Result<List<CurrencyPriceModel>>,
    onRefreshClick : () -> Unit = {}
) {

    Column {

        TopAppBarScreen{
            onRefreshClick()
        }

        SpacerVertical15()

        when (currencyState) {
            is Result.Error -> {
                Text(text = currencyState.message.toString())
            }

            is Result.Loading -> {
                CircleIndicator()
            }

            is Result.Success -> {

                Column {
                    MainRow("العملة")

                    MainLazyColumn(
                        list = currencyState.data!!
                    )
                }
            }
        }
    }
}