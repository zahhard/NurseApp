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
 //   https://www.who.int/images/default-source/health-topics/nursing/nursing-jamaica/treciacrop.png?sfvrsn=390763b_4


    //// baby care ////  https://img.icons8.com/fluency/344/mother-room.png
    //// general care ////  https://img.icons8.com/cotton/344/spa-care.png
    //// elderly care ////  https://img.icons8.com/color/344/elderly-person.png


    suspend fun setTestData() {
        appDatabase.companyDao().insertAll(
            NurseEntity(1,1,"Janis", "Joplin", "09558741259", 2F, "baby care", "https://nurseweek.com/wp-content/uploads/2021/08/SEO-783-bs-Portrait-of-a-smiling-nurse-168968912-1200x675-1.jpg"),
            NurseEntity(2,2,"Jennifer", "Aniston", "09558741259", 5F, "general care", "https://st.focusedcollection.com/19002158/i/650/focused_224031048-stock-photo-portrait-smiling-female-nurse-standing.jpg"),
            NurseEntity(3,3,"John", "Barrowman", "09558741259", 8F, "bandage", "https://ak.picdn.net/shutterstock/videos/15902578/thumb/1.jpg"),
            NurseEntity(4,4,"Daniella", "Westbrook", "09558741259", 1F, "elderly care", "https://thevideoink.com/wp-content/uploads/2021/11/wysiwyg-uploads_1569586526901-doctor.jpg"),
            NurseEntity(5,5,"Sarah", "Conner", "09558741259", 3F, "baby care", "https://topperacademygroupofinstitutions.com/wp-content/uploads/2020/12/female-nurse.jpg"),
            NurseEntity(6,6,"James", "Blake", "09558741259", 3F, "elderly care", "https://www.eatthis.com/wp-content/uploads/sites/4/2021/09/doctors-face-mask-hospital.jpg?quality=82&strip=1"),
            NurseEntity(7,7,"Ali", "Babakhanlu", "09558741259", 3F, "general care", "https://ak.picdn.net/shutterstock/videos/1048920514/thumb/1.jpg"),
            NurseEntity(8,8,"Zahra", "Davardoust", "09558741259", 3F, "bandage", "https://www.ecpi.edu/sites/default/files/Nursing%20Sept%2027.png"),
            NurseEntity(9,9,"Ahmet", "Kaya", "09558741259", 3F, "baby care", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxc390YnqIN5Rtfo7MvaMPEfrARIJL2MiDhQ&usqp=CAU"),
            NurseEntity(10,10,"Nazanin", "Akbari", "09558741259", 3F, "elderly care", "https://www.nurse.com/blog/wp-content/uploads/2019/03/what_makes_good_nurse.jpg"),
            NurseEntity(11,11,"Amir", "Jahani", "09558741259", 3F, "ganeral care", "https://static01.nyt.com/images/2020/03/26/nyregion/26nyvirus-nurse/26nyvirus-nurse-mediumSquareAt3X.jpg"),
            NurseEntity(12,12,"Fatemeh", "Mahmodi", "09558741259", 3F, "bandage", "https://dm1zcrsul8wju.cloudfront.net/sites/rcn_nspace/files/styles/tile_image/public/Article-images/184316/31954.jpeg?itok=Rmzb-Wni"),
            NurseEntity(13,13,"Hamid", "Hamidi", "09558741259", 3F, "bandage", "https://higherlogicdownload.s3.amazonaws.com/NASN/8575d1b7-94ad-45ab-808e-d45019cc5c08/UploadedImages/Hero_Images/SLV-Vaccines.png"),
            NurseEntity(14,14,"Mohammad", "Nouri", "09558741259", 3F, "general care", "https://onlinenursing.cn.edu/sites/default/files/cn-2021-nursing-trends-11-600x400.jpg"),
            NurseEntity(15,15,"Sina", "gholizadeh", "09558741259", 3F, "baby care", "https://www.eatthis.com/wp-content/uploads/sites/4/2021/12/doctor-face-mask-hospital.jpg?quality=82&strip=all"),
            NurseEntity(16,16,"Mohsen", "Badali", "09558741259", 3F, "elderly care", "https://www.waldenu.edu/-/media/walden/images/seo-article/seo-662-bs-healthcare-people-group-profe-294762073-1200x675.jpg?rev=332db21ba2204fcead5a558d2bab91f0&hash=B97575BB15C2BB8093057C34E8EAD1D5"),
        )
        appDatabase.companyDao().insertOrder(
            OrderEntity(1,173285739,0,"2022.05.6",5,),
            OrderEntity(2,173285739,1, "2022.05.6",3),
            OrderEntity(3,173285739, 2, "2022.05.6",4),
            OrderEntity(4,173285739,3, "2022.05.6",1),
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

    suspend fun getAllOrdersForUser(id:  Int): List<OrderEntity>? {
        return appDatabase.companyDao().getAllOrdersForUser(id)
    }

    suspend fun getAllOrdersForNurse(id:  Int): List<OrderEntity>? {
        return appDatabase.companyDao().getAllOrdersForNurse(id)
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

    suspend fun getTopNursesForFilter(search: String): List<NurseEntity> {
        return appDatabase.companyDao().getTopNursesForFilter(search)
    }

    suspend fun search(search: String): List<NurseEntity> {
        return appDatabase.companyDao().search(search)
    }

    suspend fun filter(search: String, filter: String): List<NurseEntity> {
        return appDatabase.companyDao().filter(search, filter)
    }

    suspend fun insertOneComment(comment: CommentEntity) {
        return appDatabase.companyDao().insertComment(comment)
    }

    suspend fun insertNurse(nurseEntity: NurseEntity) {
        appDatabase.companyDao().insertAll(nurseEntity)
    }

    suspend fun setOrder(order: OrderEntity) {
        appDatabase.companyDao().insertOrder(order)
    }
}