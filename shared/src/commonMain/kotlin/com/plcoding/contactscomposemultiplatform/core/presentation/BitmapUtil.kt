package com.plcoding.contactscomposemultiplatform.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap

@Composable
expect fun rememberBitmapfromBytes(bytes: ByteArray?): ImageBitmap?