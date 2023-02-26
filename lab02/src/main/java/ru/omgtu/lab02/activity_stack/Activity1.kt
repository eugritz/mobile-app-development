package ru.omgtu.lab02.activity_stack

import android.content.Intent
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import ru.omgtu.lab02.R
import ru.omgtu.lab02.base.BaseActivity

class Activity1 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.showActivity)
    fun showActivity() {
        val intent = Intent(this, Activity2::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivity(intent)
    }
}