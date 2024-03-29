package com.example.nurseapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nurseapp.data.repository.AppRepository
import com.example.nurseapp.model.Category
import com.example.nurseapp.model.Nurse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var appRepository: AppRepository)  : ViewModel() {

    var categoryListLiveData = MutableLiveData<List<Category>>()
    var topNursesListLiveData = MutableLiveData<List<Nurse>>()
    var specialNursesListLiveData = MutableLiveData<List<Nurse>>()

    fun setCategory(){
        viewModelScope.launch {
            categoryListLiveData.value = appRepository.setCategory()
        }

    }

    fun setTopNurses() {
        viewModelScope.launch {
            topNursesListLiveData.value = appRepository.getTopNurses()
        }
    }

    fun getSpecialNurses() {
        viewModelScope.launch {
            specialNursesListLiveData.value = appRepository.getTopNurses()
        }
    }
}