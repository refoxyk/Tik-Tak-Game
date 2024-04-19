package com.example.tik_tak

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)




        val buttonSingle = findViewById<Button>(R.id.button_single)
        val buttonMulti = findViewById<Button>(R.id.button_multi)

        buttonSingle.setOnClickListener {
            navigateToSecondActivity(true)
        }
        buttonMulti.setOnClickListener {
            navigateToSecondActivity(false)
        }

    }
    private fun navigateToSecondActivity(SingleGame:Boolean ) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("SinglePlayer",SingleGame)
        startActivity(intent)
    }
}