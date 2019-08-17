package com.aniruddhapimple.portfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity()  {

    private val dpUrl = "https://firebasestorage.googleapis.com/v0/b/aniruddhapimpleportfolio.appspot.com/o/pictures%2FStevens%20LinkedIn%20Headshots%20February%202019edited.jpg?alt=media&token=f535901d-a869-401c-9b40-42f60a4fa147"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Picasso.get().load(dpUrl).into(home_screen_picture)

    }

    fun onWorkExProjectsClick(view : View){
        val intent = Intent(this, WorkProjectActivity::class.java)
        if(view.id == R.id.work_ex_layout){
            intent.putExtra("activity_title","Work Experience")
            Toast.makeText(this, "Coming to work exp", Toast.LENGTH_LONG).show()
        }

        else if(view.id == R.id.project_layout){
            intent.putExtra("activity_title","Projects")
        }

        startActivity(intent)
    }
}
