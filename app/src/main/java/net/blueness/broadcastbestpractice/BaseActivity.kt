package net.blueness.activitytest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import net.blueness.broadcastbestpractice.ActivityCollector
import net.blueness.broadcastbestpractice.LoginActivity

/**
 * Created by Blueness on 2017/8/24.
 */
open class BaseActivity: AppCompatActivity(){

    private var receiver: ForceOfflineReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onPostResume() {
        super.onPostResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("net.blueness.broadcastbestpractice.FORCE_OFFINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        if(receiver != null){
            unregisterReceiver(receiver)
        }
        receiver = null
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    class ForceOfflineReceiver: BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            val builder = AlertDialog.Builder(context!!)
            builder.setTitle("warning")
            builder.setMessage("You are forced to be offline, Please try to login again.")
            builder.setCancelable(false)//禁用返回键取消对话框
            builder.setPositiveButton("OK"){
                dialog, which ->
                ActivityCollector.finishAll()
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
            }
            builder.show()
        }

    }
}


