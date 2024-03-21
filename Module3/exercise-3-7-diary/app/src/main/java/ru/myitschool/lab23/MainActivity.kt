package ru.myitschool.lab23

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import ru.myitschool.lab23.databinding.ActivityMainBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import com.google.android.material.snackbar.Snackbar as Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        binding.content.save.setOnClickListener {
            if (binding.content.eventTitleUserInput.text.isEmpty()) {
                Snackbar.make(it, "Введите название события!", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }
            AlertDialog.Builder(this).apply {
                setMessage(
                    "Записано!\n" +
                            "Событие: ${binding.content.eventTitleUserInput.text}\n" +
                            "Дата: ${SimpleDateFormat("dd.MM.yyyy").format(binding.content.calendarView.date)}\n" +
                            "Время: ${binding.content.eventTimeUserInput.text}\n" +
                            "Заметки: ${binding.content.eventNotesUserInput.text}"
                )
                 setNeutralButton("OK") { d, _ -> d.cancel() }
                 show()
            }
            clean()
        }
    }

    private fun clean() {
        binding.content.eventTitleUserInput.text.clear()
        binding.content.eventTimeUserInput.text.clear()
        binding.content.eventNotesUserInput.text.clear()
    }
}
