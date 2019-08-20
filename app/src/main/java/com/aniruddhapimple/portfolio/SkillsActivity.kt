package com.aniruddhapimple.portfolio

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.skills_activity.*
import java.util.ArrayList

class SkillsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.skills_activity)
        back_button_skills_activity.setOnClickListener{finish()}

        updateSkillsUI()
    }

    private fun updateSkillsUI() {
        val tempList : ArrayList<SkillDataObject> = ArrayList()
        val collectionReference = FirebaseFirestore.getInstance().collection("skills")

        collectionReference.get().addOnSuccessListener {documents ->
            for (document in documents){
                tempList.add(SkillDataObject(document.getString("skill")!!, document.get("progress") as Long))
            }
            skills_recycler_view.layoutManager = LinearLayoutManager(this)
            skills_recycler_view.adapter = SkillsAdapter(tempList)
            circle_progress_skills_activity.visibility = View.GONE
        }.addOnFailureListener{e->
            Toast.makeText(this, "Error occurred while querying: $e", Toast.LENGTH_LONG).show()
        }
    }
}