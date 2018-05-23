@file:JvmName("RandomUtils")

package com.calvinnoronha.mywardrobe.util

import java.util.*

/**
 * Get a random ID string for denoting a resource.
 */
fun getRandomId() = UUID.randomUUID().toString()

/**
 * Get a random integer, given the size (bound)
 */
fun getRandomInt(size: Int) = Random().nextInt(size)
