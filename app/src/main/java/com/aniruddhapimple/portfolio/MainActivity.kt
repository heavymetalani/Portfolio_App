package com.aniruddhapimple.portfolio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private val dpUrl =
        "https://firebasestorage.googleapis.com/v0/b/aniruddhapimpleportfolio.appspot.com" +
                "/o/pictures%2FStevens%20LinkedIn%20Headshots%20February%202019edited.jpg?alt=" +
                "media&token=f535901d-a869-401c-9b40-42f60a4fa147"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Picasso.get().load(dpUrl).into(home_screen_picture)
    }

    fun onWorkExProjectsClick(view: View) {
        val intent = Intent(this, WorkProjectEducationActivity::class.java)
        when {
            view.id == R.id.work_ex_layout -> intent.putExtra("activity_title", "Work Experience")
            view.id == R.id.project_layout -> intent.putExtra("activity_title", "Projects")
            else -> intent.putExtra("activity_title", "Education")
        }
        startActivity(intent)
    }

    fun onWebLinkClick(view: View) {
        var url = ""
        when {
            view.id == R.id.linkedin_link_text_view -> url = resources.getString(R.string.linkedin_link)
            view.id == R.id.github_link_text_view -> url = resources.getString(R.string.github_link)
            view.id == R.id.youtube_link_text_view -> url = resources.getString(R.string.youtube_link)
        }
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    fun onAboutAppClick(view : View) {
        val intent = Intent(this, AboutAppActivity::class.java)
        startActivity(intent)
    }

    fun onSkillsClick(view : View) {
        val intent = Intent(this, SkillsActivity::class.java)
        startActivity(intent)
    }

    fun onActivitiesClick(view : View) {
        val intent = Intent(this, ActivitiesActivity::class.java)
        startActivity(intent)
    }

    fun onEmailClick(view : View) {
        val intent = Intent(
            Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", resources.getString(R.string.email_link), null
            )
        )
        startActivity(Intent.createChooser(intent, "Send email..."))
    }

    fun onPhoneNumberClick(view : View) {
        val intent = Intent(
            Intent.ACTION_DIAL, Uri.fromParts(
                "tel", resources.getString(R.string.phone_number), null))
        startActivity(intent)
    }

    fun onResumeClick(view : View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1-T7WsnVXBzvBu96xpJUfcy6dT_3a8-p5?usp=sharing"))
        startActivity(intent)
    }
}
