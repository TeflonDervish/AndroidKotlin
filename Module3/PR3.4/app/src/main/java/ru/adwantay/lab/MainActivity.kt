package ru.adwantay.lab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.adwantay.lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val colorsName = resources.getStringArray(R.array.colorNames).toList()
        val colorsValue = resources.getIntArray(R.array.colorValues).toList()

        val myViewAdapter = MyViewAdapter(colorsName.zip(colorsValue).toMap())
        myViewAdapter.onItemClick = {
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra("position", it)
            startActivity(i)
        }
        binding.recyclerView.adapter = myViewAdapter
    }
}
