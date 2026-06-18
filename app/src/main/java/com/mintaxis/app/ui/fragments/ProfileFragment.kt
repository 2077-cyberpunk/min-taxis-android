package com.mintaxis.app.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mintaxis.app.R
import com.mintaxis.app.ui.activities.GalleryActivity
import com.mintaxis.app.ui.activities.HelpSupportActivity
import com.mintaxis.app.ui.activities.LoginActivity
import com.mintaxis.app.ui.activities.PromotionsActivity
import com.mintaxis.app.ui.activities.ReviewsActivity
import com.mintaxis.app.ui.activities.SettingsActivity

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

        safeClick(view, R.id.myRidesItem) {
            Toast.makeText(requireContext(), "Ride history coming soon", Toast.LENGTH_SHORT).show()
        }

        safeClick(view, R.id.contactUsItem) { showContactDialog() }

        safeClick(view, R.id.servicesItem) { showServicesDialog() }

        safeClick(view, R.id.safetyItem) { showSafetyDialog() }

        safeClick(view, R.id.faqsItem) { showFaqDialog() }

        safeClick(view, R.id.galleryItem) {
            try { startActivity(Intent(requireContext(), GalleryActivity::class.java)) }
            catch (e: Exception) { Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show() }
        }

        safeClick(view, R.id.reviewsItem) {
            try { startActivity(Intent(requireContext(), ReviewsActivity::class.java)) }
            catch (e: Exception) { Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show() }
        }

        safeClick(view, R.id.promotionsItem) {
            try { startActivity(Intent(requireContext(), PromotionsActivity::class.java)) }
            catch (e: Exception) { Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show() }
        }

        safeClick(view, R.id.helpSupportItem) {
            try { startActivity(Intent(requireContext(), HelpSupportActivity::class.java)) }
            catch (e: Exception) { Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show() }
        }

        safeClick(view, R.id.settingsItem) {
            try { startActivity(Intent(requireContext(), SettingsActivity::class.java)) }
            catch (e: Exception) { Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show() }
        }

        safeClick(view, R.id.aboutItem) { showAboutDialog() }

        safeClick(view, R.id.shareAppItem) { shareApp() }

        safeClick(view, R.id.logoutButton) {
            try {
                val intent = Intent(requireContext(), LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                requireActivity().finish()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun safeClick(view: View, id: Int, action: () -> Unit) {
        try { view.findViewById<View>(id)?.setOnClickListener { action() } } catch (_: Exception) {}
    }

    private fun shareApp() {
        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIN Taxis")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out MIN Taxis - Zimbabwe's best transport service!\n\nBook taxis, rent cars, hire buses & more.\n\nDownload: https://play.google.com/store/apps/details?id=com.mintaxis.app\n\nCall: +263 772 887 897")
            startActivity(Intent.createChooser(shareIntent, "Share MIN Taxis"))
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Error sharing", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showContactDialog() {
        try {
            android.app.AlertDialog.Builder(requireContext())
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
                    try {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:+263772887897")
                        startActivity(intent)
                    } catch (_: Exception) {}
                }
                .setNegativeButton("Close", null)
                .create()
                .show()
        } catch (_: Exception) {}
    }

    private fun showServicesDialog() {
        try {
            android.app.AlertDialog.Builder(requireContext())
                .setTitle("Our Services")
                .setMessage(
                    "MIN Taxis - Total Transport Solutions:\n\n" +
                    "TAXI SERVICES:\n" +
                    "• Contract Taxis - Daily commute\n" +
                    "• Pre-paid Taxis - Pay in advance\n" +
                    "• Cash Taxis - Pay per ride\n" +
                    "• Unmarked Taxis - Discreet travel\n\n" +
                    "CAR RENTAL:\n" +
                    "• Daily, Weekly & Monthly rentals\n" +
                    "• Sedans, SUVs & Vans\n\n" +
                    "BUS & COACH HIRING:\n" +
                    "• Weddings & events\n" +
                    "• Corporate group travel\n" +
                    "• 20-50 seater coaches\n\n" +
                    "AIRPORT TRANSFERS:\n" +
                    "• RGM International Airport\n" +
                    "• Flight tracking included\n\n" +
                    "CORPORATE TRANSPORT:\n" +
                    "• Business accounts\n" +
                    "• Event transportation\n\n" +
                    "Available 24/7 | 130+ Vehicles"
                )
                .setPositiveButton("OK", null)
                .show()
        } catch (_: Exception) {}
    }

    private fun showSafetyDialog() {
        try {
            android.app.AlertDialog.Builder(requireContext())
                .setTitle("Safety & Security")
                .setMessage(
                    "Your safety is our priority:\n\n" +
                    "• Traffic Safety Council certified\n" +
                    "• Regular vehicle maintenance\n" +
                    "• UHF radio tracking system\n" +
                    "• Professional business etiquette\n" +
                    "• 24/7 dispatch monitoring\n" +
                    "• GPS tracking on all vehicles\n" +
                    "• Emergency response system"
                )
                .setPositiveButton("OK", null)
                .show()
        } catch (_: Exception) {}
    }

    private fun showFaqDialog() {
        try {
            android.app.AlertDialog.Builder(requireContext())
                .setTitle("FAQs")
                .setMessage(
                    "Q: How do I book?\nA: Call dispatch or use the app.\n\n" +
                    "Q: Payment options?\nA: Cash, EcoCash, vouchers, prepaid.\n\n" +
                    "Q: 24/7 service?\nA: Yes, every day.\n\n" +
                    "Q: Track my taxi?\nA: UHF radios for real-time tracking.\n\n" +
                    "Q: Hire a bus?\nA: Yes! 20-50 seat coaches.\n\n" +
                    "Q: Airport transfers?\nA: Yes, with flight tracking.\n\n" +
                    "Q: Car rental?\nA: Sedans, SUVs, vans. Daily-monthly."
                )
                .setPositiveButton("OK", null)
                .show()
        } catch (_: Exception) {}
    }

    private fun showAboutDialog() {
        try {
            android.app.AlertDialog.Builder(requireContext())
                .setTitle("About MIN Taxis")
                .setMessage(
                    "MIN Taxis (Private) Limited\nEst. 2004\n\n" +
                    "Zimbabwe's leading total transport solutions provider.\n\n" +
                    "• 130+ Taxis\n• Car Rental\n• Bus & Coach Hiring\n" +
                    "• Airport Transfers\n• Corporate Transport\n\n" +
                    "24/7 | UHF Radios | All vehicles roadworthy\n\n" +
                    "Clients: Delta, Deloitte, British Council, Save the Children, BancABC, CARE, OK Zimbabwe, ZB Bank, Stanbic, Simbisa, Oxfam."
                )
                .setPositiveButton("OK", null)
                .show()
        } catch (_: Exception) {}
    }
}
