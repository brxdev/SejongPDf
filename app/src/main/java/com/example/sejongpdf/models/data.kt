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




data class HealthInsuranceData(
    @SerializedName("outpatient") val outpatient: Boolean,
    @SerializedName("inpatient") val inpatient: Boolean,
    @SerializedName("discharged") val discharged: Boolean,
    @SerializedName("intermediate") val intermediate: Boolean,
    @SerializedName("patientRegistrationNumber") val patientRegistrationNumber: String,
    @SerializedName("patientName") val patientName: String,
    @SerializedName("treatmentPeriod") val treatmentPeriod: TreatmentPeriod,
    @SerializedName("medicalSubject") val medicalSubject: String,
    @SerializedName("diagnosisRelatedGroupNumber") val diagnosisRelatedGroupNumber: String,
    @SerializedName("roomPatientType") val roomPatientType: String,
    @SerializedName("receiptNumber") val receiptNumber: String,
    @SerializedName("items") val items: Items,
    @SerializedName("healthcareFacilityType") val healthcareFacilityType: String,
    @SerializedName("clinicOrHealthCenter") val clinicOrHealthCenter: Boolean,
    @SerializedName("hospital") val hospital: Boolean,
    @SerializedName("generalHospital") val generalHospital: Boolean,
    @SerializedName("superGeneralHospital") val superGeneralHospital: Boolean,
    @SerializedName("businessRegistrationNumber") val businessRegistrationNumber: String,
    @SerializedName("company") val company: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("businessLocation") val businessLocation: String,
    @SerializedName("representative") val representative: String
)

data class TreatmentPeriod(
    @SerializedName("startDate") val startDate: String,
    @SerializedName("endDate") val endDate: String,
    @SerializedName("nightTreatment") val nightTreatment: Boolean,
    @SerializedName("holidayTreatment") val holidayTreatment: Boolean
)

data class Items(
    @SerializedName("examinationFee") val examinationFee: Fee,
    @SerializedName("hospitalizationFee") val hospitalizationFee: Fee,
    @SerializedName("mealExpenses") val mealExpenses: Fee,
    @SerializedName("medicationAndDispensingFee") val medicationAndDispensingFee: Fee,
    @SerializedName("procedureFee") val procedureFee: Fee,
    @SerializedName("medicationCost") val medicationCost: Fee,
    @SerializedName("injectionFee") val injectionFee: Fee,
    @SerializedName("treatmentSupplyCost") val treatmentSupplyCost: Fee,
    @SerializedName("rehabilitationAndPhysicalTherapyFee") val rehabilitationAndPhysicalTherapyFee: Fee,
    @SerializedName("psychiatricTherapyFee") val psychiatricTherapyFee: Fee,
    @SerializedName("bloodAndBloodProductFee") val bloodAndBloodProductFee: Fee,
    @SerializedName("treatmentAndSurgicalFee") val treatmentAndSurgicalFee: Fee,
    @SerializedName("testFee") val testFee: Fee,
    @SerializedName("imagingDiagnosisFee") val imagingDiagnosisFee: Fee,
    @SerializedName("radiationTherapyFee") val radiationTherapyFee: Fee,
    @SerializedName("dentureAndOrthodonticFee") val dentureAndOrthodonticFee: Fee,
    @SerializedName("ctScanFee") val ctScanFee: Fee,
    @SerializedName("mriScanFee") val mriScanFee: Fee,
    @SerializedName("petScanFee") val petScanFee: Fee,
    @SerializedName("ultrasoundScanFee") val ultrasoundScanFee: Fee
)

data class Fee(
    @SerializedName("covered") val covered: Int,
    @SerializedName("notCovered") val notCovered: Int,
    @SerializedName("calculationDetails") val calculationDetails: String,
    @SerializedName("partialSelfPayment") val partialSelfPayment: Int,
    @SerializedName("fullSelfPayment") val fullSelfPayment: Int
)
