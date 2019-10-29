package com.lesniak.resumeapp.data.models

import com.google.gson.annotations.SerializedName

data class Resume(
    val skills: List<String>,
    @SerializedName("work_experience") val workExperience: List<WorkExperience>
)