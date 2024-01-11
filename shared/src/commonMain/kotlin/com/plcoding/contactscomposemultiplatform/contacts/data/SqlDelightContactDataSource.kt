package com.plcoding.contactscomposemultiplatform.contacts.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact
import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactDataSource
import com.plcoding.contactscomposemultiplatform.core.data.ImageStorage
import com.plcoding.contactscomposemultiplatform.database.ContactDatabase
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.supervisorScope
import kotlinx.datetime.Clock
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class SqlDelightContactDataSource(
    db: ContactDatabase,
    private val imageStorage: ImageStorage,
    private val context: CoroutineContext = EmptyCoroutineContext,
) : ContactDataSource {
    private val queries = db.contactQueries

    override fun getContacts(): Flow<List<Contact>> {
        return queries.getContacts().asFlow().mapToList(context).map { contactEntities ->
            supervisorScope {
                contactEntities.map {
                    async { it.toContact(imageStorage) }
                }.map { it.await() }
            }
        }
    }

    override fun getRecentContacts(limit: Int): Flow<List<Contact>> {
        return queries.getRecentContacts(limit.toLong()).asFlow().mapToList(context)
            .map { contactEntities ->
                supervisorScope {
                    contactEntities.map {
                        async { it.toContact(imageStorage) }
                    }.map { it.await() }
                }
            }
    }

    override suspend fun insertContact(contact: Contact) {
        val imagePath = contact.photoByte?.let {
            imageStorage.saveImage(it)
        }

        return queries.insertContact(
            id = contact.id,
            firstName = contact.firstName,
            lastName = contact.lastName,
            phoneNumber = contact.phoneNumber,
            email = contact.email,
            createdAt = Clock.System.now().toEpochMilliseconds(),
            imagePath = imagePath,
        )
    }

    override suspend fun deleteContact(id: Long) {
        val entity = queries.getContactById(id).executeAsOne()
        entity.imagePath?.let {
            imageStorage.deleteImage(it)
        }

        deleteContact(id)
    }
}