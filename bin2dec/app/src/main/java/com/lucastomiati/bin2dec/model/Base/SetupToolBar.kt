package com.lucastomiati.bin2dec.model.Base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


open class SetupToolBar: AppCompatActivity() {
    protected fun setupToolBar(toolbar: Toolbar, titleIdRes: Int, ShowBackBottom:Boolean = false){
        toolbar.title = getString(titleIdRes)
        toolbar.setTitle(null)
        setSupportActionBar(toolbar)
        if (ShowBackBottom){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}

