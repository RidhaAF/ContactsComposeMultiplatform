package com.plcoding.contactscomposemultiplatform.contacts.domain

data class Contact(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val photoByte: ByteArray?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Contact

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (email != other.email) return false
        if (phoneNumber != other.phoneNumber) return false
        if (photoByte != null) {
            if (other.photoByte == null) return false
            if (!photoByte.contentEquals(other.photoByte)) return false
        } else if (other.photoByte != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + phoneNumber.hashCode()
        result = 31 * result + (photoByte?.contentHashCode() ?: 0)
        return result
    }
}
