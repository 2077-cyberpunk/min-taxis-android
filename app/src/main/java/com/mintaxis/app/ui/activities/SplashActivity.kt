package com.mintaxis.app.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    
    private val SPLASH_DELAY = 2500L
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        
        val logo = findViewById<ImageView>(R.id.splashLogo)
        val tagline = findViewById<TextView>(R.id.splashTagline)
        
        // Fade in animation for logo
        val fadeIn = AlphaAnimation(0.0f, 1.0f).apply {
            duration = 800
            fillAfter = true
        }
        
        // Fade in animation for tagline with delay
        val taglineFadeIn = AlphaAnimation(0.0f, 1.0f).apply {
            duration = 600
            startOffset = 400
            fillAfter = true
        }
        
        logo.startAnimation(fadeIn)
        tagline.startAnimation(taglineFadeIn)
        
        // Navigate to main activity after delay
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, SPLASH_DELAY)
    }
}
