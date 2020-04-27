package com.lucastomiati.nybooks.view.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.lucastomiati.nybooks.R
import com.lucastomiati.nybooks.dados.Model.Books
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdpter(
    private val books: List<Books>,
    val onItemClickListener: ((Books: Books) -> Unit)
) : RecyclerView.Adapter<BooksAdpter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(view, onItemClickListener)
    }

    override fun getItemCount() = books.count()

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(books[position])
    }

    class BooksViewHolder(
        itemView: View,
        private val onItemClickListener: ((Books: Books) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        //acesso aos componentes
        private val title = itemView.textTitle
        private val autor = itemView.textAutor

        fun bindView(book: Books) {
            title.text = book.title
            autor.text = book.autor

            itemView.setOnClickListener {
                onItemClickListener.invoke(book)
            }

        }
    }
}