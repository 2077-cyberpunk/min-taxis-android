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
import com.mintaxis.app.ui.activities.GalleryActivity
import com.mintaxis.app.ui.activities.LoginActivity
import com.mintaxis.app.ui.activities.ReviewsActivity

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

        view.findViewById<LinearLayout>(R.id.galleryItem)?.setOnClickListener {
            try {
                startActivity(Intent(requireContext(), GalleryActivity::class.java))
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<LinearLayout>(R.id.reviewsItem)?.setOnClickListener {
            try {
                startActivity(Intent(requireContext(), ReviewsActivity::class.java))
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<LinearLayout>(R.id.logoutButton)?.setOnClickListener {
            try {
                val intent = Intent(requireContext(), LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
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
                "MIN Taxis - Total Transport Solutions:\n\n" +
                "TAXI SERVICES:\n" +
                "• Contract Taxis - Daily commute solutions\n" +
                "• Pre-paid Taxis - Pay in advance\n" +
                "• Cash Taxis - Pay per ride\n" +
                "• Unmarked Taxis - Discreet travel\n\n" +
                "CAR RENTAL:\n" +
                "• Daily, Weekly & Monthly rentals\n" +
                "• Sedans, SUVs & Vans available\n" +
                "• Well-maintained fleet\n\n" +
                "BUS & COACH HIRING:\n" +
                "• Weddings & events\n" +
                "• Corporate group travel\n" +
                "• School trips & tours\n" +
                "• 20-50 seater coaches\n\n" +
                "AIRPORT TRANSFERS:\n" +
                "• RGM International Airport\n" +
                "• Flight tracking included\n" +
                "• Meet & greet service\n\n" +
                "CORPORATE TRANSPORT:\n" +
                "• Business accounts\n" +
                "• Contract solutions\n" +
                "• Event transportation\n\n" +
                "Available 24/7 throughout the year\n" +
                "130+ Vehicles with UHF Radios"
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
                "• Regular vehicle maintenance checks\n" +
                "• UHF radio tracking system\n" +
                "• Professional business etiquette\n" +
                "• 24/7 dispatch monitoring\n" +
                "• GPS tracking on all vehicles\n" +
                "• Emergency response system"
            )
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showFaqDialog() {
        android.app.AlertDialog.Builder(requireContext())
            .setTitle("Frequently Asked Questions")
            .setMessage(
                "Q: How do I book a taxi?\n" +
                "A: Call our dispatch center or use the app.\n\n" +
                "Q: Payment options?\n" +
                "A: Cash, EcoCash, vouchers, prepaid.\n\n" +
                "Q: Do you operate 24/7?\n" +
                "A: Yes, every day of the year.\n\n" +
                "Q: How to track my taxi?\n" +
                "A: UHF radios provide real-time tracking.\n\n" +
                "Q: Can I hire a bus for events?\n" +
                "A: Yes! We have coaches for 20-50 people.\n\n" +
                "Q: Do you offer airport transfers?\n" +
                "A: Yes, with flight tracking included.\n\n" +
                "Q: What car rental options?\n" +
                "A: Sedans, SUVs, vans. Daily to monthly."
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
                "Zimbabwe's leading total transport solutions provider.\n\n" +
                "Our Services:\n" +
                "• 130+ Taxis (Contract, Pre-paid, Cash, Unmarked)\n" +
                "• Car Rental (Daily, Weekly, Monthly)\n" +
                "• Bus & Coach Hiring (20-50 seats)\n" +
                "• Airport Transfers (RGM International)\n" +
                "• Corporate Transport Solutions\n" +
                "• Event Transportation\n\n" +
                "All vehicles equipped with UHF Radios.\n" +
                "Operating 24/7 throughout the year.\n\n" +
                "Clients: Delta, Deloitte, British Council, Save the Children, BancABC, CARE, OK Zimbabwe, ZB Bank, Stanbic, Simbisa, Oxfam."
            )
            .setPositiveButton("OK", null)
            .show()
    }
}
