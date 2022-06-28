package com.example.nurseapp.data.repository

import com.example.nurseapp.data.network.ApiService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class RemoteDataSource  @Inject constructor(var apiService: ApiService) {
}