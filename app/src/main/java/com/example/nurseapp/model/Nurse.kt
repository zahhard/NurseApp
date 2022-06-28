package com.example.nurseapp.model

class Nurse (
    var nurseID : Int = 0,
    var fname : String = "" ,
    var lname: String = "f" ,
//    `birthdate` DATE NOT NULL,
//    `email` VARCHAR(50) NOT NULL,
//    `phone` VARCHAR(15) NOT NULL,
//    `username` VARCHAR(20) NOT NULL,
//    `password` VARCHAR(30) NOT NULL,
//    `country` VARCHAR(20) NOT NULL,
//    `city` VARCHAR(20) NOT NULL,
//    `address` VARCHAR(100) DEFAULT NULL,
//    `average_rate` FLOAT NOT NULL,
    var education: String = "bandage" ,
//    `experience` DATE NOT NULL,
//    `skill` VARCHAR(500) NOT NULL,
//    `visit` INT NOT NULL,
//    `startdate` DATE NOT NULL,
//    `endofreserve` DATE NOt NULL,
    var image : String = ""
//    PRIMARY KEY(`nurseID`)
)