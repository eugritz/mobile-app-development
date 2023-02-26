package ru.omgtu.lab02.fragment_stack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.OnClick
import ru.omgtu.lab02.MainFragment
import ru.omgtu.lab02.events.PopBackStackEvent
import ru.omgtu.lab02.R
import ru.omgtu.lab02.base.BaseFragment
import ru.omgtu.lab02.events.ShowFragmentEvent

/**
 * A simple [BaseFragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    @OnClick(R.id.showFragment)
    fun showFragment() = bus.post(ShowFragmentEvent(Fragment2.newInstance(), Fragment2.TAG))

    @OnClick(R.id.returnHome)
    fun returnHome() = bus.post(PopBackStackEvent(MainFragment.TAG))

    companion object {
        const val TAG = "FRAGMENT1"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment Fragment1.
         */
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}