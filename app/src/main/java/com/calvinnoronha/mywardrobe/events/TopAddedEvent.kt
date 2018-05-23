package com.calvinnoronha.mywardrobe.events

import com.calvinnoronha.mywardrobe.model.TopElement

/**
 * Event to denote the addition of a Top.
 */
data class TopAddedEvent(val topElement: TopElement)
