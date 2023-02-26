package ru.omgtu.lab02.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.otto.Bus
import ru.omgtu.lab02.App

open class BaseActivity : AppCompatActivity() {
    lateinit var bus: Bus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bus = (application as App).bus
    }

    override fun onStart() {
        super.onStart()
        bus.register(this)
    }

    override fun onStop() {
        super.onStop()
        bus.unregister(this)
    }
}