package ru.myitschool.lab23

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.myitschool.lab23.databinding.ActivityMainBinding
import ru.myitschool.lab23.databinding.ActivitySecondBinding
import kotlin.math.ln

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val size = intent.getIntExtra("size", 0) //n
        val shape = intent.getIntExtra("shape", 0) //k
        val rate = intent.getDoubleExtra("rate", 0.0) //k
        var array = mutableListOf<Double>()
        for (i in 0 until size) {
            var sum = 0.0
            for (s in 0 until shape)
                sum += ln((1..9999).random() / 10000.0)
            array.add(-sum / rate)
        }

        binding.generatedList.layoutManager = LinearLayoutManager(this)
        binding.generatedList.adapter = RecyclerAdapter(array)
    }

}