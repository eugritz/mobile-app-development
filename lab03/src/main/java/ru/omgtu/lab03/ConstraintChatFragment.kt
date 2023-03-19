package ru.omgtu.lab03

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick

/**
 * A simple [Fragment] subclass.
 * Use the [ConstraintChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConstraintChatFragment : BaseFragment() {
    @BindView(R.id.messageScroll)
    lateinit var messageScroll: ScrollView
    @BindView(R.id.messageView)
    lateinit var messageView: LinearLayout
    @BindView(R.id.messageText)
    lateinit var messageText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_constraint_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            for (i in 1..100) {
                val sentMessage = "he" + "e".repeat(i / 10) + "y"
                sendMessage("Annoying", sentMessage, false)
            }
        }
    }

    @OnClick(R.id.sendButton)
    fun onSendClicked() {
        sendMessage("You", messageText.text.toString())
    }

    fun sendMessage(author: String, message: String, scroll: Boolean = true) {
        if (message.trim() == "")
            return

        val text = TextView(context)
        val sentMessage = "$author: $message"
        text.text = sentMessage
        text.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        text.textSize = 32.0f
        messageView.addView(text)

        if (scroll) {
            messageScroll.smoothScrollTo(0, messageView.height)
            messageText.setText("")
        }
    }

    companion object {
        const val TAG = "CONSTRAINTCHATFRAGMENT"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ConstraintChatFragment.
         */
        @JvmStatic
        fun newInstance() = ConstraintChatFragment()
    }
}
