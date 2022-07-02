package com.example.nurseapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    //    @Query("SELECT COUNT(*) FROM NurseEntity")
//    fun getCount(): LiveData<Int>
//
//    @Query("SELECT COUNT(formulaItemList) FROM NurseEntity")
//    fun getCountItem(): Int
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg nurseEntity: NurseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(vararg orderEntity: OrderEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(vararg commentEntity: CommentEntity)


//
//    @Query("DELETE FROM NurseEntity")
//    fun deleteAll()
//
//    @Query("SELECT * FROM NurseEntity WHERE code LIKE :search")
//    fun loadWord(search: String?): NurseEntity
//
//    @Update//(entity = WordEntity::class)
//    fun update(obj: NurseEntity)
//
//    @Delete(entity = NurseEntity::class)
//    fun deleteWord(word: NurseEntity)

    @Query("SELECT * FROM NurseEntity")
    suspend fun getAll(): List<NurseEntity>


    @Query("SELECT * FROM NurseEntity WHERE education LIKE :educationn")
    suspend fun getNursesOrderByCategory(educationn: String): List<NurseEntity>


    @Query("SELECT * FROM NurseEntity ORDER BY NurseEntity.average_rate ")
    suspend fun getTopNurses(): List<NurseEntity>


    @Query("SELECT * FROM NurseEntity WHERE lname LIKE '%' || :search || '%' OR fname LIKE '%' || :search || '%' OR education LIKE '%' || :search || '%' OR phone LIKE '%' || :search || '%' ORDER BY NurseEntity.average_rate ")
    suspend fun getTopNursesForFilter(search: String): List<NurseEntity>


    @Query("SELECT * FROM OrderEntity WHERE userId LIKE :userId")
    suspend fun getAllOrdersForUser(userId : Int): List<OrderEntity>?


    @Query("SELECT * FROM OrderEntity WHERE nurseId LIKE :nurseId")
    suspend fun getAllOrdersForNurse(nurseId : Int): List<OrderEntity>?


    @Query("SELECT * FROM CommentEntity WHERE nurseId LIKE :nurseId")
    fun getComments(nurseId: Int): List<CommentEntity>


    @Query("SELECT * FROM NurseEntity WHERE nurseId LIKE :id")
    suspend fun getOneNurse(id: Int): NurseEntity


    @Query("SELECT * FROM UserEntity WHERE userID LIKE :id")
    suspend fun getOneUser(id: Int): UserEntity

    @Query(
        "SELECT * FROM NurseEntity WHERE lname LIKE '%' || :search || '%'" +
                " OR fname LIKE '%' || :search || '%'" +
                " OR education LIKE '%' || :search || '%'" +
                " OR phone LIKE '%' || :search || '%'"
    )
    suspend fun search(search: String): List<NurseEntity>


    @Query(
        "SELECT * FROM NurseEntity WHERE lname LIKE '%' || :search || '%'" +
        " OR fname LIKE '%' || :search || '%'" +
                " OR education LIKE '%' || :search || '%'" +
                " OR phone LIKE '%' || :search || '%' AND education LIKE '%' || :filter " )
    suspend fun filter(search: String, filter: String): List<NurseEntity>

}