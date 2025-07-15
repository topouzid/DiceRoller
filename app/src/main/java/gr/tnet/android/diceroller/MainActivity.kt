/*package gr.tnet.android.diceroller

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
//import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import gr.tnet.android.diceroller.databinding.ActivityMainBinding
import java.util.Random

//The following is used for DataBinding instead of findViewById
private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Creating a binding object for the main_activity.xml layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.diceButton?.text = "Test"
        binding.diceButtonDouble?.text = "Test"

        val rollButton: Button? = binding.diceButton
        rollButton?.text = "Let's Roll"
        binding.resultTextview?.text = "Roll that dice!"

        rollButton?.setOnClickListener {
//            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
            rollDice()
        }

        val rollButtonDouble: Button? = binding.diceButtonDouble
        rollButtonDouble?.text = "Roll them!"
        binding.resultTextviewDouble1?.text = "Waiting"
        binding.resultTextviewDouble2?.text = "..."

        rollButtonDouble?.setOnClickListener{
            rollDiceDouble()
        }

    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val resultText: TextView? = binding.resultTextview
        val resultDiceImage: ImageView? = binding.diceImage
        resultText?.text = randomInt.toString()
        val diceDrawableResource = when(randomInt) {
            1 -> R.drawable.dice_1k
            2 -> R.drawable.dice_2k
            3 -> R.drawable.dice_3k
            4 -> R.drawable.dice_4k
            5 -> R.drawable.dice_5k
            6 -> R.drawable.dice_6k
            else -> R.drawable.empty_dice
        }
        resultDiceImage?.setImageResource(diceDrawableResource)
    }

    private fun rollDiceDouble() {
        val randomInt1 = Random().nextInt(6) + 1
        val randomInt2 = Random().nextInt(6) + 1
        val resultText1: TextView? = binding.resultTextviewDouble1
        val resultText2: TextView? = binding.resultTextviewDouble2
        val resultDiceImage1: ImageView? = binding.diceImageDouble1
        val resultDiceImage2: ImageView? = binding.diceImageDouble2
        resultText1?.text = randomInt1.toString()
        resultText2?.text = randomInt2.toString()
        val diceDrawableResource1 = when(randomInt1) {
            1 -> R.drawable.dice_1k
            2 -> R.drawable.dice_2k
            3 -> R.drawable.dice_3k
            4 -> R.drawable.dice_4k
            5 -> R.drawable.dice_5k
            6 -> R.drawable.dice_6k
            else -> R.drawable.empty_dice
        }
        val diceDrawableResource2 = when(randomInt2) {
            1 -> R.drawable.dice_1k
            2 -> R.drawable.dice_2k
            3 -> R.drawable.dice_3k
            4 -> R.drawable.dice_4k
            5 -> R.drawable.dice_5k
            6 -> R.drawable.dice_6k
            else -> R.drawable.empty_dice
        }
        resultDiceImage1?.setImageResource(diceDrawableResource1)
        resultDiceImage2?.setImageResource(diceDrawableResource2)
    }

    fun onClickOpenPrivacyPolicyButton(view: View) {

        // TODO (5) Create a String that contains a URL ( make sure it starts with http:// or https://
        //val urlAsString = "http://android.tnet.gr/Dice-Roller/"
        // TODO (6) Replace the Toast with a call to openWebPage, passing in the URL String from the previous step
        //openWebPage(urlAsString)
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://android.tnet.gr/Dice-Roller/")))
    }

}
*/

package gr.tnet.android.diceroller

import android.content.Intent
//import android.net.Uri
import androidx.core.net.toUri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gr.tnet.android.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random
import androidx.activity.enableEdgeToEdge //edge to edge
//import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge support for Android 15+ (and all supported versions)
        //WindowCompat.enableEdgeToEdge(window)
        enableEdgeToEdge()

        // Creating a binding object for the main_activity.xml layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.diceButton?.text = getString(R.string.diceBtnString)
        binding.diceButton?.setOnClickListener { rollDice() }
        binding.resultTextview?.text = getString(R.string.diceString)

        // If you have a double-dice feature
        binding.diceButtonDouble?.text = getString(R.string.diceDblBtnString)
        binding.diceButtonDouble?.setOnClickListener { rollDiceDouble() }
        binding.resultTextviewDouble1?.text = getString(R.string.diceString)
        binding.resultTextviewDouble2?.text = "..."

        binding.privacypolicyButtonview?.setOnClickListener {
            openPrivacyPolicy()
        }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(1, 7) // 1..6 inclusive
        binding.resultTextview?.text = randomInt.toString()
        val diceDrawableResource = when (randomInt) {
            1 -> R.drawable.dice_1k
            2 -> R.drawable.dice_2k
            3 -> R.drawable.dice_3k
            4 -> R.drawable.dice_4k
            5 -> R.drawable.dice_5k
            6 -> R.drawable.dice_6k
            else -> R.drawable.empty_dice
        }
        binding.diceImage?.setImageResource(diceDrawableResource)
    }

    private fun rollDiceDouble() {
        val randomInt1 = Random.nextInt(1, 7)
        val randomInt2 = Random.nextInt(1, 7)
        binding.resultTextviewDouble1?.text = randomInt1.toString()
        binding.resultTextviewDouble2?.text = randomInt2.toString()
        val diceDrawableResource1 = when (randomInt1) {
            1 -> R.drawable.dice_1k
            2 -> R.drawable.dice_2k
            3 -> R.drawable.dice_3k
            4 -> R.drawable.dice_4k
            5 -> R.drawable.dice_5k
            6 -> R.drawable.dice_6k
            else -> R.drawable.empty_dice
        }
        val diceDrawableResource2 = when (randomInt2) {
            1 -> R.drawable.dice_1k
            2 -> R.drawable.dice_2k
            3 -> R.drawable.dice_3k
            4 -> R.drawable.dice_4k
            5 -> R.drawable.dice_5k
            6 -> R.drawable.dice_6k
            else -> R.drawable.empty_dice
        }
        binding.diceImageDouble1?.setImageResource(diceDrawableResource1)
        binding.diceImageDouble2?.setImageResource(diceDrawableResource2)
    }

    fun openPrivacyPolicy() {
        //val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://android.tnet.gr/Dice-Roller/"))
        val intent = Intent(Intent.ACTION_VIEW, "http://android.tnet.gr/Dice-Roller/".toUri())
        startActivity(intent)
    }
}
