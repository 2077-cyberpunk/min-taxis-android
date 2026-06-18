package com.mintaxis.app.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var backButton: ImageButton
    private lateinit var fullName: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var phoneNumber: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var confirmPassword: TextInputEditText
    private lateinit var registerButton: Button
    private lateinit var loginLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        try {
            backButton = findViewById(R.id.backButton)
            fullName = findViewById(R.id.fullName)
            email = findViewById(R.id.email)
            phoneNumber = findViewById(R.id.phoneNumber)
            password = findViewById(R.id.password)
            confirmPassword = findViewById(R.id.confirmPassword)
            registerButton = findViewById(R.id.registerButton)
            loginLink = findViewById(R.id.loginLink)

            registerButton.setOnClickListener {
                performRegistration()
            }

            loginLink.setOnClickListener {
                finish()
            }

            backButton.setOnClickListener {
                finish()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun performRegistration() {
        try {
            val name = fullName.text?.toString()?.trim() ?: ""
            val mail = email.text?.toString()?.trim() ?: ""
            val phone = phoneNumber.text?.toString()?.trim() ?: ""
            val pass = password.text?.toString()?.trim() ?: ""
            val confirmPass = confirmPassword.text?.toString()?.trim() ?: ""

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

            registerButton.isEnabled = false
            registerButton.text = "Creating account..."

            registerButton.postDelayed({
                try {
                    registerButton.isEnabled = true
                    registerButton.text = "SIGN UP"

                    Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }, 1500)
        } catch (e: Exception) {
            Toast.makeText(this, "Registration error: ${e.message}", Toast.LENGTH_SHORT).show()
            registerButton.isEnabled = true
            registerButton.text = "SIGN UP"
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}
