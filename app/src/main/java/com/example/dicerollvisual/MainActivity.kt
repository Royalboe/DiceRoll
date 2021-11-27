package com.example.dicerollvisual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

/**
 * This lets the user to roll a dice and the result
 * displayed on the screen.
 */

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        diceImage1 = findViewById(R.id.imageView4)
        diceImage2 = findViewById(R.id.imageView7)

        rollButton.setOnClickListener { rollDice() }
        // Do a roll dice when the app starts
        rollDice()
    }


    /**
     * Roll the dice and update the screen with the results
     */

    private fun rollDice() {
        // create new dice object with 6 sides and roll it
        val firstDice = Dice(6)
        val diceRoll = firstDice.roll()
        // create a second dice object with 6 sides and roll it
        val secondDice = Dice(6)
        val deiceRoll2 = secondDice.roll()

        //update the screen with the dice roll

        // Determine which drawable resourse ID to use based on the dice roll
        val drawableResource1 = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else  -> R.drawable.dice_6
        }
        val drawableResource2 = when(deiceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else  -> R.drawable.dice_6
        }
// Update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
        // update the content description
        diceImage1.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = deiceRoll2.toString()
    }
}
/*
Dice class with one behaviour and state
 */
class Dice(private val numSides: Int) {
    fun roll() = Random().nextInt(numSides) + 1
}
