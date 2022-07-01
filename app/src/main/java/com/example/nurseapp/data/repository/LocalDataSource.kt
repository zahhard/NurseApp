package com.example.nurseapp.data.repository

import androidx.lifecycle.LiveData
import com.example.nurseapp.data.database.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class LocalDataSource  @Inject constructor( val appDatabase: AppDatabase ) {

    suspend fun getNurses(): List<NurseEntity>{
         return appDatabase.companyDao().getAll()
    }

    suspend fun getTopNurses(): List<NurseEntity>{
         return appDatabase.companyDao().getTopNurses()
    }

    suspend fun insertUser(user : UserEntity){
         return appDatabase.companyDao().insertUser(user)
    }

    suspend fun insertOrder(order : OrderEntity){
         return appDatabase.companyDao().insertOrder(order)
    }



    suspend fun setTestData() {
        appDatabase.companyDao().insertAll(
            NurseEntity(1,1,"1", "Davardoust", "09558741259", 5F, "baby care", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
            NurseEntity(2,2,"2", "Farahani", "09558741259", 4F, "general care", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
            NurseEntity(3,3,"3", "Davardoust", "09558741259", 3F, "bandage", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
            NurseEntity(4,4,"4", "Davardoust", "09558741259", 2F, "Elderly care", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
            NurseEntity(5,5,"5", "Davardoust", "09558741259", 1F, "baby care", "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"),
        )
        appDatabase.companyDao().insertOrder(
            OrderEntity(1,"bandage","2022.01.01", "Nursea00"),
            OrderEntity(2,"baby care","2023.01.01", "Nursea01"),
            OrderEntity(3,"general care","2024.01.01", "Nursea02"),
            OrderEntity(4,"bandage","2025.01.01", "Nursea03"),
        )
        appDatabase.companyDao().insertComment(
            CommentEntity(0, 1, "very good1", "2020.05.1", "Farid1"),
            CommentEntity(1, 1, "very good2", "2020.05.2", "Farid2"),
            CommentEntity(2, 2, "very good3", "2020.05.3", "Farid3"),
            CommentEntity(3, 2, "very good4", "2020.05.4", "Farid4"),
            CommentEntity(4, 3, "very good5", "2020.05.5", "Farid5"),
            CommentEntity(5, 3, "very good6", "2020.05.6", "Farid6"),
            CommentEntity(6, 4, "very good7", "2020.05.7", "Farid7"),
            CommentEntity(7, 4, "very good8", "2020.05.8", "Farid8"),
            CommentEntity(8, 5, "very good9", "2020.05.9", "Farid9"),
            CommentEntity(9, 5, "very good10", "2020.05.10", "Farid10"),
        )
    }

    suspend fun getAllOrders(): List<OrderEntity>? {
        return appDatabase.companyDao().getAllOrders()
    }


    suspend fun getNursesOrderByEducation(education: String): List<NurseEntity> {
        return appDatabase.companyDao().getNursesOrderByCategory(education)
    }

    suspend fun getComments(nurseId: Int): List<CommentEntity> {
        return appDatabase.companyDao().getComments(nurseId)
    }

    suspend fun getOneNurse(id: Int): NurseEntity {
        return appDatabase.companyDao().getOneNurse(id)
    }

    suspend fun getOneUser(id: Int): UserEntity {
        return appDatabase.companyDao().getOneUser(id)
    }

    suspend fun search(search: String): List<NurseEntity> {
        return appDatabase.companyDao().search(search)
    }
}