package ru.omgtu.lab03

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.OnClick

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : BaseFragment() {
    private var callbacks: MainFragmentCallbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainFragmentCallbacks) {
            callbacks = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @OnClick(R.id.button1)
    fun onButton1Pressed() {
        callbacks?.onButton1Pressed()
    }

    @OnClick(R.id.button2)
    fun onButton2Pressed() {
        callbacks?.onButton2Pressed()
    }

    @OnClick(R.id.button3)
    fun onButton3Pressed() {
        callbacks?.onButton3Pressed()
    }

    @OnClick(R.id.button4)
    fun onButton4Pressed() {
        callbacks?.onButton4Pressed()
    }

    interface MainFragmentCallbacks {
        fun onButton1Pressed()
        fun onButton2Pressed()
        fun onButton3Pressed()
        fun onButton4Pressed()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}