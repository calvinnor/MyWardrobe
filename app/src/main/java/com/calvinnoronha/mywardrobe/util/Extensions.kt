@file:JvmName("Extensions")

package com.calvinnoronha.mywardrobe.util

/**
 * Home for Kotlin extensions on sealed classes.
 */

fun Any?.isNull() = this == null

fun Any?.isNotNull() = !this.isNull()
