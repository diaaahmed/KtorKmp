package org.ktor.ktorkmp.app.screens.bankPrice

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
import org.ktor.ktorkmp.domain.entity.BankPrice
import org.ktor.ktorkmp.domain.util.Result

@Composable
fun BankPriceScreen(
    bankViewModel: BankPriceViewModel
) {

    val currencyState by bankViewModel.bankPriceState.collectAsState()

    BankPriceContent(currencyState)
    {
        bankViewModel.getGoldPrice(true)
    }
}

@Composable
fun BankPriceContent(
    bankState: Result<List<BankPrice>>,
    onRefreshClick : () -> Unit = {}
) {

    Column {

        TopAppBarScreen{
            onRefreshClick()
        }

        SpacerVertical15()

        when (bankState) {
            is Result.Error -> {
                Text(text = bankState.message.toString())
            }

            is Result.Loading -> {
                CircleIndicator()
            }

            is Result.Success -> {

                Column {
                    MainRow("البنك")

                    MainLazyColumn(
                        list = bankState.data!!
                    )
                }
            }
        }
    }
}