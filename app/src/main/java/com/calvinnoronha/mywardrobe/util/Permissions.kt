@file:JvmName("Permissions")

package com.calvinnoronha.mywardrobe.util

import android.Manifest
import android.content.Context
import android.support.v4.app.Fragment

/**
 * Whether the app currently has access to External Storage.
 * Temporarily commented out, however we can enable this if needed.
 */
fun hasStorageAccess(context: Context) = true // ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

/**
 * Request Read Storage Permission.
 * Remember to add this to AndroidManifest.xml for legacy versions.
 */
fun requestStoragePermission(fragment: Fragment, requestCode: Int) =
        fragment.requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), requestCode)
