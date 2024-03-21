package ru.adwantay.lab

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val textView = TextView(context).apply {
            text = "Красный фрагмент"
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.RED)
            gravity = Gravity.CENTER
        }
        return textView
    }
}