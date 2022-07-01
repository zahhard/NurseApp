package com.example.nurseapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    @PrimaryKey var userID : Int,
    var name: String = "",
    var lname: String = "",
//    `birthdate` DATE NOT NULL,
//    `email` VARCHAR(50) NOT NULL,
    var phone : String = "" ,
//    `username` VARCHAR(20) NOT NULL,
//    `password` VARCHAR(30) NOT NULL,
//    `country` VARCHAR(20) NOT NULL,
    var city: String = "New York",
    var address: String = "",

)