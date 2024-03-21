package ru.adwantay.lab

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment1, RedFragment())
                add(R.id.fragment2, BlueFragment())
            }.commit()
        }

        findViewById<Button>(R.id.caption).setOnClickListener {
            switchFragments()
        }

    }

    private fun switchFragments() {
        val fragment1 =
            if (supportFragmentManager.findFragmentById(R.id.fragment1) is BlueFragment) RedFragment() else BlueFragment()
        val fragment2 = if (fragment1 is BlueFragment) RedFragment() else BlueFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment1, fragment1)
            replace(R.id.fragment2, fragment2)
        }.commit()
    }


}