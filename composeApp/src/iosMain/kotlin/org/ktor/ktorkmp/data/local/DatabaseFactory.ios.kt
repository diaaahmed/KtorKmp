package org.ktor.ktorkmp.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.ktor.ktorkmp.CurrencyDatabase

actual class DatabaseFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            CurrencyDatabase.Schema,
            "currency.db"
        )

    }

}