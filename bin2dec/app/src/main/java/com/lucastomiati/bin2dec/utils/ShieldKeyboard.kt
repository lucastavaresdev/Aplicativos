package com.lucastomiati.bin2dec.utils


import android.content.Context
import android.view.KeyEvent
import android.view.View
import android.widget.Toast


open class ShieldKeyboard(context: Context) : View.OnKeyListener {

    var context = context

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_0, KeyEvent.KEYCODE_1, KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_DEL, KeyEvent.KEYCODE_BACK -> {
                return false
            }
            else -> {
                Toast.makeText(context,"teste",Toast.LENGTH_LONG).show()
                return true
            }
        }
    }
}

