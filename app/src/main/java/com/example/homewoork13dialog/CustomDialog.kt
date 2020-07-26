package com.example.homewoork13dialog

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CustomDialog (context: Context): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        setCancelable(false)

        val ok =findViewById<Button>(R.id.ok)

        ok.setOnClickListener {
            dismiss()
        }
    }
}