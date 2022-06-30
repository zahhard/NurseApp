package com.example.nurseapp.data.repository

import androidx.lifecycle.LiveData
import com.example.nurseapp.data.database.Dao
import com.example.nurseapp.data.database.NurseEntity
import com.example.nurseapp.model.Category
import com.example.nurseapp.model.Nurse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class AppRepository  @Inject constructor(val localDataSource: LocalDataSource,
                     val remoteDataSource: RemoteDataSource) {

    suspend fun setTestData(){
        localDataSource.setTestData()
    }

    var categoryList = arrayListOf<Category>(
        Category(0, "Baby care", "https://cdn.cdnparenting.com/articles/2018/10/1022205187-H-768x525.jpg" ),
        Category(1, "Elderly care", "https://www.soundguys.com/wp-content/uploads/2021/08/Man-Wearing-ITE-Hearing-Aid-in-Right-Ear.jpg" ),
        Category(2, "Bandage", "https://www.easthillsmedicalcentre.com.au/wp-content/uploads/2022/01/shutterstock_250798189-1-1.jpg" ),
        Category(3, "General care", "https://saviorhomecare.com/wp-content/uploads/2021/08/page2.jpeg" ))

    var nurseList = arrayListOf<Nurse>(
        Nurse(0, "nana", "rahimi" , 5.6F,"bandage","https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000" ),
        Nurse(1, "zahra", "davardoust", 5.6F, "bandage","https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000" ),
        Nurse(2, "kosar", "zamani", 5.6F, "bandage","https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000" ),
        Nurse(3, "shima", "barami", 5.6F, "bandage" ,"https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000" ))

    fun setCategory(): ArrayList<Category>{
        return categoryList
    }

//    fun getTopNurses(): List<Nurse> {
//        return nurseList
//    }

    fun getItemDetail(id: Int): Nurse {
        return  nurseList[id]
    }

    suspend fun getNurses(): List<NurseEntity> {
        return localDataSource.getNurses()
    }

    suspend fun getTopNurses(): List<NurseEntity>{
        return localDataSource.getTopNurses()
    }


}