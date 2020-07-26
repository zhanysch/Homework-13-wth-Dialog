package com.example.homewoork13dialog

import android.app.DatePickerDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var save: Button?=null
    private var first: EditText?=null
    private var last: EditText?=null
    private var birdth:EditText?=null
    private var save2:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        View()
        Listener()
        datePickerDialog()
        AlertDialog()

    }




    private fun View() {
        first=findViewById(R.id.first)
        last=findViewById(R.id.last)
        save = findViewById(R.id.save)
        save2=findViewById(R.id.save2)
        birdth=findViewById(R.id.birdth)
    }



    private fun Listener() {
        save2?.setOnClickListener {
            datePickerDialog()
        }

        save?.setOnClickListener {
            AlertDialog()
        }
    }


    private fun datePickerDialog() {
       val dialog= DatePickerDialog(this)
        dialog.setOnDateSetListener{view , year, month, dayofMonth ->
            birdth?.setText(getString(R.string.date1,dayofMonth,month,year))

        }
        dialog.show()

    }

    private fun AlertDialog(){

        val dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.myDialog) )
        val preference = getSharedPreferences("Preference", Context.MODE_PRIVATE)

        dialog.setTitle("Cохранить данные?")
        dialog.setPositiveButton("да") { dialog, which ->     //(тут)

            val text=first?.text.toString()
            preference.edit().putString("text",text).apply()

            val text2 = last?.text.toString()
            preference.edit().putString("text2",text).apply()

            CustomDialog(this).show() //(заметка для себя. <- для точго чтобы дополнит окно высплывало при нажатии на кнопку да)
        }


        dialog.setNegativeButton("нет", object: DialogInterface.OnClickListener{ //(заметка для себя. (тут), одно и тоже positiveButton немного сокращен)
            override fun onClick(p0: DialogInterface?, p1: Int) {

            }

        })
       dialog.show()

    }
}
