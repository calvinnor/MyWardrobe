@file:JvmName("Extensions")

package com.calvinnoronha.mywardrobe.util

/**
 * Home for Kotlin extensions on sealed classes.
 */

fun Any?.isNull() = this == null

fun Any?.isNotNull() = !this.isNull()

/**
 * Check if an integer is greater than a given bound.
 */
infix fun Int.greaterThan(num: Int) = this > num
