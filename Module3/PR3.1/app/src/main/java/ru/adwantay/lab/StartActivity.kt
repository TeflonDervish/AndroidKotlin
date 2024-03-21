package ru.adwantay.lab

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


open class StartActivity : AppCompatActivity() {
    private val arl = registerForActivityResult(
        MyContract()
    ) { result -> btn1.text = result }


    lateinit var edt: EditText
    lateinit var btn1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        edt = findViewById(R.id.editText2)
        btn1 = findViewById(R.id.button1)
    }

    fun btnOnClick(v: View) {
        when (v.id) {
            R.id.button1 ->
                if (edt.text.isNotEmpty()) {
                    arl.launch(edt.text.toString())
                }

            R.id.button2 -> {
                val intent = Intent(this, TwoActivity::class.java)
                startActivity(intent)
            }
        }
    }


}
