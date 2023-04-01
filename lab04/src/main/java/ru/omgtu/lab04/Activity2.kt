package ru.omgtu.lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class Activity2 : AppCompatActivity() {
    @BindView(R.id.welcome_text)
    lateinit var welcomeText: TextView
    @BindView(R.id.date_picker)
    lateinit var datePicker: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        ButterKnife.bind(this)

        val login = intent.getStringExtra("USER_LOGIN")
        welcomeText.text = "Welcome, $login!"
    }

    @OnClick(R.id.apply_button)
    fun onApplyClicked() {
        val intent = Intent()
        val date = "${datePicker.dayOfMonth.toString().padStart(2, '0')}." +
                "${(datePicker.month + 1).toString().padStart(2, '0')}." +
                "${datePicker.year}"
        intent.putExtra("DATE", date)
        setResult(RESULT_OK, intent)
        finish()
    }
}