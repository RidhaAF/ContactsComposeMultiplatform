package com.plcoding.contactscomposemultiplatform.core.presentation

import androidx.compose.runtime.Composable

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class ImagePickerFactory {
    @Composable
    fun createPicker(): ImagePicker
}