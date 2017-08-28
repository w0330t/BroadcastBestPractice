package net.blueness.broadcastbestpractice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import net.blueness.activitytest.BaseActivity
import org.jetbrains.anko.find

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forceOfline: Button = find(R.id.force_ofline)
        forceOfline.setOnClickListener{
            sendBroadcast(Intent("net.blueness.broadcastbestpractice.FORCE_OFFINE"))
        }
    }
}
