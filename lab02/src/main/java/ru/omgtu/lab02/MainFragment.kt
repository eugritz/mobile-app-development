package ru.omgtu.lab02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.OnClick
import ru.omgtu.lab02.activity_stack.Activity1
import ru.omgtu.lab02.activity_stack.Activity2
import ru.omgtu.lab02.base.BaseFragment
import ru.omgtu.lab02.events.ShowActivityEvent
import ru.omgtu.lab02.events.ShowFragmentEvent
import ru.omgtu.lab02.fragment_stack.Fragment1

/**
 * A simple [BaseFragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, AppleFragment.newInstance())
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @OnClick(R.id.showActivity1)
    fun showActivity1() = bus.post(ShowActivityEvent(Activity1::class.java))

    @OnClick(R.id.showActivity2)
    fun showActivity2() = bus.post(ShowActivityEvent(Activity2::class.java))

    @OnClick(R.id.showFragment1)
    fun showFragment1() = bus.post(ShowFragmentEvent(Fragment1.newInstance(), Fragment1.TAG))

    companion object {
        const val TAG = "MAINFRAGMENT"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MainFragment.
         */
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}