package com.example.nurseapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nurseapp.data.database.CommentEntity
import com.example.nurseapp.data.database.NurseEntity
import com.example.nurseapp.data.database.OrderEntity
import com.example.nurseapp.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class DetailViewModel @Inject constructor(var appRepository: AppRepository) : ViewModel() {

    var nurseItemLiveData = MutableLiveData<NurseEntity>()
    var nurseCommentsLiveData = MutableLiveData<List<CommentEntity>>()
    var nurseOrdersLiveData = MutableLiveData<List<OrderEntity>>()

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

    fun insertOneComment(commentEntity: CommentEntity) {
        viewModelScope.launch {
            appRepository.insertOneComment(commentEntity)
        }
    }

    fun getNurseOrder(id: Int) {
        viewModelScope.launch {
            nurseOrdersLiveData.value = appRepository.getAllOrdersForNurse(id)
        }
    }

    fun setOrder(date: String, dayCount: Int, nurseId: Int, userId: Int) {

        getNurseOrder(nurseId)

        viewModelScope.launch {
            appRepository.getAllOrdersForNurse(nurseId)
        }

        viewModelScope.launch {
            var order = OrderEntity(Random.nextInt(0, 1000), userId, nurseId, date, dayCount)
            appRepository.setOrder(order)
        }
    }
}
