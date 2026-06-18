package com.mintaxis.app.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R

class LoginActivity : AppCompatActivity() {
    
    private lateinit var phoneNumber: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var registerLink: TextView
    private lateinit var forgotPassword: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        phoneNumber = findViewById(R.id.phoneNumber)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)
        registerLink = findViewById(R.id.registerLink)
        forgotPassword = findViewById(R.id.forgotPassword)
    }
    
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            performLogin()
        }
        
        registerLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
        
        forgotPassword.setOnClickListener {
            Toast.makeText(this, "Password reset coming soon", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun performLogin() {
        val phone = phoneNumber.text.toString().trim()
        val pass = password.text.toString().trim()
        
        if (phone.isEmpty()) {
            phoneNumber.error = "Phone number required"
            return
        }
        
        if (pass.isEmpty()) {
            password.error = "Password required"
            return
        }
        
        // Show loading state
        loginButton.isEnabled = false
        loginButton.text = "Logging in..."
        
        // Simulate login - replace with actual authentication
        loginButton.postDelayed({
            loginButton.isEnabled = true
            loginButton.text = "Login"
            
            // Navigate to main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 1500)
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}
