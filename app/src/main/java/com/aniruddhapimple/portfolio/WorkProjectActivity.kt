package com.aniruddhapimple.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.work_project_activity.*

class WorkProjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_project_activity)
        val activityTitle = intent.getStringExtra("activity_title")
        work_project_activity_title.text = activityTitle
        work_ex_recycler_view.layoutManager = LinearLayoutManager(this)
        work_ex_recycler_view.adapter = WorkProjectAdapter(retrieveWorkEx())
    }

    private fun retrieveWorkEx(): ArrayList<WorkDataObject> {
        val temp : WorkDataObject = if(intent.getStringExtra("activity_title") == "Projects")
            WorkDataObject("CTO","Google",
                "Jun 96 - Aug 19","lavdu lasun\nlasun lavda\n aur kya chahiye\n punnja \n maa ki aankh")
        else
            WorkDataObject("CEO","Google",
                "Jun 96 - Aug 19","lavdu lasun\nlasun lavda\n aur kya chahiye\n punnja \n maa ki aankh")
        val tempList : ArrayList<WorkDataObject> = ArrayList()
        tempList.add(temp)
        return tempList
    }
}