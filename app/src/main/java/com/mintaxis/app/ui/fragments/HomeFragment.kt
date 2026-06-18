package com.mintaxis.app.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mintaxis.app.R
import com.mintaxis.app.ui.activities.BookingActivity

class HomeFragment : Fragment() {
    
    private lateinit var searchDestination: EditText
    private lateinit var bookRideButton: Button
    private lateinit var recentLocation1: LinearLayout
    private lateinit var recentLocation2: LinearLayout
    private lateinit var recentLocation3: LinearLayout
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        initViews(view)
        setupClickListeners()
    }
    
    private fun initViews(view: View) {
        searchDestination = view.findViewById(R.id.searchDestination)
        bookRideButton = view.findViewById(R.id.bookRideButton)
        recentLocation1 = view.findViewById(R.id.recentLocation1)
        recentLocation2 = view.findViewById(R.id.recentLocation2)
        recentLocation3 = view.findViewById(R.id.recentLocation3)
    }
    
    private fun setupClickListeners() {
        searchDestination.setOnClickListener {
            openBookingActivity()
        }
        
        bookRideButton.setOnClickListener {
            openBookingActivity()
        }
        
        recentLocation1.setOnClickListener {
            openBookingActivity()
        }
        
        recentLocation2.setOnClickListener {
            openBookingActivity()
        }
        
        recentLocation3.setOnClickListener {
            openBookingActivity()
        }
    }
    
    private fun openBookingActivity() {
        val intent = Intent(requireContext(), BookingActivity::class.java)
        startActivity(intent)
        requireActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}
