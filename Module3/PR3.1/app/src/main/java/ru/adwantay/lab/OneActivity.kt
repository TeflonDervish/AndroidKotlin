package ru.adwantay.lab

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        val btn = findViewById<Button>(R.id.button3)
        val edt = findViewById<EditText>(R.id.editText2)
        val txt = findViewById<TextView>(R.id.textView)
        txt.text = intent.getStringExtra("text")

        btn.setOnClickListener {
            if (edt.text.isNotEmpty()) {
                val intent = Intent()
                intent.putExtra("text", edt.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

}