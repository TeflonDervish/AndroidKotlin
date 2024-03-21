package ru.adwantay.lab

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
class CustomListAdapter(
    context: Context,
    private val colorsMap:  Map<String, Int>
) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, colorsMap.keys.toList()) {

    private var selectedPosition = -1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        if (position == selectedPosition) {
            view.setBackgroundColor(colorsMap.values.toList()[position])
        } else {
            view.setBackgroundColor(Color.TRANSPARENT)
        }
        return view
    }

    fun setSelectedPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }
}
