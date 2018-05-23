package com.calvinnoronha.mywardrobe.model

/**
 * Base class for all Wardrobe elements
 */
abstract class WardrobeElement {

    abstract fun getContent(): String

    abstract fun getPlaceholder(): Int

    abstract fun getType(): WardrobeType
}
