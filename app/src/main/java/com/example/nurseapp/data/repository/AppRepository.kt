package com.example.nurseapp.data.repository

import androidx.lifecycle.LiveData
import com.example.nurseapp.data.database.*
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


    suspend fun getComments(nurseId: Int): List<CommentEntity>{
        return localDataSource.getComments(nurseId)
    }

    suspend fun getItemDetail(id: Int): NurseEntity {
        return  localDataSource.getOneNurse(id)
    }

    suspend fun getUser(id: Int): UserEntity {
        return  localDataSource.getOneUser(id)
    }

    suspend fun getNurses(): List<NurseEntity> {
        return localDataSource.getNurses()
    }

    suspend fun getTopNurses(): List<NurseEntity>{
        return localDataSource.getTopNurses()
    }

    suspend fun insertUser(user : UserEntity){
        return localDataSource.insertUser(user)
    }

    suspend fun insertOrder(orderEntity: OrderEntity ){
        return localDataSource.insertOrder(orderEntity)
    }

    suspend fun getAllOrdersForNurse(id: Int): List<OrderEntity>? {
        return localDataSource.getAllOrdersForNurse(id)
    }

    suspend fun getAllOrdersForUser(id: Int): List<OrderEntity>? {
        return localDataSource.getAllOrdersForUser(id)
    }


    suspend fun getNursesOrderByEducation(education: String): List<NurseEntity> {
        return localDataSource.getNursesOrderByEducation(education)
    }

    suspend fun search(search: String): List<NurseEntity> {
        return localDataSource.search(search)
    }

    suspend fun filter(search: String, filter: String): List<NurseEntity> {
        return localDataSource.filter(search, filter)
    }


    suspend fun getTopNursesForFilter(search: String): List<NurseEntity> {
        return localDataSource.getTopNursesForFilter(search)
    }

    suspend fun insertOneComment(comment: CommentEntity) {
        return localDataSource.insertOneComment(comment)
    }

    suspend fun insertNurse(nurseEntity: NurseEntity) {
        localDataSource.insertNurse(nurseEntity)
    }
}