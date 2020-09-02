package com.broersen.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.broersen.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        binding.btnLower.setOnClickListener{
            onLowerClick()
        }
        binding.btnEquals.setOnClickListener{
            onEqualClick()
        }
        binding.btnhigher.setOnClickListener{
            onHigherClick()
        }
        updateUI()
    }

    private fun updateUI(){
        binding.tvLastThrow.text = getString(R.string.lastThrow, currentThrow)

        when(currentThrow){
            1 -> binding.imageView.setImageResource(R.drawable.dice1)
            2 -> binding.imageView.setImageResource(R.drawable.dice2)
            3 -> binding.imageView.setImageResource(R.drawable.dice3)
            4 -> binding.imageView.setImageResource(R.drawable.dice4)
            5 -> binding.imageView.setImageResource(R.drawable.dice5)
            6 -> binding.imageView.setImageResource(R.drawable.dice6)        }
    }

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onHigherClick() {
        rollDice()
        if (lastThrow < currentThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        if (lastThrow > currentThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        if (lastThrow == currentThrow) onAnswerCorrect()
            else onAnswerIncorrect()
    }

    /**
     * displays Toast message on right answer
     */
    private fun onAnswerCorrect(){
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }
    /**
     * displays Toast message on wrong answer
     */
    private fun onAnswerIncorrect(){
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }
}