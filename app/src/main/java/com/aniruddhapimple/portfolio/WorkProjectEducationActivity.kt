package com.aniruddhapimple.portfolio

import android.os.Bundle
import android.util.Log
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
        updateUI(activityTitle)
        back_button_wpe_activity.setOnClickListener{finish()}
    }

    private fun updateUI(activityName : String) {
        val tempList : ArrayList<ListableItem> = ArrayList()
        var collectionName : String
        if(activityName == "Project")
            collectionName = "workex"
        else
            collectionName = "workex"

        val collectionReference = FirebaseFirestore.getInstance().collection(collectionName)
        collectionReference.get().addOnSuccessListener {documents ->
                for (document in documents){
                    val detailsArray = document.get("detailsArray") as ArrayList<String>
                    var details = ""
                    for(line in detailsArray){
                        details+= "• "
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
        }.addOnFailureListener{e->
            Toast.makeText(this, "Error occurred while querying: $e",Toast.LENGTH_LONG).show()
        }
    }
}