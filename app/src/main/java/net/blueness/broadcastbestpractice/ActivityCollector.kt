package net.blueness.broadcastbestpractice

import android.app.Activity

/**
 * Created by Blueness on 2017/8/24.
 */

object ActivityCollector{

    var activities: MutableList<Activity> = arrayListOf()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    fun finishAll(){
        for (activity in activities){
            if (!activity.isFinishing){
                activity.finish()
            }
        }
        activities.clear()
    }
}
