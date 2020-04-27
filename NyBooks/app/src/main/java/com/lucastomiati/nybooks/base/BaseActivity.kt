package com.lucastomiati.nybooks.base


import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity : AppCompatActivity() {
    protected fun setupToolbar(toolbar: Toolbar, titleIdRes: Int, ShowBackBottom: Boolean = false){
        toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbar)
        if (ShowBackBottom) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}