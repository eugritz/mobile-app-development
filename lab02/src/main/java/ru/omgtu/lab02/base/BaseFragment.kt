package ru.omgtu.lab02.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.squareup.otto.Bus

open class BaseFragment : Fragment() {
    lateinit var bus: Bus

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
    }

    override fun onStart() {
        super.onStart()
        bus = (activity as BaseActivity).bus
        bus.register(this)
    }

    override fun onStop() {
        super.onStop()
        bus.unregister(this)
    }
}