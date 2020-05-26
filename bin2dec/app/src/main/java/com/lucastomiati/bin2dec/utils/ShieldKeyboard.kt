package com.lucastomiati.bin2dec.Utils

import android.view.KeyEvent
import android.view.View

interface teste : View.OnKeyListener {

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_0, KeyEvent.KEYCODE_1, KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_DEL, KeyEvent.KEYCODE_BACK -> {
                return false
            }
            else -> {
                //Toast.makeText(this, "Por Gentileza Digitar 0 ou 1", Toast.LENGTH_LONG).show()
                return true
            }
        }
    }
}