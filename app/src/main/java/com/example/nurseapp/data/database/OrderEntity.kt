package com.example.nurseapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderEntity (
    @PrimaryKey var id : Int = 0,
    var orderName : String,
    var date : String ,
    var nurse : String ,
        )