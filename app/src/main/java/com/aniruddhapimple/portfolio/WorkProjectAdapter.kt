package com.aniruddhapimple.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class WorkProjectAdapter(var workObjectList : ArrayList<WorkDataObject>) : RecyclerView.Adapter<WorkProjectViewHolder>() {
    override fun getItemCount(): Int {
        return workObjectList.size
    }

    override fun onBindViewHolder(holder: WorkProjectViewHolder, position: Int) {
        holder.bind(workObjectList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkProjectViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WorkProjectViewHolder(layoutInflater.inflate(R.layout.item_work_details, parent, false))
    }


}


class WorkProjectViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val titleTextView: TextView = view.findViewById(R.id.work_position_text_view)
    private val employerTextView: TextView = view.findViewById(R.id.work_employer_text_view)
    private val dateTextView: TextView = view.findViewById(R.id.work_date_text_view)
    private val detailsTextView: TextView = view.findViewById(R.id.work_details_text_view)

    fun bind(workObject: WorkDataObject) {
        titleTextView.text = workObject.title
        employerTextView.text = workObject.employer
        dateTextView.text = workObject.date
        detailsTextView.text = workObject.details
    }

}