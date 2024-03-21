package ru.myitschool.lab23

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.content.getRandomNums.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            i.apply {
                putExtra("size", binding.content.sizeParam.text.toString().toInt())
                putExtra("shape", binding.content.shapeParam.text.toString().toInt())
                putExtra("rate", binding.content.rateParam.text.toString().toDouble())
            }
            startActivity(i)
        }
    }
}