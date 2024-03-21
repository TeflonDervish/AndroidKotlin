package ru.adwantay.lab


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.adwantay.lab.databinding.ItemWithImgBinding

class MyViewAdapter(private val colors: Map<String, Int>) :
    RecyclerView.Adapter<MyViewAdapter.MyHolder>() {
    var onItemClick : ((Int)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_with_img, parent, false)
        return MyHolder(itemView)
    }

    override fun getItemCount() = colors.size


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.binding.textView.text = colors.keys.elementAt(position)
        holder.binding.linearLayout.setBackgroundColor(colors.values.elementAt(position))
        holder.binding.card.setOnClickListener {
            onItemClick?.invoke(position)
        }
    }


    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemWithImgBinding.bind(item)
    }


}