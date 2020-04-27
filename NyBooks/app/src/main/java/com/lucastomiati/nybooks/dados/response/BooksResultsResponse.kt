package com.lucastomiati.nybooks.dados.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookResultsResponse (
    @Json(name ="book_details")
    val booksDetailResponses: List<BookDetailsResponse>
)