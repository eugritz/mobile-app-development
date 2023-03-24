package ru.omgtu.lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {
    @BindView(R.id.login_input)
    lateinit var loginInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.login_button)
    fun onLoginClicked() {
        val login = loginInput.text.toString()
        if (login.trim() == "") {
            Toast.makeText(this, "Login must not be empty!", Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(this, Activity2::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        intent.putExtra("USER_LOGIN", login)
        startActivityForResult(intent, Activity2.APPLY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Activity2.APPLY) {
            Toast.makeText(this, data?.getStringExtra("DATE") ?: ":(", Toast.LENGTH_LONG).show()
        }
    }
}