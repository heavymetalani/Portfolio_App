package com.aniruddhapimple.portfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activities_activity.*
import java.util.ArrayList

class ActivitiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activities_activity)
        back_button_activities_activity.setOnClickListener{finish()}
        other_exp_recycler_view.isNestedScrollingEnabled = false

        video_demo_button.setOnClickListener{
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/Ke3PyAUkZFE")
            )
            intent.putExtra("force_fullscreen", true)
            startActivity(intent)
        }
        updateActivitiesUI()

    }

    private fun updateActivitiesUI(){
        val tempList : ArrayList<ListableItem> = ArrayList()
        val collectionReference = FirebaseFirestore.getInstance().collection("extracurricular")

        collectionReference.get().addOnSuccessListener {documents ->
            for (document in documents){
                val detailsArray = document.get("detailsArray") as ArrayList<String>
                var details = ""
                for(line in detailsArray){
                    details+= "•"
                    details+=line
                    details+="\n"
                }
                tempList.add(WorkDataObject(document.getString("title")!!,
                        document.getString("employer")!!, document.getString("date")!!, details))
            }
            other_exp_recycler_view.layoutManager = LinearLayoutManager(this)
            other_exp_recycler_view.adapter = WorkProjectEducationAdapter(tempList)
            circle_progress_activities_activity.visibility = View.GONE
        }.addOnFailureListener{e->
            Toast.makeText(this, "Error occurred while querying: $e", Toast.LENGTH_LONG).show()
        }
    }
}