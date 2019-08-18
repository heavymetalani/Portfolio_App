package com.aniruddhapimple.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.about_app_activity.*

class AboutAppActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_app_activity)
        back_button_about_activity.setOnClickListener{finish()}
    }
}