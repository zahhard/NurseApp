package com.example.nurseapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nurseapp.data.database.NurseEntity
import com.example.nurseapp.data.database.OrderEntity
import com.example.nurseapp.data.repository.AppRepository
import com.example.nurseapp.model.Category
import com.example.nurseapp.model.Nurse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var appRepository: AppRepository)  : ViewModel() {

    var categoryListLiveData = MutableLiveData<List<Category>>()
    var topNursesListLiveData = MutableLiveData<List<NurseEntity>>()
    var specialNursesListLiveData = MutableLiveData<List<NurseEntity>>()

    fun setCategory(){
        viewModelScope.launch {
            categoryListLiveData.value = appRepository.setCategory()
        }

    }

    fun setTopNurses() {
        viewModelScope.launch {
            topNursesListLiveData.value = appRepository.getTopNurses().reversed()
        }
    }

    fun getNursesOrderByEducation(education :String) {
        viewModelScope.launch {
            topNursesListLiveData.value = appRepository.getTopNurses()
        }
    }

    fun getSpecialNurses() {
        viewModelScope.launch {
            specialNursesListLiveData.value = appRepository.getTopNurses()
        }
    }

    fun setTestData() {
        viewModelScope.launch {
            appRepository.setTestData()
        }
    }

    fun setTestOrder() {
        viewModelScope.launch {
            var a = OrderEntity(1,5,0,"20200.08.09" ,1)
            appRepository.insertOrder(a)
        }
    }
}