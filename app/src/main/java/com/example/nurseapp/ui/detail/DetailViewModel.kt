package com.example.nurseapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nurseapp.data.database.CommentEntity
import com.example.nurseapp.data.database.NurseEntity
import com.example.nurseapp.data.repository.AppRepository
import com.example.nurseapp.model.Comment
import com.example.nurseapp.model.Nurse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var appRepository: AppRepository) :ViewModel() {

    var nurseItemLiveData = MutableLiveData<NurseEntity>()
    var nurseCommentsLiveData = MutableLiveData<List<CommentEntity>>()

    fun getItemDetail(id: Int) {
        viewModelScope.launch {
            nurseItemLiveData.value = appRepository.getItemDetail(id)
        }
    }

    fun getComments(nurseId: Int) {
        viewModelScope.launch {
            nurseCommentsLiveData.value = appRepository.getComments(nurseId)
        }
    }
}
