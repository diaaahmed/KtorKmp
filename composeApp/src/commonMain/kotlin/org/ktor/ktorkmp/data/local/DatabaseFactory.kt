package org.ktor.ktorkmp.data.local

import app.cash.sqldelight.db.SqlDriver
import org.ktor.ktorkmp.CurrencyDatabase
import org.ktor.ktorkmp.data.model.CurrencyPriceModel
import org.ktor.ktorkmp.domain.entity.GoldPrice

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
  //  private val goldQuery = database.goldDatabaseQueries

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

    fun readAllItemsFromGolds():List<GoldPrice>{

        return query.readlAllItemsFromGoldPrice().executeAsList()
            .map {
                GoldPrice(
                    karat = it.karat,
                    sell = it.sale,
                    buy = it.bye,
                   )
            }
    }

    fun getItemByCurrencyName(name:String):CurrencyPriceModel{

        val model = query.getItemByCurrencyName(name).executeAsOneOrNull()

        return CurrencyPriceModel(
            model!!.currencyName,model.currencySale,model.currencyBye,model.currencyFlag)
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
    fun insertItemToGolds(items:List<GoldPrice>){
        query.transaction {
            items.forEach {
                query.insertItemIntoGoldPrice(
                    karat = it.karat,
                    sale = it.sell,
                    bye = it.buy)
            }
        }
    }

    fun removeAllItemsFromGolds()
    {
        query.removeAllItemsFromGoldPrice()
    }

    fun removeAllItems()
    {
        query.removeAllItems()
    }
}