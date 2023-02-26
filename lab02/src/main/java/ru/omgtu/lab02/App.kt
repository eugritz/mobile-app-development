package ru.omgtu.lab02

import android.app.Application
import com.squareup.otto.Bus

class App : Application() {
    val bus: Bus = Bus()
}