package com.aniruddhapimple.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.squareup.picasso.PicassoProvider
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    val dp_url = "https://firebasestorage.googleapis.com/v0/b/aniruddhapimpleportfolio.appspot.com/o/pictures%2FStevens%20LinkedIn%20Headshots%20February%202019edited.jpg?alt=media&token=f535901d-a869-401c-9b40-42f60a4fa147"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Picasso.get().load(dp_url).into(home_screen_picture)
    }
}
