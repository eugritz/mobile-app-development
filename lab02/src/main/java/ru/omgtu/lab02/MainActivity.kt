package ru.omgtu.lab02

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.squareup.otto.Subscribe
import ru.omgtu.lab02.base.BaseActivity
import ru.omgtu.lab02.events.PopBackStackEvent
import ru.omgtu.lab02.events.ShowActivityEvent
import ru.omgtu.lab02.events.ShowFragmentEvent

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, MainFragment.newInstance(), MainFragment.TAG)
            .addToBackStack(MainFragment.TAG)
            .commit()
    }

    @Subscribe
    fun handleShowActivity(event: ShowFragmentEvent) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, event.fragment, event.tag)
            .addToBackStack(event.tag)
            .commit()
    }

    @Subscribe
    fun handleShowActivity(event: ShowActivityEvent) {
        val intent = Intent(this, event.cls)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivity(intent)
    }

    @Subscribe
    fun handleShowFragment(event: ShowFragmentEvent) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, event.fragment, event.tag)
            .addToBackStack(event.tag)
            .commit()
    }

    @Subscribe
    fun handlePopBackStack(event: PopBackStackEvent) {
        var flags = 0
        if (event.inclusive) {
            flags = FragmentManager.POP_BACK_STACK_INCLUSIVE
        }

        supportFragmentManager.popBackStackImmediate(event.tag, flags)
    }
}