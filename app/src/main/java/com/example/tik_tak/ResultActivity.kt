package com.example.tik_tak

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        val resultNameTv = findViewById<TextView>(R.id.result_name_tv)
        val resultRoleTv = findViewById<TextView>(R.id.result_role_tv)
        val winnerRole = intent.getStringExtra("result").toString()
        if (winnerRole == "X"){
            resultNameTv.setText(intent.getStringExtra("firstPlayerName"))
            resultRoleTv.setText(winnerRole)

        }else if (winnerRole == "0"){
            resultNameTv.setText(intent.getStringExtra("secondPlayerName"))
            resultRoleTv.setText(winnerRole)
        }else{
            resultNameTv.setText("Sorry")
            resultRoleTv.setText(winnerRole)
        }
    }
}