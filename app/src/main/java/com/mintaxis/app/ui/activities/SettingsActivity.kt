package com.mintaxis.app.ui.activities

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_settings)
            findViewById<ImageButton>(R.id.backButton)?.setOnClickListener { finish() }

            findViewById<android.view.View>(R.id.languageItem)?.setOnClickListener {
                Toast.makeText(this, "Language settings coming soon", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) { finish() }
    }
}
