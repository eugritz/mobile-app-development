package ru.omgtu.lab04

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.FileProvider
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import java.io.File

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

        val intent = Intent(this, Activity2::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            putExtra("USER_LOGIN", login)
        }
        startActivityForResult(intent, Activity2.APPLY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Activity2.APPLY) {
            Toast.makeText(this, data?.getStringExtra("DATE") ?: ":(", Toast.LENGTH_LONG).show()
        }
    }

    @OnClick(R.id.image_button)
    fun onImageClicked() {
        val permission = checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        if (permission == PackageManager.PERMISSION_DENIED) {
            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
            return
        }

        val downloads = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val image = File(downloads, "capybara-onsen.jpg")
        val a = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(FileProvider.getUriForFile(applicationContext,
                "$packageName.provider", image), "image/*")
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }
        startActivity(a)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onLoginClicked()
            }
        }
    }
}