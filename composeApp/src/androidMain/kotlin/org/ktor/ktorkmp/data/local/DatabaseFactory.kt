package org.ktor.ktorkmp.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.ktor.ktorkmp.CurrencyDatabase

class AndroidDatabaseDriverFactory(
    private val context:Context
):DatabaseDriverFactory{

    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            CurrencyDatabase.Schema,
            context,
            "currency.db"
        )
    }

}