package ru.omgtu.lab02

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.OnClick

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(R.id.button1)
    fun onButton1Click() {
        callbacks?.onButton1Click()
    }

    @OnClick(R.id.button2)
    fun onButton2Click() {
        callbacks?.onButton2Click()
    }

    interface MainFragmentCallbacks {
        fun onButton1Click()
        fun onButton2Click()
    }

    companion object {
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