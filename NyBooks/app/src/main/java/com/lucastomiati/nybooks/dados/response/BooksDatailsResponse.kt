package com.lucastomiati.nybooks.dados.response

import com.lucastomiati.nybooks.dados.Model.Books
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BookDetailsResponse (
    @Json(name = "title")
    val title: String,
    @Json(name = "author")
    val author: String,
    @Json(name = "description")
    val description: String
){
    fun getBookModel() = Books(
        this.description,
        this.author,
        this.description
    )
}