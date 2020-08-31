package com.lucastomiati.freshfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.include_toobar.*

class Search : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setupToolbar(tollBarMain, R.string.app_seach, R.drawable.icon_close )

        toolbar_icon.setOnClickListener{
            finish()
            overridePendingTransition(R.transition.no_animation, R.transition.slide_out_up)
        }


    }
}
