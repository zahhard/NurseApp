package com.example.nurseapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderEntity(
    @PrimaryKey var id: Int = 0,
    var userId: Int,
    var nurseId: Int,
    var start_time: String,
    var day_count: Int,
)