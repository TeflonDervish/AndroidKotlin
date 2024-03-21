package ru.myitschool.lab23

import android.app.AlertDialog
 import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.myitschool.lab23.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FinancialOperationAdapter



    private val financialOperationService: FinancialOperationService
        get() = (applicationContext as App).financialOperationService
    private var selectedItemPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addFab.setOnClickListener { showAddOperationDialog() }
        val manager = LinearLayoutManager(this) // LayoutManager
        adapter = FinancialOperationAdapter() // Создание объекта
        adapter.data = financialOperationService.operations // Заполнение данными
        adapter.longClickListener = { pos ->
            registerForContextMenu(binding.content.efExpensesRv)
            openContextMenu(binding.content.efExpensesRv)
            unregisterForContextMenu(binding.content.efExpensesRv)
            selectedItemPosition = pos
        }
        binding.content.efExpensesRv.layoutManager = manager
        binding.content.efExpensesRv.adapter = adapter

    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu!!.add(Menu.NONE, 101, Menu.NONE, "Delete");
        menu!!.add(Menu.NONE, 102, Menu.NONE, "Duplicate");
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            101 -> {
                deleteOperation(financialOperationService.operations[selectedItemPosition])
                true
            }

            102 -> {
                addOperation(financialOperationService.operations[selectedItemPosition])
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    private fun showAddOperationDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.my_alert_dialog, null)
        val typeSpinner = dialogView.findViewById<Spinner>(R.id.type_spinner)
        val amountEditText = dialogView.findViewById<EditText>(R.id.expense_amount_edit_text)
        val addButton = dialogView.findViewById<Button>(R.id.add_button)
        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, arrayOf(INCOME, EXPENSES)
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            typeSpinner.adapter = adapter
        }
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Add Operation")
            .setNegativeButton("Галя Отмена", null)
            .create()

        dialog.show()

        addButton.setOnClickListener {
            val selectedType = typeSpinner.selectedItem.toString()
            val amountText = amountEditText.text.toString().toString()
            if (amountText.isNotEmpty()) {
                val operation = FinancialOperation(
                    selectedType,
                    amount = amountText.toFloat()
                )
                addOperation(operation)
                dialog.dismiss()
            } else {
                amountEditText.error = "Введите корректную сумму"
            }

        }
    }


    private fun deleteOperation(operation: FinancialOperation) {
        with(financialOperationService) {
            when (operation.type) {
                INCOME -> updateBalance(-operation.amount)
                EXPENSES -> updateBalance(operation.amount)
            }
            operations.removeAt(selectedItemPosition)
            adapter.notifyDataSetChanged()

        }
    }

    private fun addOperation(operation: FinancialOperation) {
        financialOperationService.operations.add(operation)
        when (operation.type) {
            INCOME-> updateBalance(operation.amount)
            EXPENSES -> updateBalance(-operation.amount)
        }
        adapter.notifyDataSetChanged()
    }

    private fun updateBalance(amount: Float) {
        financialOperationService.balance += amount
        binding.content.apply {
            efCurrentBalanceText.text =
                financialOperationService.balance.toString()
            efExpensesRv.invalidate()
        }
    }

    companion object{
       const val INCOME = "Income"
       const val EXPENSES = "Expenses"
    }
}
