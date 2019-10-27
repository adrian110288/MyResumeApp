package com.lesniak.resumeapp.data.models

import com.google.gson.annotations.SerializedName

data class Resume(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("job_title") val jobTitle: String,
    val bio: String,
    val location: Location,
    val skills: List<String>,
    @SerializedName("work_experience") val workExperience: List<WorkExperience>
)