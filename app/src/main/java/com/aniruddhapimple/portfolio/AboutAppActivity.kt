package com.aniruddhapimple.portfolio

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.aniruddhapimple.design_system.components.buttons.HomeCardButton
import com.aniruddhapimple.design_system.components.cards.HomeCardView
import kotlinx.android.synthetic.main.about_app_activity.*
import android.app.NotificationChannel
import android.graphics.Color
import android.os.Build



class AboutAppActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_app_activity)

        back_button_about_activity.setOnClickListener{finish()}

        val notificationButton : HomeCardButton = findViewById(R.id.notificationButton)
        val animationCardView : HomeCardView = findViewById(R.id.animation_card_view)
        val animationButton : HomeCardButton = findViewById(R.id.animationButton)


        notificationButton.setOnClickListener{notify(this, "Hello","This is a test notification")}

        animationButton.setOnClickListener{
            val animation : Animation = AnimationUtils.loadAnimation(this,R.anim.mixed_anim)
            animationCardView.startAnimation(animation)
        }

    }

    fun notify(context: Context, notificationTitle: String, notificationMessage: String) {

        val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel =
                NotificationChannel("my_channel_id", "My Notifications", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.description = "Channel description"
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.vibrationPattern = longArrayOf(0, 1000, 500, 1000)
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val intent = Intent(context, AboutAppActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            context, 0,
            intent, PendingIntent.FLAG_ONE_SHOT
        )
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(context, "my_channel_id")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setDefaults(Notification.DEFAULT_ALL)
            .setContentInfo("Info")
            .setContentTitle(notificationTitle)
            .setContentText(notificationMessage)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)

        notificationManager.notify(1, notificationBuilder.build())
    }
}