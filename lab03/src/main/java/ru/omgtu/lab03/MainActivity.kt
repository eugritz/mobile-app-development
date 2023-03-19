package ru.omgtu.lab03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), MainFragment.MainFragmentCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButton1Pressed() {
        Toast.makeText(this, "Button 1", Toast.LENGTH_SHORT).show()
    }
    override fun onButton2Pressed() {
        Toast.makeText(this, "Button 2", Toast.LENGTH_SHORT).show()
    }
    override fun onButton3Pressed() {
        Toast.makeText(this, "Button 3", Toast.LENGTH_SHORT).show()
    }
    override fun onButton4Pressed() {
        Toast.makeText(this, "Button 4", Toast.LENGTH_SHORT).show()
    }
}