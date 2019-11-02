package com.lesniak.resumeapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.lesniak.resumeapp.data.Result
import com.lesniak.resumeapp.databinding.FragmentHomeBinding
import com.lesniak.resumeapp.util.appComponent
import com.lesniak.resumeapp.util.observeValue
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

private const val TAG = "HomeFragment"

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var skillListAdapter: SkillListAdapter

    @Inject
    lateinit var skillListLayoutManager: GridLayoutManager

    @Inject
    lateinit var workExperienceListAdapter: WorkExperienceListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentHomeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@HomeFragment
            model = viewModel
        }.root

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appComponent.homeComponent().create(this).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        skills_list_rv.apply {
            layoutManager = skillListLayoutManager
            adapter = skillListAdapter
        }

        experience_list_rv.adapter = workExperienceListAdapter

        viewModel.apply {

            bioLiveData.observeValue(this@HomeFragment) {
                viewModel.isBioLoading.value = it is Result.Loading
                when (it) {
                    is Result.Success -> viewModel.bio.value = it.data
                    is Result.Failure -> {
                    }
                }
            }

            skillListLiveData.observeValue(this@HomeFragment) {
                viewModel.isSkillListLoading.value = it is Result.Loading
                when (it) {
                    is Result.Success -> viewModel.skillList.value = it.data
                    is Result.Failure -> {
                    }
                }
            }

            workExperienceListLiveData.observeValue(this@HomeFragment) {
                viewModel.isWorkExperienceListLoading.value = it is Result.Loading
                when (it) {
                    is Result.Success -> viewModel.workExperienceList.value = it.data
                    is Result.Failure -> {
                    }
                }
            }

            skillList.observeValue(this@HomeFragment) { skillListAdapter.submitList(it) }
            workExperienceList.observeValue(this@HomeFragment) {
                workExperienceListAdapter.submitList(
                    it
                )
            }
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}
