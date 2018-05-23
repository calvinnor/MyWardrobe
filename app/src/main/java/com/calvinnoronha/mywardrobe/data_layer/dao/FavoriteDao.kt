package com.calvinnoronha.mywardrobe.data_layer.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.calvinnoronha.mywardrobe.data_layer.FAVORITE_COL_ID
import com.calvinnoronha.mywardrobe.data_layer.FAVORITE_TABLE_NAME
import com.calvinnoronha.mywardrobe.model.FavoriteModel

/**
 * This interface is used for Favorite DB persistence and retrieval.
 */
@Dao
interface FavoriteDao {

    @Query("SELECT * from ${FAVORITE_TABLE_NAME}")
    fun getFavorites(): MutableList<FavoriteModel>

    @Query("SELECT * from ${FAVORITE_TABLE_NAME} WHERE ${FAVORITE_COL_ID} = :favoriteId")
    fun getTop(favoriteId: String): FavoriteModel

    @Insert(onConflict = REPLACE)
    fun insert(favoriteModel: FavoriteModel)

    @Update
    fun update(favoriteModel: FavoriteModel)

    @Delete
    fun delete(favoriteModel: FavoriteModel)

}
