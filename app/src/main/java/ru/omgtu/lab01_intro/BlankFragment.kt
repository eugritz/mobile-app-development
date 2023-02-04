package ru.omgtu.lab01_intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.omgtu.lab01_intro.databinding.FragmentBlankBinding

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    private lateinit var _binding: FragmentBlankBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toastCreate.setOnClickListener {
            if (binding.toastText.text!!.length < MINIMUM_TOAST_LENGTH) {
                binding.toastInputLayout.error = getString(R.string.toast_error, MINIMUM_TOAST_LENGTH)
            } else {
                binding.toastInputLayout.error = ""
                Toast.makeText(activity, binding.toastText.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val MINIMUM_TOAST_LENGTH = 3

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