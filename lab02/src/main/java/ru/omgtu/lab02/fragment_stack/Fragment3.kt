package ru.omgtu.lab02.fragment_stack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.OnClick
import org.greenrobot.eventbus.EventBus
import ru.omgtu.lab02.MainFragment
import ru.omgtu.lab02.events.PopBackStackEvent
import ru.omgtu.lab02.R

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment3 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_3, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(R.id.returnToFragment1)
    fun returnToFragment1() {
        EventBus.getDefault().post(
            PopBackStackEvent(Fragment2.TAG, true)
        )
    }

    @OnClick(R.id.returnToFragment2)
    fun returnToFragment2() {
        EventBus.getDefault().post(
            PopBackStackEvent(Fragment2.TAG)
        )
    }

    @OnClick(R.id.returnHome)
    fun returnHome() {
        EventBus.getDefault().post(
            PopBackStackEvent(MainFragment.TAG)
        )
    }

    companion object {
        const val TAG = "FRAGMENT3"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment Fragment3.
         */
        @JvmStatic
        fun newInstance() = Fragment3()
    }
}