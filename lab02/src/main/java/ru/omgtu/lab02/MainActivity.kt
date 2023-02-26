package ru.omgtu.lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import ru.omgtu.lab02.activity_stack.Activity1
import ru.omgtu.lab02.activity_stack.Activity2
import ru.omgtu.lab02.fragment_stack.Fragment1
import ru.omgtu.lab02.fragment_stack.Fragment2
import ru.omgtu.lab02.fragment_stack.Fragment3

class MainActivity : AppCompatActivity(),
    MainFragment.MainFragmentCallbacks,
    Fragment1.Fragment1Callbacks, Fragment2.Fragment2Callbacks, Fragment3.Fragment3Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, MainFragment(), MainFragment.TAG)
            .addToBackStack(MainFragment.TAG)
            .commit()
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

    override fun showFragment2() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, Fragment2.newInstance(), Fragment2.TAG)
            .addToBackStack(Fragment2.TAG)
            .commit()
    }

    override fun showFragment3() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, Fragment3.newInstance(), Fragment3.TAG)
            .addToBackStack(Fragment3.TAG)
            .commit()
    }

    override fun returnToFragment1() {
        supportFragmentManager
            .popBackStackImmediate(Fragment2.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun returnToFragment2() {
        supportFragmentManager
            .popBackStackImmediate(Fragment2.TAG, 0)
    }

    override fun returnHome() {
        supportFragmentManager
            .popBackStackImmediate(MainFragment.TAG, 0)
    }
}