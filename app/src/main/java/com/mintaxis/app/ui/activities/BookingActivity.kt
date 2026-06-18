package com.mintaxis.app.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R

class BookingActivity : AppCompatActivity() {
    
    private lateinit var backButton: ImageButton
    private lateinit var pickupLocation: EditText
    private lateinit var destination: EditText
    private lateinit var fareSeekBar: SeekBar
    private lateinit var fareValue: TextView
    private lateinit var sedanOption: TextView
    private lateinit var suvOption: TextView
    private lateinit var vanOption: TextView
    private lateinit var findDriversButton: Button
    
    private var selectedFare = 20
    private var selectedVehicle = "sedan"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        backButton = findViewById(R.id.backButton)
        pickupLocation = findViewById(R.id.pickupLocation)
        destination = findViewById(R.id.destination)
        fareSeekBar = findViewById(R.id.fareSeekBar)
        fareValue = findViewById(R.id.fareValue)
        sedanOption = findViewById(R.id.sedanOption)
        suvOption = findViewById(R.id.suvOption)
        vanOption = findViewById(R.id.vanOption)
        findDriversButton = findViewById(R.id.findDriversButton)
    }
    
    private fun setupClickListeners() {
        backButton.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
        
        fareSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                selectedFare = progress + 5
                fareValue.text = "$$selectedFare"
            }
            
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        
        sedanOption.setOnClickListener { selectVehicle("sedan") }
        suvOption.setOnClickListener { selectVehicle("suv") }
        vanOption.setOnClickListener { selectVehicle("van") }
        
        findDriversButton.setOnClickListener {
            val intent = Intent(this, DriverMatchingActivity::class.java)
            intent.putExtra("pickup", pickupLocation.text.toString())
            intent.putExtra("destination", destination.text.toString())
            intent.putExtra("fare", selectedFare)
            intent.putExtra("vehicle", selectedVehicle)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }
    
    private fun selectVehicle(type: String) {
        selectedVehicle = type
        
        sedanOption.setBackgroundResource(R.drawable.vehicle_option_background)
        suvOption.setBackgroundResource(R.drawable.vehicle_option_background)
        vanOption.setBackgroundResource(R.drawable.vehicle_option_background)
        
        when (type) {
            "sedan" -> sedanOption.setBackgroundResource(R.drawable.vehicle_option_selected_background)
            "suv" -> suvOption.setBackgroundResource(R.drawable.vehicle_option_selected_background)
            "van" -> vanOption.setBackgroundResource(R.drawable.vehicle_option_selected_background)
        }
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}
