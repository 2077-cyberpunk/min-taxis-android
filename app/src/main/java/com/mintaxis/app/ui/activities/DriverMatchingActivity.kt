package com.mintaxis.app.ui.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R

class DriverMatchingActivity : AppCompatActivity() {
    
    private lateinit var cancelButton: Button
    private lateinit var statusText: TextView
    
    private val handler = Handler(Looper.getMainLooper())
    private var matchingProgress = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_matching)
        
        initViews()
        setupClickListeners()
        startMatchingAnimation()
    }
    
    private fun initViews() {
        cancelButton = findViewById(R.id.cancelButton)
        statusText = findViewById(R.id.statusText)
    }
    
    private fun setupClickListeners() {
        cancelButton.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }
    
    private fun startMatchingAnimation() {
        val updateRunnable = object : Runnable {
            override fun run() {
                matchingProgress += 2
                
                if (matchingProgress <= 100) {
                    handler.postDelayed(this, 50)
                } else {
                    // Matching complete - simulate finding a driver
                    statusText.text = "Driver found!"
                    handler.postDelayed({
                        // Navigate to ride screen or show driver info
                        finish()
                    }, 1500)
                }
            }
        }
        
        handler.postDelayed(updateRunnable, 500)
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        handler.removeCallbacksAndMessages(null)
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
    
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
