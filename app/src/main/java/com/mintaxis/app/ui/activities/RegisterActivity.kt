package com.mintaxis.app.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private var fullName: TextInputEditText? = null
    private var phoneNumber: TextInputEditText? = null
    private var password: TextInputEditText? = null
    private var confirmPassword: TextInputEditText? = null
    private var registerButton: TextView? = null
    private var loginLink: TextView? = null
    private var backButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_register)
            fullName = findViewById(R.id.fullName)
            phoneNumber = findViewById(R.id.phoneNumber)
            password = findViewById(R.id.password)
            confirmPassword = findViewById(R.id.confirmPassword)
            registerButton = findViewById(R.id.registerButton)
            loginLink = findViewById(R.id.loginLink)
            backButton = findViewById(R.id.backButton)

            registerButton?.setOnClickListener { performRegister() }

            loginLink?.setOnClickListener {
                try {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }

            backButton?.setOnClickListener { finish() }
        } catch (e: Exception) {
            Toast.makeText(this, "Init error", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun performRegister() {
        val name = fullName?.text?.toString()?.trim() ?: ""
        val phone = phoneNumber?.text?.toString()?.trim() ?: ""
        val pass = password?.text?.toString()?.trim() ?: ""
        val confirm = confirmPassword?.text?.toString()?.trim() ?: ""

        if (name.isEmpty()) { fullName?.error = "Required"; return }
        if (phone.isEmpty()) { phoneNumber?.error = "Required"; return }
        if (pass.isEmpty()) { password?.error = "Required"; return }
        if (pass != confirm) { confirmPassword?.error = "Passwords do not match"; return }

        registerButton?.isEnabled = false
        registerButton?.text = "Creating account..."

        registerButton?.postDelayed({
            try {
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            } catch (e: Exception) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                registerButton?.isEnabled = true
                registerButton?.text = "CREATE ACCOUNT"
            }
        }, 2000)
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        super.onBackPressed()
    }
}
