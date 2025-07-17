package gr.tnet.android.diceroller

import android.content.Intent
import androidx.core.net.toUri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import gr.tnet.android.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge support for Android 15+ (and all supported versions)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Use insets-aware behavior for transparency and swipe bars
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = true  // dark icons on light background
            isAppearanceLightNavigationBars = true
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            //hide(WindowInsetsCompat.Type.systemBars())
            // Don't use hide() — we want the bars to be overlaid, not removed
        }

        // Creating a binding object for the main_activity.xml layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Insets-aware padding to prevent overlaps
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val sysInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(sysInsets.left, sysInsets.top, sysInsets.right, sysInsets.bottom)
            insets
        }

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
        val intent = Intent(Intent.ACTION_VIEW, "http://android.tnet.gr/Dice-Roller/".toUri())
        startActivity(intent)
    }
}
