package com.aniruddhapimple.portfolio

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.aniruddhapimple.design_system.components.buttons.HomeCardButton
import com.aniruddhapimple.design_system.components.cards.HomeCardView
import kotlinx.android.synthetic.main.about_app_activity.*

class AboutAppActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_app_activity)

        back_button_about_activity.setOnClickListener{finish()}

        val notificationButton : HomeCardButton = findViewById(R.id.notificationButton)
        val animationCardView : HomeCardView = findViewById(R.id.animation_card_view)
        val animationButton : HomeCardButton = findViewById(R.id.animationButton)


        notificationButton.setOnClickListener{}

        animationButton.setOnClickListener{
            val animation : Animation = AnimationUtils.loadAnimation(this,R.anim.mixed_anim)
            animationCardView.startAnimation(animation)
        }

    }
}