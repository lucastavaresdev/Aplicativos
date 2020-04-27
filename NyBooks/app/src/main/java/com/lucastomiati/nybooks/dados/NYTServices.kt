package com.lucastomiati.nybooks.dados

import com.lucastomiati.nybooks.dados.response.BooksBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "oaoNO3TA9OozqEMyXO9k1TuNftXaWBtR",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BooksBodyResponse>

}