package ru.omgtu.lab01_intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    @BindView(R.id.toast_input_layout) lateinit var toastInputLayout: TextInputLayout;
    @BindView(R.id.toast_text) lateinit var toastText: TextInputEditText;
    @BindView(R.id.toast_create) lateinit var toastCreateButton: Button;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)

        toastCreateButton.setOnClickListener {
            if (toastText.text!!.length < MINIMUM_TOAST_LENGTH) {
                toastInputLayout.error = getString(R.string.toast_error, MINIMUM_TOAST_LENGTH)
            } else {
                toastInputLayout.error = ""
                Toast.makeText(activity, toastText.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val MINIMUM_TOAST_LENGTH = 3;

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment BlankFragment.
         */
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}