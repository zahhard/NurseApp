package com.example.nurseapp.data.database

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [NurseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun companyDao(): Dao

    companion object{
        const val DATABASE_NAME: String = "myDB"
    }

}