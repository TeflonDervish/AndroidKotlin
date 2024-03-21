package ru.adwantay.lab

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val colors = getColorNamesAndValues()
        val adapter = CustomListAdapter(this, colors)
        findViewById<ListView>(R.id.listView).let {
            it.adapter = adapter
            it.setOnItemClickListener { _, _, position, _ ->
                adapter.setSelectedPosition(position)
            }
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomRecyclerAdapter(colors)
    }


    private fun getColorNamesAndValues(): Map<String, Int> =
        resources.getStringArray(R.array.colorNames)
            .zip(resources.getIntArray(R.array.colorValues).toList()).toMap()
}
