package org.ktor.ktorkmp.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.ktor.ktorkmp.CurrencyDatabase

class IosDatabaseDriverFactory():DatabaseDriverFactory{

    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            CurrencyDatabase.Schema,
            "currency.db"
        )
    }

}