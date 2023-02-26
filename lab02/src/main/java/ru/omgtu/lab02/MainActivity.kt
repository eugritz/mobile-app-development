package ru.omgtu.lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), MainFragment.MainFragmentCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButton1Click() {
        Toast.makeText(this, "Button 1 clicked!", Toast.LENGTH_SHORT).show()
    }

    override fun onButton2Click() {
        Toast.makeText(this, "Button 2 clicked!", Toast.LENGTH_SHORT).show()
    }
}