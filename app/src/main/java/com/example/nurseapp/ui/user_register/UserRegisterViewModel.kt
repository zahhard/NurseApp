package com.example.nurseapp.ui.user_register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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


    fun getAllOrders(){
        viewModelScope.launch {
            orderListLiveData.value = appRepository.getAllOrders()
        }
    }


    fun getUser(id: Int){
        viewModelScope.launch {
            UserLiveData.value = appRepository.getUser(id)
        }
    }
}