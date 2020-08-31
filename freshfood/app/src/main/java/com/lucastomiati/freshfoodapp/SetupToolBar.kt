package com.lucastomiati.freshfoodapp

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.include_toobar.*

open class BaseActivity : AppCompatActivity() {
    protected fun setupToolbar(toolbar: Toolbar, titleIdRes: Int, icon:Int, ShowBackBottom: Boolean = false){
        setSupportActionBar(toolbar)

        toolbar_title.text = getString(titleIdRes)
        toolbar_icon.setImageResource(icon)

        if (ShowBackBottom) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}