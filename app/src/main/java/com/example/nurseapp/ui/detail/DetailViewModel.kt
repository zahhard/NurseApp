package com.example.nurseapp.ui.detail

import androidx.lifecycle.ViewModel
import com.example.nurseapp.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var appRepository: AppRepository) :ViewModel() {
}