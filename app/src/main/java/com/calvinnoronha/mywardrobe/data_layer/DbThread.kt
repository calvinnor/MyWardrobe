package com.calvinnoronha.mywardrobe.data_layer

import android.os.Handler
import android.os.HandlerThread
import java.util.*

/**
 * A custom HandlerThread to service runnables.
 */
class DbThread(threadName: String) : HandlerThread(threadName) {

    private var workerThread: Handler? = null

    // Temp queue to maintain tasks before this DB Thread is started
    private var pendingTasks: Queue<Runnable>? = PriorityQueue<Runnable>()

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        workerThread = Handler(looper)

        for (runnable in pendingTasks!!) {
            post(runnable)
        }

        // We don't need this queue anymore
        pendingTasks?.clear()
        pendingTasks = null
    }

    fun post(task: Runnable) {
        if (workerThread == null) { // Save these to a queue
            pendingTasks?.add(task)
            return
        }
        workerThread?.post(task)
    }
}
