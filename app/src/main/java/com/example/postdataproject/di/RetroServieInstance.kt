package com.example.postdataproject.di

import com.example.postdataproject.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServieInstance {



    //current price data
    @GET("v1/bpi/currentprice.json")
    suspend fun getDataFromAPIso(): Response<Randoms>

    //Random User
    @GET("api/")
    suspend fun getDataFromAPIuser(): Response<random>

    //List of Universities
    @GET("search?")
    suspend fun getdatafromApis(@Query("country") query: String):Response<List<TestdataItem>>

    @GET("search?")
    suspend fun showAPI():Response<List<TestdataItem>>

    //Get US public data
    @GET("api/data?drilldowns=Nation&measures=Population")
    suspend fun getdatafromApius():Response<usdata>

    //Cocktails Database
    @GET("api/json/v1/1/search.php?")
    suspend fun getdatafromApiCocktail(@Query("s") query: String):Response<Cocktaildata>

    @GET("api/json/v1/1/search.php?s=margarita")
    suspend fun showAPIcocktails():Response<Cocktaildata>

    //congress member stock
    @GET("data/all_transactions.json")
    suspend fun showAPIcongress():Response<List<CongressdataItem>>

   // Makeup brands and product
    @GET("api/v1/products.json?")
    suspend fun getdatafromApimakeup(@Query("brand") query: String):Response<List<MekepdataItem>>

    @GET("api/v1/products.json?")
    suspend fun showAPImakeup():Response<List<MekepdataItem>>

    @GET("api/v1/products.json?")
    suspend fun showAPImakeups():Response<List<ProductColor>>


    @GET("wp-json/wp/v2/posts?per_page=100&context=embed")
    suspend fun showAPIpublic():Response<List<PublicdataItem>>

    @GET("wp-json/wp/v2/posts?per_page=100&context=embed")
    suspend fun showAPIword():Response<List<WpTerm>>




}
