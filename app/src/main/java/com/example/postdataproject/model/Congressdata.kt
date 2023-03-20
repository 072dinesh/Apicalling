package com.example.postdataproject.model


import com.google.gson.annotations.SerializedName



data class Congressdata(

    val resultunis: List<CongressdataItem?>?
)



data class CongressdataItem(
    @SerializedName("amount")
    val amount: String?,
    @SerializedName("asset_description")
    val assetDescription: String?,
    @SerializedName("cap_gains_over_200_usd")
    val capGainsOver200Usd: Boolean?,
    @SerializedName("disclosure_date")
    val disclosureDate: String?,
    @SerializedName("disclosure_year")
    val disclosureYear: Int?,
    @SerializedName("district")
    val district: String?,
    @SerializedName("industry")
    val industry: String?,
    @SerializedName("owner")
    val owner: String?,
    @SerializedName("party")
    val party: String?,
    @SerializedName("ptr_link")
    val ptrLink: String?,
    @SerializedName("representative")
    val representative: String?,
    @SerializedName("sector")
    val sector: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("ticker")
    val ticker: String?,
    @SerializedName("transaction_date")
    val transactionDate: String?,
    @SerializedName("type")
    val type: String?
)