package com.example.sejongpdf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sejongpdf.models.PharmacyReceipt
import com.google.gson.Gson

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
//
//    val jsonString = """
//        {
//            "receiptNumber": "1234567890",
//            "patientName": "홍길동",
//            "formulationDate": "2021-09-01T00:00:00",
//            "medicationDays": 30,
//            "medicines": [
//                {
//                    "name": "약품1",
//                    "price": 1000,
//                    "dosage": "1회 1정",
//                    "administrationTimes": 3,
//                    "administrationDays": 30
//                },
//                {
//                    "name": "약품2",
//                    "price": 2000,
//                    "dosage": "1회 1정",
//                    "administrationTimes": 3,
//                    "administrationDays": 30
//                }
//            ],
//            "costStructure": [
//                {
//                    "name": "약값",
//                    "amount": 3000
//                },
//                {
//                    "name": "조제료",
//                    "amount": 1000
//                },
//                {
//                    "name": "기타",
//                    "amount": 1000
//                }
//            ],
//            "businessNumber": "123-45-67890",
//            "businessName": "약국명",
//            "purchaseDate": "2021-09-01T00:00:00",
//            "totalAmount": 5000
//        }
//    """.trimIndent()
//
//    private val gson = Gson()
//    val receipt: PharmacyReceipt = gson.fromJson(jsonString, PharmacyReceipt::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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