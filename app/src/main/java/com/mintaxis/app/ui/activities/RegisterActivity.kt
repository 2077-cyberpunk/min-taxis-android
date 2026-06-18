package com.mintaxis.app.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var backButton: ImageButton
    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var registerButton: Button
    private lateinit var loginLink: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        backButton = findViewById(R.id.backButton)
        fullName = findViewById(R.id.fullName)
        email = findViewById(R.id.email)
        phoneNumber = findViewById(R.id.phoneNumber)
        password = findViewById(R.id.password)
        confirmPassword = findViewById(R.id.confirmPassword)
        registerButton = findViewById(R.id.registerButton)
        loginLink = findViewById(R.id.loginLink)
    }
    
    private fun setupClickListeners() {
        backButton.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
        
        registerButton.setOnClickListener {
            performRegistration()
        }
        
        loginLink.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }
    
    private fun performRegistration() {
        val name = fullName.text.toString().trim()
        val mail = email.text.toString().trim()
        val phone = phoneNumber.text.toString().trim()
        val pass = password.text.toString().trim()
        val confirmPass = confirmPassword.text.toString().trim()
        
        if (name.isEmpty()) {
            fullName.error = "Name required"
            return
        }
        
        if (mail.isEmpty()) {
            email.error = "Email required"
            return
        }
        
        if (phone.isEmpty()) {
            phoneNumber.error = "Phone number required"
            return
        }
        
        if (pass.isEmpty()) {
            password.error = "Password required"
            return
        }
        
        if (pass != confirmPass) {
            confirmPassword.error = "Passwords don't match"
            return
        }
        
        // Show loading state
        registerButton.isEnabled = false
        registerButton.text = "Creating account..."
        
        // Simulate registration - replace with actual registration
        registerButton.postDelayed({
            registerButton.isEnabled = true
            registerButton.text = "Sign Up"
            
            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
            
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
