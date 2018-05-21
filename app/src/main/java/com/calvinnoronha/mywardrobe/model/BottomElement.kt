package com.calvinnoronha.mywardrobe.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.calvinnoronha.mywardrobe.R
import com.calvinnoronha.mywardrobe.data_layer.BOTTOM_COL_ID
import com.calvinnoronha.mywardrobe.data_layer.BOTTOM_TABLE_NAME

/**
 * This class represents a Bottom - like a Pant.
 */
@Entity(tableName = BOTTOM_TABLE_NAME)
class BottomElement(@PrimaryKey @ColumnInfo(name = BOTTOM_COL_ID) var id: String)

    : WardrobeElement() {

    constructor() : this("null")

    override fun getPlaceholder() = R.drawable.bottom_placeholder
}
