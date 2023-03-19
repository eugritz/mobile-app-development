package ru.omgtu.lab03

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import butterknife.ButterKnife

open class BaseFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
    }
}