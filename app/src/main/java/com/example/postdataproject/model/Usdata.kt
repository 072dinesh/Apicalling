package com.example.postdataproject.model


import com.google.gson.annotations.SerializedName

data class usdata(
    @SerializedName("data")
    val data: List<Data?>?,
    @SerializedName("source")
    val source: List<Source?>?
)

data class Data(
    @SerializedName("ID Nation")
    val iDNation: String?,
    @SerializedName("ID Year")
    val iDYear: Int?,
    @SerializedName("Nation")
    val nation: String?,
    @SerializedName("Population")
    val population: Int?,
    @SerializedName("Slug Nation")
    val slugNation: String?,
    @SerializedName("Year")
    val year: String?
)

data class Source(
    @SerializedName("annotations")
    val annotations: Annotations?,
    @SerializedName("measures")
    val measures: List<String?>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("substitutions")
    val substitutions: List<Any?>?
)

data class Annotations(
    @SerializedName("dataset_link")
    val datasetLink: String?,
    @SerializedName("dataset_name")
    val datasetName: String?,
    @SerializedName("source_description")
    val sourceDescription: String?,
    @SerializedName("source_name")
    val sourceName: String?,
    @SerializedName("subtopic")
    val subtopic: String?,
    @SerializedName("table_id")
    val tableId: String?,
    @SerializedName("topic")
    val topic: String?
)