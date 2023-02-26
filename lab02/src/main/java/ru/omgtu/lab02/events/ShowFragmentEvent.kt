package ru.omgtu.lab02.events

import androidx.fragment.app.Fragment

class ShowFragmentEvent(
    val fragment: Fragment,
    val tag: String
)