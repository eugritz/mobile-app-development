package ru.omgtu.lab02.fragment_stack

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.OnClick
import ru.omgtu.lab02.R

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {
    private var callbacks: Fragment2Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Fragment2Callbacks) {
            callbacks = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(R.id.showFragment)
    fun showFragment() {
        callbacks?.showFragment3()
    }

    @OnClick(R.id.returnHome)
    fun returnHome() {
        callbacks?.returnHome()
    }

    interface Fragment2Callbacks {
        fun showFragment3()
        fun returnHome()
    }

    companion object {
        const val TAG = "FRAGMENT2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment Fragment2.
         */
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}