package com.example.sejongpdf.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class PharmacyReceipt(
    @SerializedName("receiptNumber") val receiptNumber: String,
    @SerializedName("patientName") val patientName: String,
    @SerializedName("formulationDate") val formulationDate: String,
    @SerializedName("medicationDays") val medicationDays: Int,
    @SerializedName("medicines") val medicines: List<Medicine>,
    @SerializedName("costStructure") val costStructure: List<CostItem>,
    @SerializedName("businessNumber") val businessNumber: String,
    @SerializedName("businessName") val businessName: String,
    @SerializedName("purchaseDate") val purchaseDate: String,
    @SerializedName("totalAmount") val totalAmount: Double
)

data class Medicine(
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Double,
    @SerializedName("dosage") val dosage: String,
    @SerializedName("administrationTimes") val administrationTimes: Int,
    @SerializedName("administrationDays") val administrationDays: Int
)

data class CostItem(
    @SerializedName("name") val name: String,
    @SerializedName("amount") val amount: Double
)
