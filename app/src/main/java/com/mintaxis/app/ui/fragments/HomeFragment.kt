package com.mintaxis.app.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mintaxis.app.R
import com.mintaxis.app.ui.activities.BookingActivity

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchBox = view.findViewById<EditText>(R.id.searchDestination)
        val bookButton = view.findViewById<LinearLayout>(R.id.bookRideButton)
        val parcelButton = view.findViewById<LinearLayout>(R.id.parcelButton)
        val scheduleButton = view.findViewById<LinearLayout>(R.id.scheduleButton)
        val recentLocation1 = view.findViewById<LinearLayout>(R.id.recentLocation1)
        val recentLocation2 = view.findViewById<LinearLayout>(R.id.recentLocation2)
        val recentLocation3 = view.findViewById<LinearLayout>(R.id.recentLocation3)

        searchBox?.isFocusable = false
        searchBox?.setOnClickListener { openBooking() }

        bookButton?.setOnClickListener { openBooking() }

        parcelButton?.setOnClickListener {
            Toast.makeText(requireContext(), "Parcel service coming soon", Toast.LENGTH_SHORT).show()
        }

        scheduleButton?.setOnClickListener {
            Toast.makeText(requireContext(), "Schedule feature coming soon", Toast.LENGTH_SHORT).show()
        }

        recentLocation1?.setOnClickListener { openBooking() }
        recentLocation2?.setOnClickListener { openBooking() }
        recentLocation3?.setOnClickListener { openBooking() }
    }

    private fun openBooking() {
        val intent = Intent(requireContext(), BookingActivity::class.java)
        startActivity(intent)
        requireActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}
