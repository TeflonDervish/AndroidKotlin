package ru.myitschool.lab23

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.myitschool.lab23.databinding.SingleItemBinding

class RecyclerAdapter(private val numbers: MutableList<Double>) : RecyclerView.Adapter<RecyclerAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
         holder.binding.randomNumberResult.text = numbers[position].toString()
    }
    override fun getItemCount() = numbers.size

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
//        val textView: TextView = item.findViewById(R.id.random_number_result)
        val binding = SingleItemBinding.bind(item)
    }
}