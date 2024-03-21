package ru.adwantay.lab

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class MyContract : ActivityResultContract<String, String>() {
    override fun createIntent(context: Context, input: String): Intent {
        val intent = Intent(context, OneActivity::class.java)
        intent.putExtra("text", input)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        if (resultCode == AppCompatActivity.RESULT_OK)
            return intent?.getStringExtra("text")?:""
        return ""
    }


}