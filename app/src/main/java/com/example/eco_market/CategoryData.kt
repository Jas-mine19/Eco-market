package com.example.eco_market

import com.google.gson.annotations.SerializedName

data class CategoryData(
    @SerializedName("id")
    val categoryId: Int,
    @SerializedName("name")
    val categoryName: String,
    @SerializedName("image")
    val imageUrl: String
)
