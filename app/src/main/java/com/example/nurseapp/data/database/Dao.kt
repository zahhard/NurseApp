package com.example.nurseapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

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
    suspend fun getAll() : List<NurseEntity>


    @Query("SELECT * FROM NurseEntity ORDER BY NurseEntity.average_rate ")
    suspend fun getTopNurses() : List<NurseEntity>

}