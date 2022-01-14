package com.striyank.testyourcountryknowledge

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.striyank.testyourcountryknowledge.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Retrieve data from QuestionActivity and set text view with them
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playerName = intent.getStringExtra(Data.USER_NAME)
        binding.playerNameText.text = playerName

        val numberOfQuestion = intent.getIntExtra(Data.TOTAL_QUESTION, 0)
        val score = intent.getIntExtra(Data.CORRECT_ANSWER, 0)

        binding.scoreText.text = "Your score is $score out of $numberOfQuestion"

      //Navigate the main activity
        binding.finishButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}