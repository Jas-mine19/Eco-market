package com.example.eco_market

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("product-category-list/")
    suspend fun getCategory(): Call<MutableList<CategoryData>>

}