package com.example.nurseapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nurseapp.data.repository.AppRepository
import com.example.nurseapp.model.Category
import kotlinx.coroutines.launch

class HomeViewModel(var appRepository: AppRepository) : ViewModel() {

    var categoryListLiveData = MutableLiveData<List<Category>>()

    fun setCategory(){
        viewModelScope.launch {
            categoryListLiveData.value = appRepository.setCategory()
        }

    }

    fun get(){}
}