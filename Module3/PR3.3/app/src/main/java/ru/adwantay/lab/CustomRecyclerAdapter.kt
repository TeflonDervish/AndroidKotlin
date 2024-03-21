package ru.adwantay.lab

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerAdapter(private val colors: Map<String, Int>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
    private val names = colors.keys.toList()
    private val values = colors.values.toList()
    private var positions = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        Log.d("myyyy", position.toString())
        holder.apply {
            textView.text = names[position]
            itemView.apply {
                if (position in positions)
                    setBackgroundColor(values[position])
                else
                    setBackgroundColor(Color.TRANSPARENT)
                setOnClickListener {
                    if (position in positions) {
                        holder.itemView.setBackgroundColor(Color.TRANSPARENT)
                        positions.remove(position)
                    } else
                        positions.add(position)
                    notifyItemChanged(position)
                }
            }
        }
    }

    override fun getItemCount() = colors.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(android.R.id.text1)
    }

}