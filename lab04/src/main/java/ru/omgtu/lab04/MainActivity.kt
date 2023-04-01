package ru.omgtu.lab04

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {
    @BindView(R.id.login_input)
    lateinit var loginInput: EditText
    @BindView(R.id.image_view)
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.open_market)
    fun onSupportClicked() {
        val href = Uri.parse("market://details?id=com.google.android.googlequicksearchbox")
        val intent = Intent(Intent.ACTION_VIEW, href)
        startActivity(intent)
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
        startActivityForResult(intent, REQUEST_RETRIEVE_DATE)
    }

    @OnClick(R.id.open_image)
    fun onImageClicked() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
        }
        startActivityForResult(intent, REQUEST_IMAGE_OPEN)
    }

    @OnClick(R.id.take_photo)
    fun onPhotoClicked() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_RETRIEVE_DATE) {
            Toast.makeText(this, data?.getStringExtra("DATE") ?: "None :(", Toast.LENGTH_LONG).show()
        } else if (requestCode == REQUEST_IMAGE_OPEN && resultCode == Activity.RESULT_OK) {
            val imageUri: Uri? = data?.data
            imageView.setImageURI(imageUri)
        } else if (requestCode == REQUEST_CAMERA && resultCode == Activity.RESULT_OK) {
            val photo: Bitmap? = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(photo)
        }
    }

    companion object {
        const val REQUEST_RETRIEVE_DATE = 1
        const val REQUEST_IMAGE_OPEN = 2
        const val REQUEST_CAMERA = 3
    }
}