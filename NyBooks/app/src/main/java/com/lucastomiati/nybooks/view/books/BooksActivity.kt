package com.lucastomiati.nybooks.view.books

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucastomiati.nybooks.R
import com.lucastomiati.nybooks.base.BaseActivity
import com.lucastomiati.nybooks.view.details.BookDetailsActivity
import kotlinx.android.synthetic.main.books_activity.*
import kotlinx.android.synthetic.main.include_toobar.*

class BooksActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.books_activity)


     setupToolbar(tollBarMain, R.string.booksTitle)


        //Tudo que tiver no view Model eu tenho acesso - Ligação
        val viewModel = ViewModelProvider(this).get(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this, Observer {
            //so entra se nao for  nulo, o books significa que estou substituindo o it
            it?.let { books ->
                with(recyclerBooks) {
                   layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                   setHasFixedSize(true)
                   adapter = BooksAdpter(books){book ->
                       val intent  = BookDetailsActivity.getStartIntent(this@BooksActivity, book.title, book.description)
                       this@BooksActivity.startActivity(intent)
                   }
                }
            }
        })

        viewModel.getBooks()
        viewModel.viewFlipperLiveData.observe(this, Observer{
            it?.let { viewFippler ->
                booksviewFlipper.displayedChild = viewFippler.first
                viewFippler.second?.let{errorMessageId ->
                    textrror.text = getString(errorMessageId)

                }
            }

        })

    }


}
