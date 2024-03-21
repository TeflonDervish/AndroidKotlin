package ru.samsung.itschool.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class BlankFragment6 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_blank6, container, false)
        view.findViewById<Button>(R.id.button4_back).setOnClickListener { v ->
            v.findNavController().popBackStack()
        }

        return view
    }
}