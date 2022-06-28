package com.example.nurseapp.ui.nurse_register

import androidx.lifecycle.ViewModel
import com.example.nurseapp.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NurseRegisterViewModel  @Inject constructor(var appRepository: AppRepository)  : ViewModel() {
}