package com.example.activitylifecycletest

import android.app.Activity

object ActivityCollector {
    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    // 可以在任何继承了BaseActivity的Activity中调用该方法选择退出全部程序
    fun finishAllActivities() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
        // 杀掉当前进程，以保证程序完全退出
        android.os.Process.killProcess(android.os.Process.myPid())
    }
}