package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.android.diceroller.databinding.ActivityMainBinding
import java.util.*

//The following is used for DataBinding instead of findViewById
private lateinit var binding: ActivityMainBinding

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val rollButton: Button = findViewById(R.id.dice_button)
//        rollButton.text = "Let's Roll"
//
//        rollButton.setOnClickListener {
//            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
//            rollDice()
//        }
//
//    }
//
//    private fun rollDice() {
//        val randomInt = Random().nextInt(6) + 1
//        val resultText: TextView = findViewById(R.id.result_textview)
//        resultText.text = randomInt.toString()
//    }
//}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Creating a binding object for the main_activity.xml layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.diceButton.text = "Test"

        val rollButton: Button = binding.diceButton
        rollButton.text = "Let's Roll"
        binding.resultTextview.text = "Result"
//        binding.resultTextview.setText("Zero?")

        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
            rollDice()
        }

    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val resultText: TextView = findViewById(R.id.result_textview)
        resultText.text = randomInt.toString()
    }
}
