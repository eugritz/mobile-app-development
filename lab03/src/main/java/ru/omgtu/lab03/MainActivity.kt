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
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, LinearChatFragment.newInstance(),
                LinearChatFragment.TAG)
            .addToBackStack(LinearChatFragment.TAG)
            .commit()
    }

    override fun onButton2Pressed() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, ConstraintChatFragment.newInstance(),
                ConstraintChatFragment.TAG)
            .addToBackStack(ConstraintChatFragment.TAG)
            .commit()
    }

    override fun onButton3Pressed() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, ImageViewerFragment.newInstance(),
                ImageViewerFragment.TAG)
            .addToBackStack(ImageViewerFragment.TAG)
            .commit()
    }

    override fun onButton4Pressed() {
        Toast.makeText(this, "Button 4", Toast.LENGTH_SHORT).show()
    }
}