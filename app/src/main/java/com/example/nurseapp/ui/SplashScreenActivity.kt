package com.example.nurseapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nurseapp.MainActivity
import com.example.nurseapp.R
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        val imageView = findViewById<ImageView>(R.id.sss)
        val fragment = findViewById<View>(R.id.fragmentContainerView)
        val loadingTV = findViewById<TextView>(R.id.loading)
        val tvName = findViewById<TextView>(R.id.name)
        imageView.alpha=0f
        loadingTV.alpha=0f
        tvName.alpha=0f
        fragment.alpha = 0f
        imageView.animate().setDuration(5000).alpha(0.3f).withEndAction {
            fragment.visibility=View.VISIBLE
            imageView.visibility=View.GONE
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            fragment.visibility=View.VISIBLE
            fragment.animate().setDuration(1000).alpha(1f).withEndAction{
            }
        }
        loadingTV.animate().setDuration(5000).alpha(1f).withEndAction{
            fragment.visibility=View.VISIBLE
            loadingTV.visibility=View.GONE
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
        tvName.animate().setDuration(5000).alpha(1f).withEndAction{
            fragment.visibility=View.VISIBLE
            tvName.visibility=View.GONE
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
    }
}