package com.example.postdataproject.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Univarmodel(

    val resultunis: List<TestdataItem?>?
)

data class TestdataItem(
    @SerializedName("alpha_two_code")
    val alphaTwoCode: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("domains")
    val domains: List<String?>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("state-province")
    val stateProvince: String?,
    @SerializedName("web_pages")
    val webPages: List<String?>?
)