package com.plcoding.contactscomposemultiplatform.contacts.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.plcoding.contactscomposemultiplatform.contacts.domain.Contact
import com.plcoding.contactscomposemultiplatform.core.presentation.rememberBitmapfromBytes

@Composable
fun ContactPhoto(
    contact: Contact?,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
) {
    val bitmap = rememberBitmapfromBytes(contact?.photoByte)
    val photoModifier = modifier.clip(RoundedCornerShape(40))

    if (bitmap != null) {
        Image(
            bitmap = bitmap,
            contentDescription = contact?.firstName,
            modifier = photoModifier,
            contentScale = ContentScale.Crop,
        )
    } else {
        Box(
            modifier = photoModifier.background(MaterialTheme.colorScheme.secondaryContainer),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = contact?.firstName,
                modifier = Modifier.size(iconSize),
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
            )
        }
    }
}