package com.lesniak.resumeapp.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class WorkExperience(
    val position: String,
    val company: String,
    @SerializedName("start_date") val startDate: Date,
    @SerializedName("end_date") val endDate: Date?,
    val present: Boolean
)