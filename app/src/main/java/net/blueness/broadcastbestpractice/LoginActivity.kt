package net.blueness.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import net.blueness.activitytest.BaseActivity
import org.jetbrains.anko.find

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity: BaseActivity() {

    private var accountEdit: EditText? = null
    private var passwordEdit: EditText? = null
    private var login: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        accountEdit = find(R.id.account)
        passwordEdit = find(R.id.password)
        login = find(R.id.login)

        login?.setOnClickListener{
            val account = accountEdit!!.text.toString()
            val password = passwordEdit!!.text.toString()

            if(account == "admin" && password == "123456"){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Account or password is invalid", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
