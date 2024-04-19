package com.example.tik_tak

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        val editTextFirstPlayer = findViewById<EditText>(R.id.first_player_edit_text)
        val editTextSecondPlayer = findViewById<EditText>(R.id.second_player_edit_text)
        val buttonStart = findViewById<Button>(R.id.button_start)
        val switchRole=findViewById<Switch>(R.id.switch1)

        var secondPlayerName = ""

        var roleChanged = false

        switchRole.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked){
                roleChanged = true
            }else{
                roleChanged = false
            }
        }






        val singleGame = intent.getBooleanExtra("SinglePlayer",false)

        if(singleGame) {
            editTextSecondPlayer.visibility = View.INVISIBLE
            switchRole.visibility = View.VISIBLE
            secondPlayerName = "Computer"
        }else{
            editTextSecondPlayer.visibility = View.VISIBLE
            switchRole.visibility = View.INVISIBLE


        }
        val intent = Intent(this, GameActivity::class.java)
        buttonStart.setOnClickListener {
            if(singleGame){
                intent.putExtra("role",roleChanged)
                intent.putExtra("first_player",editTextFirstPlayer.text.toString())
                intent.putExtra("second_player",secondPlayerName)
                startActivity(intent)
            }else{
                intent.putExtra("role",roleChanged)
                intent.putExtra("first_player",editTextFirstPlayer.text.toString())
                intent.putExtra("second_player",editTextSecondPlayer.text.toString())
                startActivity(intent)
            }

        }


    }
}