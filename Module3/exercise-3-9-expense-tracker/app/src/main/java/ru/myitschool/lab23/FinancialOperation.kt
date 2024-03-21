package ru.myitschool.lab23

import java.text.SimpleDateFormat
import java.util.Date

data class FinancialOperation(
    val type: String,
    val date: String = SimpleDateFormat("dd.MM.yyyy").format(Date()),
    val amount: Float
)