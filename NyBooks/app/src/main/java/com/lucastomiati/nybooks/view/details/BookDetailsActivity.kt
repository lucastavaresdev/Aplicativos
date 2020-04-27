package com.lucastomiati.nybooks.view.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucastomiati.nybooks.R
import com.lucastomiati.nybooks.base.BaseActivity
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.include_toobar.*

class BookDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)

        setupToolbar(tollBarMain, R.string.book_details_title, true)


        bookTitle.setText(title)
        bookDescription.setText(description)

    }

    companion object{
        private  const val EXTRA_TITLE = "EXTRA TITLE"
        private  const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        //context a tela de onde eu estou vindo
        fun getStartIntent(context: Context, title: String, description: String): Intent{
            //a tela que ta vindo, para q a tela que vai
            return  Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}
