package com.example.nurseapp.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.nurseapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN )
        supportActionBar?.hide()
        val imageView = findViewById<ImageView>(R.id.sss)
        val fragment = findViewById<View>(R.id.fragmentContainerView)
        val loadingTV = findViewById<TextView>(R.id.loading)
        val tvName = findViewById<TextView>(R.id.name)
        val bottomNavigationViewt = findViewById<BottomNavigationView>(R.id.navigation)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment?
        setupWithNavController(bottomNavigationViewt, navHostFragment!!.navController)
        imageView.alpha = 0f
        loadingTV.alpha = 0f
        tvName.alpha = 0f
        fragment.alpha = 0f
        bottomNavigationViewt.alpha = 0f
        imageView.animate().setDuration(5000).alpha(0.3f).withEndAction {
            fragment.visibility = View.VISIBLE
            imageView.visibility = View.GONE
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            fragment.visibility = View.VISIBLE
            fragment.animate().setDuration(1000).alpha(1f).withEndAction {
            }
            bottomNavigationViewt.animate().setDuration(1000).alpha(1f).withEndAction {
            }
        }
        loadingTV.animate().setDuration(5000).alpha(1f).withEndAction {
            fragment.visibility = View.VISIBLE
            loadingTV.visibility = View.GONE
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
        tvName.animate().setDuration(5000).alpha(1f).withEndAction {
            fragment.visibility = View.VISIBLE
            tvName.visibility = View.GONE
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}