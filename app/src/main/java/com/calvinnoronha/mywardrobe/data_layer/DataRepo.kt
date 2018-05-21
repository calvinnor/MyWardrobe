package com.calvinnoronha.mywardrobe.data_layer

/**
 * A repository class for holding Database information.
 *
 * Clients must use this class.
 */
object DataRepo {

    private val topDao = WardrobeDatabase.topDao()
    private val bottomDao = WardrobeDatabase.bottomDao()

    private val dbThread = WardrobeDatabase.dbThread

    // Prevent multiple initialisation
    private var isInitialised = false

    fun initialise() {
        if (isInitialised) throw RuntimeException("Do not call init more than once!")
        isInitialised = true
        runDbTask {
        }
    }

    fun getTops() = topDao.getTops()

    fun getBottoms() = bottomDao.getBottoms()

    fun getTop(topId: String) = topDao.getTop(topId)

    fun getBottom(bottomId: String) = bottomDao.getBottom(bottomId)

    private fun runDbTask(task: () -> Any) {
        dbThread.post(Runnable { task() })
    }
}
