package com.example.nurseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_NurseApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}