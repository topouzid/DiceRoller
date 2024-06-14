package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.android.diceroller.databinding.ActivityMainBinding
import java.util.*

//The following is used for DataBinding instead of findViewById
private lateinit var binding: ActivityMainBinding

////The following is normally being used to call findViewById as little times as possible, here used by binding
//lateinit var diceImage: ImageView
//
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
//        diceImage = findViewById(R.id.dice_image)
//    }
//
//    private fun rollDice() {
//        val randomInt = Random().nextInt(6) + 1
//        val resultText: TextView = findViewById(R.id.result_textview)
//        val resultDiceImage: ImageView = findViewById(R.id.dice_image)
//        resultText.text = randomInt.toString()
//        val diceDrawableResource = when (randomInt) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            6 -> R.drawable.dice_6
//            else -> R.drawable.empty_dice
//        }
//        diceImage.setImageResource(diceDrawableResource)
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
        binding.resultTextview.text = "Roll that dice!"
//        binding.resultTextview.setText("Zero?")

        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
            rollDice()
        }

    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val resultText: TextView = binding.resultTextview
        val resultDiceImage: ImageView = binding.diceImage
        resultText.text = randomInt.toString()
        val diceDrawableResource = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        resultDiceImage.setImageResource(diceDrawableResource)
    }
}
