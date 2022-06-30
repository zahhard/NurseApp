package com.example.nurseapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NurseEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    var nurseID : Int = 0,
    var fname : String = "",
    var lname: String = "f",
//    `birthdate` DATE NOT NULL,
//    `email` VARCHAR(50) NOT NULL,
   var phone : String = "",
//    `username` VARCHAR(20) NOT NULL,
//    `password` VARCHAR(30) NOT NULL,
//    `country` VARCHAR(20) NOT NULL,
//    `city` VARCHAR(20) NOT NULL,
//    `address` VARCHAR(100) DEFAULT NULL,
    var average_rate: Float = 1.0F,
    var education: String = "bandage",
//    `experience` DATE NOT NULL,
//    `skill` VARCHAR(500) NOT NULL,
//    `visit` INT NOT NULL,
//    `startdate` DATE NOT NULL,
//    `endofreserve` DATE NOt NULL,
    var image : String = ""
)