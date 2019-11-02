package com.lesniak.resumeapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesniak.resumeapp.data.Result
import com.lesniak.resumeapp.data.ResumeRepository
import com.lesniak.resumeapp.data.models.Bio
import com.lesniak.resumeapp.data.models.Skill
import com.lesniak.resumeapp.data.models.WorkExperience
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val resumeRepo: ResumeRepository) : ViewModel() {

    lateinit var bioLiveData: LiveData<Result<Bio>>

    lateinit var skillListLiveData: LiveData<Result<List<Skill>>>

    lateinit var workExperienceListLiveData: LiveData<Result<List<WorkExperience>>>

    init {
        viewModelScope.launch(Dispatchers.IO) {
            bioLiveData = resumeRepo.loadBio()
            skillListLiveData = resumeRepo.loadSkills()
            workExperienceListLiveData = resumeRepo.loadWorkExperience()
        }
    }

    val isBioLoading = MutableLiveData<Boolean>()
    val isSkillListLoading = MutableLiveData<Boolean>()
    val isWorkExperienceListLoading = MutableLiveData<Boolean>()

    val bio = MutableLiveData<Bio>()
    val skillList = MutableLiveData<List<Skill>>()
    val workExperienceList = MutableLiveData<List<WorkExperience>>()
}
