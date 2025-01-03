package org.ktor.ktorkmp.data.local

import app.cash.sqldelight.db.SqlDriver
import org.ktor.ktorkmp.CurrencyDatabase
import org.ktor.ktorkmp.data.model.CurrencyPriceModel

expect class DatabaseFactory{
    fun createDriver():SqlDriver

}

interface DatabaseDriverFactory{
    fun createDriver():SqlDriver
}

class LocalDatabase(
    databaseDriverFactory: DatabaseFactory
){
    private val database = CurrencyDatabase(databaseDriverFactory.createDriver())

    private val query = database.currencyDatabaseQueries

    fun readAllItems():List<CurrencyPriceModel>{
        return query.readlAllItems().executeAsList()
            .map {
                CurrencyPriceModel(
                    currency = it.currencyName,
                    sell = it.currencySale,
                    buy = it.currencyBye,
                    flag = it.currencyFlag)
            }
    }

     fun insertItem(items:List<CurrencyPriceModel>){
        query.transaction {
            items.forEach {
                query.insertItem(
                    currencyName = it.currency,
                    currencySale = it.sell,
                    currencyBye = it.buy,
                    currencyFlag = it.flag)
            }
        }
    }

    fun removeAllItems()
    {
        query.removeAllItems()
    }
}