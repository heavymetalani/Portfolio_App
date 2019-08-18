package com.aniruddhapimple.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.work_project_education_activity.*

class WorkProjectEducationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_project_education_activity)
        val activityTitle = intent.getStringExtra("activity_title")
        work_project_activity_title.text = activityTitle
        work_ex_recycler_view.layoutManager = LinearLayoutManager(this)
        work_ex_recycler_view.adapter = WorkProjectAdapter(retrieveList(activityTitle))
    }

    private fun retrieveList(activityName : String): ArrayList<ListableItem> {
        val temp : ListableItem = if(activityName == "Projects")
            WorkDataObject("CTO","Google",
                "Jun 96 - Aug 19","lavdu lasun\nlasun lavda\n aur kya chahiye\n punnja \n maa ki aankh")
        else if(activityName == "Work Experience") {
            ProjectDataObject("CEO","Google",
                "Jun 96 - Aug 19","lavdu lasun\nlasun lavda\n aur kya chahiye\n punnja \n maa ki aankh")
        }
        else{
            EducationDataObject("Stevens Institute of Technology","Hoboken, NJ",
                "May 2020","GPA: 3.791\nCoursework: Subject1, Subject2, Subject3")
        }

        val tempList : ArrayList<ListableItem> = ArrayList()
        tempList.add(temp)
        return tempList
    }
}