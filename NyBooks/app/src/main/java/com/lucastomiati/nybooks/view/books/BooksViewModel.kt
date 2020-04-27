package com.lucastomiati.nybooks.view.books


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucastomiati.nybooks.R
import com.lucastomiati.nybooks.dados.ApiService
import com.lucastomiati.nybooks.dados.Model.Books
import com.lucastomiati.nybooks.dados.response.BooksBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {
    //variavel que recebe o resultado
    val booksLiveData: MutableLiveData<List<Books>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int,Int?>> = MutableLiveData()

    //função que recebe o retorno
    fun getBooks() {
        //booksLiveData.value = createlistaFake()
        ApiService.service.getBooks().enqueue(object : Callback<BooksBodyResponse> {
            override fun onResponse(call: Call<BooksBodyResponse>, response: Response<BooksBodyResponse>) {
                when {
                    response.isSuccessful -> {
                        val books: MutableList<Books> = mutableListOf()

                        response.body()?.let { bookBodyResponse ->
                            for (result in bookBodyResponse.BooksResponse) {
                                

                                val book1 = Books(
                                    title = result.booksDetailResponses[0].title,
                                    autor = result.booksDetailResponses[0].author,
                                    description = result.booksDetailResponses[0].description
                                )

                                books.add(book1)
                            }

                        }
                        booksLiveData.value = books
                        viewFlipperLiveData.value = Pair(VIEWFLIPPERBOOKS, null)

                    }
                    response.code() == 401 -> {
                        viewFlipperLiveData.value = Pair(VIEWFLIPPERERROS, R.string.bookerror401)
                    }
                    else -> {
                        viewFlipperLiveData.value = Pair(VIEWFLIPPERERROS,  R.string.bookerror400_generico)
                    }
                }
            }

            override fun onFailure(call: Call<BooksBodyResponse>, t: Throwable) {
                viewFlipperLiveData.value = Pair(VIEWFLIPPERERROS, R.string.bookerror500_generico)
            }

        })
    }


    companion object{
        private const val VIEWFLIPPERBOOKS = 1
        private const val VIEWFLIPPERERROS =2

    }

    //metodo com o retorno da lista
//    fun createlistaFake(): List<Books> {
//        return listOf(
//            Books("Teste", "Autor 1"),
//            Books("Teste 2", "Autor 2"),
//            Books("Teste 3", "Autor 3")
//        )
//    }
}