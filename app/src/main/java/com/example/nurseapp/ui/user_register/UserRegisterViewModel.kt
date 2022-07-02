package com.example.nurseapp.ui.user_register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nurseapp.data.database.NurseEntity
import com.example.nurseapp.data.database.OrderEntity
import com.example.nurseapp.data.database.UserEntity
import com.example.nurseapp.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserRegisterViewModel  @Inject constructor(var appRepository: AppRepository)  : ViewModel() {

    var orderListLiveData = MutableLiveData<List<OrderEntity>>()
    var UserLiveData = MutableLiveData<UserEntity>()


    fun insertUser(user : UserEntity){
        viewModelScope.launch {
            appRepository.insertUser(user)
        }
    }

    fun insertNurse(nurseEntity: NurseEntity){
        viewModelScope.launch {
            appRepository.insertNurse(nurseEntity)
        }
    }


    fun getAllOrders(id: Int, type: String){

        if (type == "user"){
            viewModelScope.launch {
                orderListLiveData.value = appRepository.getAllOrdersForUser(id)
            }
        }
        if (type == "nurse"){
            viewModelScope.launch {
                orderListLiveData.value = appRepository.getAllOrdersForNurse(id)
            }
        }
    }


    fun getAllOrdersForUser(id: Int){
        viewModelScope.launch {
            orderListLiveData.value = appRepository.getAllOrdersForUser(id)
        }
    }


    fun getUser(id: Int){
        viewModelScope.launch {
            UserLiveData.value = appRepository.getUser(id)
        }
    }
}