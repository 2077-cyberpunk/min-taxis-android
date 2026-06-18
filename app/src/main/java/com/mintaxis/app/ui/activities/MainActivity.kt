package com.mintaxis.app.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mintaxis.app.R
import com.mintaxis.app.ui.fragments.HomeFragment
import com.mintaxis.app.ui.fragments.RidesFragment
import com.mintaxis.app.ui.fragments.WalletFragment
import com.mintaxis.app.ui.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var notificationButton: ImageButton
    private lateinit var locationText: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        initViews()
        setupBottomNavigation()
        loadFragment(HomeFragment())
    }
    
    private fun initViews() {
        bottomNavigation = findViewById(R.id.bottomNavigation)
        notificationButton = findViewById(R.id.notificationButton)
        locationText = findViewById(R.id.locationText)
        
        notificationButton.setOnClickListener {
            // Open notifications
        }
    }
    
    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_rides -> {
                    loadFragment(RidesFragment())
                    true
                }
                R.id.nav_wallet -> {
                    loadFragment(WalletFragment())
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }
    
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
