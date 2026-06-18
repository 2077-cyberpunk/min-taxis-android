package com.mintaxis.app.ui.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupBottomNavigation()
        loadFragment(HomeFragment())
    }

    private fun initViews() {
        bottomNavigation = findViewById(R.id.bottomNavigation)

        findViewById<ImageButton>(R.id.callDispatchButton)?.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+263772887897")
            startActivity(intent)
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
