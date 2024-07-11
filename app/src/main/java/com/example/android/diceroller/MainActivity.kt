package com.example.android.diceroller

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.diceroller.databinding.ActivityMainBinding
import java.util.Random

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
            1 -> R.drawable.dice_1k
            2 -> R.drawable.dice_2k
            3 -> R.drawable.dice_3k
            4 -> R.drawable.dice_4k
            5 -> R.drawable.dice_5k
            6 -> R.drawable.dice_6k
            else -> R.drawable.empty_dice
        }
        resultDiceImage.setImageResource(diceDrawableResource)
    }

    fun onClickOpenPrivacyPolicyButton(view: View) {

        // TODO (5) Create a String that contains a URL ( make sure it starts with http:// or https://
        //val urlAsString = "http://android.tnet.gr/Dice-Roller/"
        // TODO (6) Replace the Toast with a call to openWebPage, passing in the URL String from the previous step
        //openWebPage(urlAsString)
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://android.tnet.gr/Dice-Roller/")))
    }
/*
    private fun openWebPage(urlAsString: String) {

        // TODO (2) Use Uri.parse to parse the String into a Uri
        val webpage = Uri.parse(urlAsString)

        // TODO (3) Create an Intent with Intent.ACTION_VIEW and the webpage Uri as parameters
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        // TODO (4) Verify that this Intent can be launched and then call startActivity
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    } */
}
