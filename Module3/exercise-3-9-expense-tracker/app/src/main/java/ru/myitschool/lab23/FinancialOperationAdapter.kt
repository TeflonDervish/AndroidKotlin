package ru.myitschool.lab23

import android.media.VolumeShaper.Operation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.myitschool.lab23.databinding.ItemFinanciialOperationBinding

class FinancialOperationAdapter :
    RecyclerView.Adapter<FinancialOperationAdapter.FinancialOperationViewHolder>() {
    var longClickListener: ((Int) -> Unit)? = null


    var data: List<FinancialOperation> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FinancialOperationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFinanciialOperationBinding.inflate(inflater, parent, false)

        return FinancialOperationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FinancialOperationViewHolder, position: Int) {
        val operation = data[position]
        with(holder.binding) {
            val color = if (operation.type == MainActivity.INCOME) R.color.green else R.color.red

            expenseTypeText.apply {
                text = operation.type
                setTextColor(resources.getColor(color))
            }
            expenseDateText.text = operation.date
            expenseAmountText.text = operation.amount.toString()
            operationItem.setOnLongClickListener {
                longClickListener?.invoke(position)
                true
            }
        }

    }


    override fun getItemCount() = data.size

    class FinancialOperationViewHolder(val binding: ItemFinanciialOperationBinding) :
        RecyclerView.ViewHolder(binding.root)
}