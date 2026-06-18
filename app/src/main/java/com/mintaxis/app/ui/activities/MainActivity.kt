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

    private var bottomNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_main)
            initViews()
            setupBottomNavigation()
            loadFragment(HomeFragment())
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun initViews() {
        bottomNavigation = findViewById(R.id.bottomNavigation)

        findViewById<ImageButton>(R.id.callDispatchButton)?.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:+263772887897")
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Could not open dialer", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation?.setOnItemSelectedListener { item ->
            try {
                when (item.itemId) {
                    R.id.nav_home -> { loadFragment(HomeFragment()); true }
                    R.id.nav_rides -> { loadFragment(RidesFragment()); true }
                    R.id.nav_wallet -> { loadFragment(WalletFragment()); true }
                    R.id.nav_profile -> { loadFragment(ProfileFragment()); true }
                    else -> false
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Navigation error", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
