package com.mintaxis.app.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mintaxis.app.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<LinearLayout>(R.id.contactUsItem)?.setOnClickListener {
            showContactDialog()
        }

        view.findViewById<LinearLayout>(R.id.servicesItem)?.setOnClickListener {
            showServicesDialog()
        }

        view.findViewById<LinearLayout>(R.id.safetyItem)?.setOnClickListener {
            showSafetyDialog()
        }

        view.findViewById<LinearLayout>(R.id.faqsItem)?.setOnClickListener {
            showFaqDialog()
        }

        view.findViewById<LinearLayout>(R.id.aboutItem)?.setOnClickListener {
            showAboutDialog()
        }

        view.findViewById<LinearLayout>(R.id.myRidesItem)?.setOnClickListener {
            Toast.makeText(requireContext(), "Ride history coming soon", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showContactDialog() {
        val dialog = android.app.AlertDialog.Builder(requireContext())
            .setTitle("Contact MIN Taxis")
            .setMessage(
                "HEAD OFFICE\n" +
                "37 Chedgelow Road, Hatfield, Harare\n\n" +
                "Phone Numbers:\n" +
                "+263 772 887 897\n" +
                "+263 772 840 619\n" +
                "+263 (242) 747 145\n" +
                "+263 (242) 571 143/50\n\n" +
                "Email: info@mintaxis.co.zw\n\n" +
                "BULAWAYO BRANCH\n" +
                "1 Cowden Road, Siyakha Warehouse Complex\n" +
                "Phone: +263 (292) 260 100"
            )
            .setPositiveButton("Call Head Office") { _, _ ->
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:+263772887897")
                startActivity(intent)
            }
            .setNegativeButton("Close", null)
            .create()
        dialog.show()
    }

    private fun showServicesDialog() {
        android.app.AlertDialog.Builder(requireContext())
            .setTitle("Our Services")
            .setMessage(
                "MIN Taxis offers:\n\n" +
                "• Contract Taxis\n" +
                "• Pre-paid Taxis\n" +
                "• Cash Taxis\n" +
                "• Unmarked Taxis\n" +
                "• Car Rental\n\n" +
                "130+ Taxis with UHF Radios\n" +
                "Available 24/7 throughout the year"
            )
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showSafetyDialog() {
        android.app.AlertDialog.Builder(requireContext())
            .setTitle("Safety & Security")
            .setMessage(
                "Your safety is our priority:\n\n" +
                "• All drivers trained in safe driving\n" +
                "• Traffic Safety Council certified\n" +
                "• Regular vehicle maintenance\n" +
                "• UHF radio tracking system\n" +
                "• Professional business etiquette"
            )
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showFaqDialog() {
        android.app.AlertDialog.Builder(requireContext())
            .setTitle("FAQs")
            .setMessage(
                "Q: How do I book?\n" +
                "A: Call our dispatch center\n\n" +
                "Q: Payment options?\n" +
                "A: Cash, vouchers, prepaid\n\n" +
                "Q: 24/7 service?\n" +
                "A: Yes, every day of the year\n\n" +
                "Q: How to track taxi?\n" +
                "A: UHF radios provide real-time tracking"
            )
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showAboutDialog() {
        android.app.AlertDialog.Builder(requireContext())
            .setTitle("About MIN Taxis")
            .setMessage(
                "MIN Taxis (Private) Limited\n" +
                "Established in 2004\n\n" +
                "We are a family-owned business and the biggest taxi services provider in Zimbabwe with over 130 Taxis equipped with UHF Radios.\n\n" +
                "Operating 24/7 throughout the year.\n\n" +
                "Clients include: Delta, Deloitte, British Council, Save the Children, BancABC, CARE, OK Zimbabwe, ZB Bank, Stanbic, Simbisa, and Oxfam."
            )
            .setPositiveButton("OK", null)
            .show()
    }
}
