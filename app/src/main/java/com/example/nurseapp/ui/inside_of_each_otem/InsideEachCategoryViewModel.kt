package com.example.nurseapp.ui.inside_of_each_otem

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nurseapp.data.database.NurseEntity
import com.example.nurseapp.data.repository.AppRepository
import com.example.nurseapp.model.Comment
import com.example.nurseapp.model.Nurse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class InsideEachCategoryViewModel @Inject constructor(var appRepository: AppRepository) :
    ViewModel() {

    var nursesListLiveData = MutableLiveData<List<NurseEntity>>()
    var nurseItemLiveData = MutableLiveData<Nurse>()
    var nurseCommentsLiveData = MutableLiveData<List<Comment>>()
    var filter = MutableLiveData<String>()
    var nurseList = ArrayList<NurseEntity>()

    fun getItemDetail(id: String) {
        viewModelScope.launch {
            nursesListLiveData.value = appRepository.getNursesOrderByEducation(id)
        }
    }

    fun getNurses() {
        viewModelScope.launch {
            nursesListLiveData.value = appRepository.getNurses()
        }
    }

    fun search(search: String) {
        viewModelScope.launch {
            nursesListLiveData.value = appRepository.search(search)
        }
    }

    fun filter(search: String, filter: String) {

        viewModelScope.launch {
            nursesListLiveData.value = appRepository.search(search)

            if (filter == "top") {
               nursesListLiveData.value =  nursesListLiveData.value!!.sortedBy { nursesListLiveData.value!![0].average_rate }.reversed()
            } else {

                val list = nursesListLiveData.value!!.filter {
                    Log.d("dd", it.education)
                    it.education == filter
                }
                nursesListLiveData.value = list
            }
        }



    }
//            nursesListLiveData.value = nurseList
}


//        if (filter == "Top") {
//                if (temp != null){
//                    temp.sortedBy { temp[0].average_rate }.reversed()
//                }
//
//        }
//        else {
//            viewModelScope.launch {
//                val temp = appRepository.search(search)
//                if (temp != null){
//                    for (i in 0..temp.size) {
//                        if (temp[i].education == filter) {
//                            nurseList.add(temp[i])
//                        }
//                    }
//                }
//            }
//        }
//
//        nursesListLiveData.value = nurseList



