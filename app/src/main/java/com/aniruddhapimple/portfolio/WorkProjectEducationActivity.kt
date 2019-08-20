package com.aniruddhapimple.portfolio

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.work_project_education_activity.*

class WorkProjectEducationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_project_education_activity)
        val activityTitle = intent.getStringExtra("activity_title")
        work_project_activity_title.text = activityTitle
        work_ex_recycler_view.isNestedScrollingEnabled = false
        updateWPEUI(activityTitle)
        back_button_wpe_activity.setOnClickListener{finish()}
    }

    private fun updateWPEUI(activityName : String) {
        val tempList : ArrayList<ListableItem> = ArrayList()
        var collectionName : String
        when (activityName) {
            "Projects" -> collectionName = "projects"
            "Work Experience" -> collectionName = "workex"
            else -> collectionName = "education"
        }

        val collectionReference = FirebaseFirestore.getInstance().collection(collectionName)
        collectionReference.get().addOnSuccessListener {documents ->
            for (document in documents){
                val detailsArray = document.get("detailsArray") as ArrayList<String>
                var details = ""
                for(line in detailsArray){
                    details+= "•"
                    details+=line
                    details+="\n"
                }
                when (activityName) {
                    "Work Experience" -> tempList.add(WorkDataObject(document.getString("title")!!,
                        document.getString("employer")!!, document.getString("date")!!, details))
                    "Projects" -> tempList.add(ProjectDataObject(document.getString("title")!!,
                        document.getString("university")!!, document.getString("date")!!, details))
                    else -> tempList.add(ProjectDataObject(document.getString("university")!!,
                        document.getString("location")!!, document.getString("date")!!, details))
                }
            }
            work_ex_recycler_view.layoutManager = LinearLayoutManager(this)
            work_ex_recycler_view.adapter = WorkProjectEducationAdapter(tempList)
            circle_progress_wpe_activity.visibility = View.GONE
        }.addOnFailureListener{e->
            Toast.makeText(this, "Error occurred while querying: $e",Toast.LENGTH_LONG).show()
        }
    }
}