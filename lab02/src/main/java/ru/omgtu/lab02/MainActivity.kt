package ru.omgtu.lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import ru.omgtu.lab02.events.PopBackStackEvent
import ru.omgtu.lab02.events.ShowActivityEvent
import ru.omgtu.lab02.events.ShowFragmentEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, MainFragment(), MainFragment.TAG)
            .addToBackStack(MainFragment.TAG)
            .commit()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun handleShowActivity(event: ShowFragmentEvent) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, event.fragment, event.tag)
            .addToBackStack(event.tag)
            .commit()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun handleShowActivity(event: ShowActivityEvent) {
        val intent = Intent(this, event.cls)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivity(intent)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun handleShowFragment(event: ShowFragmentEvent) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, event.fragment, event.tag)
            .addToBackStack(event.tag)
            .commit()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun handlePopBackStack(event: PopBackStackEvent) {
        var flags = 0
        if (event.inclusive) {
            flags = FragmentManager.POP_BACK_STACK_INCLUSIVE
        }

        supportFragmentManager.popBackStackImmediate(event.tag, flags)
    }
}