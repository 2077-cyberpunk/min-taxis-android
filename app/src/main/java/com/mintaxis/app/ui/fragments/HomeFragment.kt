package com.mintaxis.app.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        view.findViewById<View>(R.id.searchDestination)?.setOnClickListener { openBooking() }
        view.findViewById<View>(R.id.bookRideButton)?.setOnClickListener { openBooking() }

        view.findViewById<View>(R.id.parcelButton)?.setOnClickListener {
            Toast.makeText(requireContext(), "Parcel service coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<View>(R.id.scheduleButton)?.setOnClickListener {
            Toast.makeText(requireContext(), "Schedule feature coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<View>(R.id.recentLocation1)?.setOnClickListener { openBooking() }
        view.findViewById<View>(R.id.recentLocation2)?.setOnClickListener { openBooking() }
        view.findViewById<View>(R.id.recentLocation3)?.setOnClickListener { openBooking() }
    }

    private fun openBooking() {
        try {
            val intent = Intent(requireContext(), BookingActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}
