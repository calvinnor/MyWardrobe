package com.calvinnoronha.mywardrobe.data_layer

import android.os.Handler
import android.os.HandlerThread

/**
 * A custom HandlerThread to service runnables.
 */
class DbThread(threadName: String) : HandlerThread(threadName) {

    private lateinit var workerThread: Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        workerThread = Handler(looper)
    }

    fun post(task: Runnable) {
        workerThread.post(task)
    }
}
