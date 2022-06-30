package com.example.nurseapp.data.repository

import androidx.lifecycle.LiveData
import com.example.nurseapp.data.database.AppDatabase
import com.example.nurseapp.data.database.NurseEntity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class LocalDataSource  @Inject constructor( val appDatabase: AppDatabase ) {

    suspend fun getNurses(): List<NurseEntity>{
         return appDatabase.companyDao().getAll()
    }

    suspend fun getTopNurses(): List<NurseEntity>{
         return appDatabase.companyDao().getTopNurses()
    }



    suspend fun setTestData() {
        appDatabase.companyDao().insertAll(
            NurseEntity(1,1,"1", "Davardoust", "09558741259", 5F, "baby care", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
            NurseEntity(2,2,"2", "Farahani", "09558741259", 4F, "baby care", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
            NurseEntity(3,3,"3", "Davardoust", "09558741259", 3F, "baby care", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
            NurseEntity(4,4,"4", "Davardoust", "09558741259", 2F, "baby care", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
            NurseEntity(5,5,"5", "Davardoust", "09558741259", 1F, "baby care", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
        )
    }
}