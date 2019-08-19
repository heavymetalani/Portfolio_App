package com.aniruddhapimple.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SkillsAdapter (private var SkillList : ArrayList<SkillDataObject>) : RecyclerView.Adapter<SkillViewHolder>() {
    override fun getItemCount(): Int {
        return SkillList.size
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.bind(SkillList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SkillViewHolder(layoutInflater.inflate(R.layout.item_skill, parent, false))
    }
}

class SkillViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val skillTextView: TextView = view.findViewById(R.id.skill_text_view)
    private val progressTextView: TextView = view.findViewById(R.id.progress_text_view)
    private val progressBar: ProgressBar = view.findViewById(R.id.progress_bar)

    fun bind(SkillObject: SkillDataObject) {
        skillTextView.text = SkillObject.skill
        progressTextView.text = SkillObject.progress.toString()+"%"
        progressBar.progress = SkillObject.progress
    }
}
