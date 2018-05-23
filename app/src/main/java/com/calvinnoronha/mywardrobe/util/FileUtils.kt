@file:JvmName("FileUtils")

package com.calvinnoronha.mywardrobe.util

import android.annotation.SuppressLint
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import java.io.File
import java.io.InputStream


/**
 * Utility class for file / folder operations like create, copy, delete
 */
private const val TAG = "FileUtils"

private const val IMAGE_FORMAT = ".jpeg"

/**
 * Creates an Image File for storing, based on the provided name.
 */
fun createImageFile(context: Context, fileName: String): File {
    val parentDirectory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile(fileName, IMAGE_FORMAT, parentDirectory)
}

/**
 * Delete the file, given the handler to it.
 *
 * @param toDelete The file to delete.
 * @return A boolean stating if the file was successfully deleted.
 */
fun deleteFile(toDelete: File): Boolean {
    return toDelete.delete()
}

/**
 * Writes the given InputStream to a file.
 *
 * @param inputStream: The Input Stream to read from.
 */
fun File.writeToFile(inputStream: InputStream) {
    this.outputStream().use {
        it.write(inputStream.readBytes())
    }
    inputStream.close()
}

/**
 * Gets the file path of the given Content Uri.
 */
@SuppressLint("NewApi")
fun getPath(context: Context, uri: Uri): String? {
    var fileUri = uri
    val needToCheckUri = Build.VERSION.SDK_INT >= 19
    var selection: String? = null
    var selectionArgs: Array<String>? = null

    if (needToCheckUri && DocumentsContract.isDocumentUri(context.applicationContext, uri)) {

        if (isExternalStorageDocument(uri)) {
            val docId = DocumentsContract.getDocumentId(uri)
            val split = docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return Environment.getExternalStorageDirectory().toString() + "/" + split[1]

        } else if (isDownloadsDocument(uri)) {
            val id = DocumentsContract.getDocumentId(uri)
            fileUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(id))

        } else if (isMediaDocument(uri)) {
            val docId = DocumentsContract.getDocumentId(uri)
            val split = docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val type = split[0]
            if ("image" == type) fileUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            else if ("video" == type) fileUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            else if ("audio" == type) fileUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

            selection = "_id=?"
            selectionArgs = arrayOf(split[1])
        }

    }

    if ("content".equals(uri.scheme, ignoreCase = true)) {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        var cursor: Cursor? = null
        try {
            cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, null)
            val colIndex = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            if (cursor.moveToFirst()) return cursor.getString(colIndex)
        } catch (e: Exception) {
            // NO-OP
        } finally {
            cursor?.close()
        }

    } else if ("file".equals(uri.scheme, ignoreCase = true)) {
        return uri.path
    }

    return null
}

/**
 * @param uri The Uri to check.
 * @return Whether the Uri authority is ExternalStorageProvider.
 */
private fun isExternalStorageDocument(uri: Uri) = "com.android.externalstorage.documents" == uri.authority

/**
 * @param uri The Uri to check.
 * @return Whether the Uri authority is DownloadsProvider.
 */
private fun isDownloadsDocument(uri: Uri) = "com.android.providers.downloads.documents" == uri.authority

/**
 * @param uri The Uri to check.
 * @return Whether the Uri authority is MediaProvider.
 */
private fun isMediaDocument(uri: Uri) = "com.android.providers.media.documents" == uri.authority
