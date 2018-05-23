@file:JvmName("IntentFactory")

package com.calvinnoronha.mywardrobe.factory

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.provider.MediaStore.EXTRA_OUTPUT

private const val IMAGE_MIME_TYPE = "image/*"

/**
 * Get an intent to capture an Image from the camera.
 */
fun getImageCaptureIntent(imageUri: Uri) = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
    putExtra(EXTRA_OUTPUT, imageUri)
}

/**
 * Get an intent to pick a photo from Gallery
 */
fun getImagePickIntent() = Intent(Intent.ACTION_GET_CONTENT).apply {
    type = IMAGE_MIME_TYPE
    addCategory(Intent.CATEGORY_OPENABLE)
}
