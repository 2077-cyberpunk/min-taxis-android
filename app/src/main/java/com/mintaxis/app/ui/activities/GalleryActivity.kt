package com.mintaxis.app.ui.activities

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_gallery)
            findViewById<ImageButton>(R.id.backButton)?.setOnClickListener { finish() }
        } catch (e: Exception) {
            finish()
        }
    }
}
