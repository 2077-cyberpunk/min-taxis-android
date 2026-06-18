package com.mintaxis.app.ui.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R

class HelpSupportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_help_support)
            findViewById<ImageButton>(R.id.backButton)?.setOnClickListener { finish() }

            findViewById<android.view.View>(R.id.callUsButton)?.setOnClickListener {
                try {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:+263772887897")
                    startActivity(intent)
                } catch (e: Exception) { Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show() }
            }

            findViewById<android.view.View>(R.id.emailUsButton)?.setOnClickListener {
                try {
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:info@mintaxis.co.zw")
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Support Request - MIN Taxis App")
                    startActivity(intent)
                } catch (e: Exception) { Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show() }
            }

            findViewById<android.view.View>(R.id.whatsappButton)?.setOnClickListener {
                try {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:+263772887897")
                    startActivity(intent)
                } catch (e: Exception) { Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show() }
            }

            findViewById<android.view.View>(R.id.sosButton)?.setOnClickListener {
                try {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:+263772887897")
                    startActivity(intent)
                } catch (e: Exception) { Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show() }
            }
        } catch (e: Exception) { finish() }
    }
}
