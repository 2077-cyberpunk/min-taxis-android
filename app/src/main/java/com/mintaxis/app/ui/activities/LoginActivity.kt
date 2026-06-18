package com.mintaxis.app.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private var phoneNumber: TextInputEditText? = null
    private var password: TextInputEditText? = null
    private var loginButton: TextView? = null
    private var registerLink: TextView? = null
    private var forgotPassword: TextView? = null
    private var backButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_login)
            phoneNumber = findViewById(R.id.phoneNumber)
            password = findViewById(R.id.password)
            loginButton = findViewById(R.id.loginButton)
            registerLink = findViewById(R.id.registerLink)
            forgotPassword = findViewById(R.id.forgotPassword)
            backButton = findViewById(R.id.backButton)

            loginButton?.setOnClickListener { performLogin() }

            registerLink?.setOnClickListener {
                try {
                    startActivity(Intent(this, RegisterActivity::class.java))
                } catch (e: Exception) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }

            forgotPassword?.setOnClickListener {
                Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
            }

            backButton?.setOnClickListener { finish() }
        } catch (e: Exception) {
            Toast.makeText(this, "Init error", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun performLogin() {
        val phone = phoneNumber?.text?.toString()?.trim() ?: ""
        val pass = password?.text?.toString()?.trim() ?: ""

        if (phone.isEmpty()) { phoneNumber?.error = "Required"; return }
        if (pass.isEmpty()) { password?.error = "Required"; return }

        loginButton?.isEnabled = false
        loginButton?.text = "Logging in..."

        loginButton?.postDelayed({
            try {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } catch (e: Exception) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                loginButton?.isEnabled = true
                loginButton?.text = "LOGIN"
            }
        }, 1500)
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        super.onBackPressed()
    }
}
