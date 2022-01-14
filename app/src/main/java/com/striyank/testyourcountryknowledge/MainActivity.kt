package com.striyank.testyourcountryknowledge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Toast
import com.striyank.testyourcountryknowledge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN

        binding.startButton.setOnClickListener {
            gotoNextScreen(binding.playerName.text.toString())
        }
    }

    private fun gotoNextScreen(name: String) {
        if (name.isEmpty()){
            Toast.makeText(this, "Please, enter your name", Toast.LENGTH_LONG).show()
        }else{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra(Data.USER_NAME, binding.playerName.text.toString())
            startActivity(intent)
            finish()
        }
    }
}