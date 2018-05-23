@file:JvmName("RandomUtils")

package com.calvinnoronha.mywardrobe.util

import java.util.*

fun getRandomId() = UUID.randomUUID().toString()

fun getRandomInt(size: Int) = Random().nextInt(size)
