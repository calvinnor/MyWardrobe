@file:JvmName("Permissions")

package com.calvinnoronha.mywardrobe.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat

/**
 * Whether the app currently has access to External Storage.
 */
fun hasStorageAccess(context: Context) = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

/**
 * Request Read Storage Permission
 */
fun requestStoragePermission(fragment: Fragment, requestCode: Int) =
        fragment.requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), requestCode)
