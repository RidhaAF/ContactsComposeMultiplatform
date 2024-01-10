package com.plcoding.contactscomposemultiplatform.core.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.plcoding.contactscomposemultiplatform.database.ContactDatabase

actual class DatabaseDriverFactory(
    private val context: Context,
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(
            ContactDatabase.Schema, context, "contacts.db"
        )
    }
}