package com.mintaxis.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.mintaxis.app.R
import android.content.Intent
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

        searchBox?.isFocusable = false
        searchBox?.setOnClickListener {
            openBooking()
        }

        bookButton?.setOnClickListener {
            openBooking()
        }
    }

    private fun openBooking() {
        val intent = Intent(requireContext(), BookingActivity::class.java)
        startActivity(intent)
        requireActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}
