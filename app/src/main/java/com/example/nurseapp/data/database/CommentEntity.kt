package com.example.nurseapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CommentEntity (
    @PrimaryKey val id : Int,
    var nurseId : Int ,
    var massage: String,
    var date : String,
    var title : String
        )