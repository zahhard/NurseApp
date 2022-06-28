package com.example.nurseapp.ui.inside_of_each_otem

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nurseapp.data.repository.AppRepository
import com.example.nurseapp.model.Nurse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsideEachCategoryViewModel @Inject constructor(var appRepository: AppRepository): ViewModel(){

    var nursesListLiveData = MutableLiveData<List<Nurse>>()

    fun getNurses(){
        viewModelScope.launch {
            nursesListLiveData.value = appRepository.getTopNurses()
        }

    }

}