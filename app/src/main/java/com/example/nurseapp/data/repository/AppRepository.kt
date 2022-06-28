package com.example.nurseapp.data.repository

import com.example.nurseapp.model.Category

class AppRepository (val localDataSource: LocalDataSource,
                     val remoteDataSource: RemoteDataSource) {

    var categoryList = arrayListOf<Category>(
        Category(0, "baby care", "https://lh3.googleusercontent.com/nkCJZtkxJ_Ffc1lkkcqdImLedqYJqJlkMmwU_p40k2_OPncHtIFbhokO14aAotzCA0i5=s67" ))

    fun setCategory(): ArrayList<Category>{
        return categoryList
    }

}