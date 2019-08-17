package com.aniruddhapimple.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkProjectAdapter(private var listableObjectList : ArrayList<ListableItem>) : RecyclerView.Adapter<WorkProjectViewHolder>() {
    override fun getItemCount(): Int {
        return listableObjectList.size
    }

    override fun onBindViewHolder(holder: WorkProjectViewHolder, position: Int) {
        holder.bind(listableObjectList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkProjectViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WorkProjectViewHolder(layoutInflater.inflate(R.layout.item_work_details, parent, false))
    }


}


class WorkProjectViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val titleTextView: TextView = view.findViewById(R.id.work_position_text_view)
    private val subtitleTextView: TextView = view.findViewById(R.id.work_employer_text_view)
    private val dateTextView: TextView = view.findViewById(R.id.work_date_text_view)
    private val detailsTextView: TextView = view.findViewById(R.id.work_details_text_view)

    fun bind(ListableObject: ListableItem) {
        if(ListableObject is WorkDataObject){
            titleTextView.text = ListableObject.title
            subtitleTextView.text = ListableObject.employer
            dateTextView.text = ListableObject.date
            detailsTextView.text = ListableObject.details
        }
        else if(ListableObject is ProjectDataObject){
            titleTextView.text = ListableObject.title
            subtitleTextView.text = ListableObject.university
            dateTextView.text = ListableObject.date
            detailsTextView.text = ListableObject.details
        }

    }

}

