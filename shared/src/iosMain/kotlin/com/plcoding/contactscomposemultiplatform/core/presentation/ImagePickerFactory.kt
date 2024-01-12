package com.plcoding.contactscomposemultiplatform.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import platform.UIKit.UIViewController

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ImagePickerFactory(
    private val rootController: UIViewController,
) {
    @Composable
    actual fun createPicker(): ImagePicker {
        return remember {
            ImagePicker(rootController)
        }
    }
}