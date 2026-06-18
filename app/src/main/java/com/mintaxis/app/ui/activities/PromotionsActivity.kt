package com.mintaxis.app.ui.activities

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R

class PromotionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_promotions)
            findViewById<ImageButton>(R.id.backButton)?.setOnClickListener { finish() }
        } catch (e: Exception) { finish() }
    }
}
