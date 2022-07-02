package com.example.nurseapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DayEntity (
    @PrimaryKey var nurseId : Int,
    var saturday : Boolean = true,
    var sunday : Boolean = true,
    var monday : Boolean = true,
    var tuesday : Boolean = true,
    var wednesday : Boolean = true,
    var thursday : Boolean = true,
    var friday : Boolean = true,
        )