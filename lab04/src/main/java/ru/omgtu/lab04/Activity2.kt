package ru.omgtu.lab04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

class Activity2 : AppCompatActivity() {
    @BindView(R.id.welcome_text)
    lateinit var welcomeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        ButterKnife.bind(this)

        val intent = getIntent()
        welcomeText.setText(intent.getStringExtra("USER_LOGIN"))
    }
}