package com.calvinnoronha.mywardrobe.data_layer

import com.calvinnoronha.mywardrobe.events.WardrobeLoadedEvent
import com.calvinnoronha.mywardrobe.model.BottomElement
import com.calvinnoronha.mywardrobe.model.FavoriteModel
import com.calvinnoronha.mywardrobe.model.TopElement
import com.calvinnoronha.mywardrobe.util.Events

/**
 * A repository class for holding Database information.
 *
 * Clients must use this class.
 */
object DataRepo {

    private val topDao = WardrobeDatabase.topDao()
    private val bottomDao = WardrobeDatabase.bottomDao()
    private val favoriteDao = WardrobeDatabase.favoriteDao()

    private val dbThread = WardrobeDatabase.dbThread

    // Prevent multiple initialisation
    private var isInitialised = false

    private lateinit var topElementList: MutableList<TopElement>
    private lateinit var bottomElementList: MutableList<BottomElement>
    private lateinit var favoriteList: MutableList<FavoriteModel>

    fun initialise() {
        if (isInitialised) throw RuntimeException("Do not call init more than once!")
        isInitialised = true
        runDbTask {
            topElementList = topDao.getTops()
            bottomElementList = bottomDao.getBottoms()
            favoriteList = favoriteDao.getFavorites()
            Events.postSticky(WardrobeLoadedEvent())
        }
    }

    fun getTops() = topElementList

    fun getBottoms() = bottomElementList

    fun getTop(topId: String) = topElementList.find { it.id == topId }

    fun getBottom(bottomId: String) = bottomElementList.find { it.id == bottomId }

    fun addTop(top: TopElement) {
        topElementList.add(top)
        runDbTask { topDao.insert(top) }
    }

    fun addBottom(bottom: BottomElement) {
        bottomElementList.add(bottom)
        runDbTask { bottomDao.insert(bottom) }
    }

    fun isFavorite(topId: String, bottomId: String) =
            favoriteList.any { it.topId == topId && it.bottomId == bottomId }

    fun addFavorite(favorite: FavoriteModel) {
        favoriteList.add(favorite)
        runDbTask { favoriteDao.insert(favorite) }
    }

    fun removeFavorite(topId: String, bottomId: String) {
        val favoriteModel = favoriteList.find { it.topId == topId && it.bottomId == bottomId }
        if (favoriteModel == null) return
        removeFavorite(favoriteModel)
    }

    fun removeFavorite(favorite: FavoriteModel) {
        favoriteList.remove(favorite)
        runDbTask { favoriteDao.delete(favorite) }
    }

    private fun runDbTask(task: () -> Unit) {
        dbThread.post(Runnable { task() })
    }
}
