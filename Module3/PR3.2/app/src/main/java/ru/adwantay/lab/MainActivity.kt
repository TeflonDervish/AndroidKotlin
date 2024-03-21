package ru.adwantay.lab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var eAddress: EditText
    private lateinit var eTheme: EditText
    private lateinit var eLetter: EditText
    private lateinit var btnSend: Button
    private lateinit var btnCall: Button
    private lateinit var ePhNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSend = findViewById(R.id.bsend)
        btnCall = findViewById(R.id.bcall)
        eAddress = findViewById(R.id.eadress)
        eTheme = findViewById(R.id.etitle)
        eLetter = findViewById(R.id.etext)
        ePhNumber = findViewById(R.id.etelno)


        btnSend.setOnClickListener {
            if (eAddress.text.isNotEmpty() && eTheme.text.isNotEmpty() && eLetter.text.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.apply {
                    type = "text/plain";
                    putExtra(Intent.EXTRA_EMAIL, eAddress.text.toString())
                    putExtra(Intent.EXTRA_SUBJECT, eTheme.text.toString())
                    putExtra(Intent.EXTRA_TEXT, eLetter.text.toString())
                }
                startActivity(intent)
            }
        }

        btnCall.setOnClickListener{
            if(ePhNumber.text.isNotEmpty()){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:${ePhNumber.text}"))
                startActivity(intent)
            }
        }


    }



}
