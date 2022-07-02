package com.example.nurseapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NurseEntity (
    val id: Int = 0,
    @PrimaryKey(autoGenerate = true) var nurseID : Int = 0,
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
    var image : String = "https://img.freepik.com/free-photo/healthcare-workers-preventing-virus-quarantine-campaign-concept-smiling-pleasant-asian-female-physician-doctor-during-examination-wearing-scrubs-holding-clipboard-white-background_1258-21394.jpg?w=2000"
)