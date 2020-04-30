package com.lucastomiati.bin2dec.view

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lucastomiati.bin2dec.model.Base.LogicHome
import com.lucastomiati.bin2dec.model.Base.SetupToolBar
import com.lucastomiati.bin2dec.R
import kotlinx.android.synthetic.main.home.*

class Home : SetupToolBar(), View.OnKeyListener, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        edithome.setOnKeyListener(this)
        btnCalcular.setOnClickListener(this)

        val viewModel = ViewModelProvider(this).get(homeViewModel::class.java)


    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnCalcular) {
            val resumoDois = LogicHome()
            resultado.setText(resumoDois.toDecimal(edithome.getText().toString()))
        }
    }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_0, KeyEvent.KEYCODE_1, KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_DEL -> {
                return false
            }
            else -> {
                Toast.makeText(this, "Por Gentileza Digitar 0 ou 1", Toast.LENGTH_LONG).show()
                return true
            }
        }

    }
}
