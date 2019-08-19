package com.aniruddhapimple.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activities_activity.*
import java.util.ArrayList

class ActivitiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activities_activity)
        back_button_activities_activity.setOnClickListener{finish()}

        other_exp_recycler_view.layoutManager = LinearLayoutManager(this)
        other_exp_recycler_view.adapter = WorkProjectEducationAdapter(retrieveList())
    }

    private fun retrieveList(): ArrayList<ListableItem> {
        return arrayListOf(WorkDataObject("CMO","Google",
            "Jun 96 - Aug 19","lavdu lasun\nlasun lavda\n aur kya chahiye\n punnja \n maa ki aankh") as ListableItem)
    }
}