package com.plcoding.contactscomposemultiplatform.core.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.plcoding.contactscomposemultiplatform.database.ContactDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            ContactDatabase.Schema, "contacts.db"
        )
    }
}