package com.calvinnoronha.mywardrobe.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.calvinnoronha.mywardrobe.R
import com.calvinnoronha.mywardrobe.data_layer.TOP_COL_ID
import com.calvinnoronha.mywardrobe.data_layer.TOP_TABLE_NAME

/**
 * This model represents a Top like a Shirt
 */
@Entity(tableName = TOP_TABLE_NAME)
class TopElement(
        @PrimaryKey @ColumnInfo(name = TOP_COL_ID) var id: String)

    : WardrobeElement() {

    constructor() : this("null")

    override fun getPlaceholder() = R.drawable.shirt_placeholder
}
