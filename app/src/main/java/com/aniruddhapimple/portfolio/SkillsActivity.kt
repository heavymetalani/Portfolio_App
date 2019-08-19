package com.aniruddhapimple.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.skills_activity.*
import java.util.ArrayList

class SkillsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.skills_activity)
        back_button_skills_activity.setOnClickListener{finish()}

        skills_recycler_view.layoutManager = LinearLayoutManager(this)
        skills_recycler_view.adapter = SkillsAdapter(retrieveList())
    }

    private fun retrieveList(): ArrayList<SkillDataObject> {
        return arrayListOf(SkillDataObject("Kotlin",90), SkillDataObject("Java",80))
    }
}