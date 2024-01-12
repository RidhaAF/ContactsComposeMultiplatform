package com.plcoding.contactscomposemultiplatform.core.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.plcoding.contactscomposemultiplatform.database.ContactDatabase

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            ContactDatabase.Schema, "contacts.db"
        )
    }
}