package com.codecademy.movieapp

import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

abstract class BaseActivity : AppCompatActivity() {


    override fun setContentView(layoutResID: Int) {
        val contraintLayout : ConstraintLayout= layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout
        val frameLayout : FrameLayout = contraintLayout.findViewById(R.id.activity_content)

        layoutInflater.inflate(layoutResID,frameLayout,true)

        super.setContentView(layoutResID)
    }

}