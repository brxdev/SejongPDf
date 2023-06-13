package com.example.sejongpdf

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.sejongpdf.models.PharmacyReceipt
import com.google.gson.Gson
import java.io.IOException

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return ""
        }
        return jsonString
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonFileString =
            getJsonDataFromAsset(requireContext(), "sampledata/medicineReceipt.json")

        val gson = Gson();

        val pharmacyReceipt = gson.fromJson(jsonFileString, PharmacyReceipt::class.java)


        view.findViewById<TextView>(R.id.receiptNumberTextView).text = pharmacyReceipt.receiptNumber
        view.findViewById<TextView>(R.id.patientNameTextView).text = pharmacyReceipt.patientName
        view.findViewById<TextView>(R.id.formulationDateTextView).text =
            pharmacyReceipt.formulationDate
        view.findViewById<TextView>(R.id.medicationDaysTextView).text =
            pharmacyReceipt.medicationDays.toString()
        val saveButton = view.findViewById<Button>(R.id.pdfPrintButton)
        saveButton.setOnClickListener {
            val activity = activity as MainActivity
            activity.saveViewAsPDF(view)
        }

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}