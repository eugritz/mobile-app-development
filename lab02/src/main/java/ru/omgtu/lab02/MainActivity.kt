package ru.omgtu.lab02

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.squareup.otto.Subscribe
import ru.omgtu.lab02.activity_stack.Activity1
import ru.omgtu.lab02.activity_stack.Activity2
import ru.omgtu.lab02.base.BaseActivity
import ru.omgtu.lab02.events.PopBackStackEvent
import ru.omgtu.lab02.events.ShowFragmentEvent
import ru.omgtu.lab02.fragment_stack.Fragment1

class MainActivity : BaseActivity(), MainFragment.MainFragmentCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, MainFragment.newInstance(), MainFragment.TAG)
                .addToBackStack(MainFragment.TAG)
                .commit()
        }
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

    override fun showActivity1() {
        val intent = Intent(this, Activity1::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivity(intent)
    }

    override fun showActivity2() {
        val intent = Intent(this, Activity2::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivity(intent)
    }

    override fun showFragment1() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, Fragment1.newInstance(), Fragment1.TAG)
            .addToBackStack(Fragment1.TAG)
            .commit()
    }
}