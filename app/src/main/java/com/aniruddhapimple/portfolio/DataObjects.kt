package com.aniruddhapimple.portfolio

data class WorkDataObject(var title : String, var employer : String, var date : String, var details : String) : ListableItem {
}

data class ProjectDataObject(var title: String, var university : String, var date : String, var details: String) : ListableItem

data class EducationDataObject(var university: String, var location: String, var date: String, var otherDetails : String) : ListableItem

data class SkillDataObject(var skill: String, var progress: Long)

interface ListableItem