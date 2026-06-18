package com.mintaxis.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mintaxis.app.R

class WalletFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cashRadio = view.findViewById<RadioButton>(R.id.cashRadio)
        val ecocashRadio = view.findViewById<RadioButton>(R.id.ecocashRadio)
        val voucherRadio = view.findViewById<RadioButton>(R.id.voucherRadio)
        val corporateRadio = view.findViewById<RadioButton>(R.id.corporateRadio)

        val cashOption = view.findViewById<LinearLayout>(R.id.cashOption)
        val ecocashOption = view.findViewById<LinearLayout>(R.id.ecocashOption)
        val voucherOption = view.findViewById<LinearLayout>(R.id.voucherOption)
        val corporateOption = view.findViewById<LinearLayout>(R.id.corporateOption)

        fun clearAll() {
            cashRadio?.isChecked = false
            ecocashRadio?.isChecked = false
            voucherRadio?.isChecked = false
            corporateRadio?.isChecked = false
        }

        cashOption?.setOnClickListener { clearAll(); cashRadio?.isChecked = true }
        ecocashOption?.setOnClickListener { clearAll(); ecocashRadio?.isChecked = true }
        voucherOption?.setOnClickListener { clearAll(); voucherRadio?.isChecked = true }
        corporateOption?.setOnClickListener { clearAll(); corporateRadio?.isChecked = true }

        view.findViewById<View>(R.id.topUpButton)?.setOnClickListener {
            Toast.makeText(requireContext(), "Top up coming soon", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<View>(R.id.withdrawButton)?.setOnClickListener {
            Toast.makeText(requireContext(), "Withdraw coming soon", Toast.LENGTH_SHORT).show()
        }
    }
}
