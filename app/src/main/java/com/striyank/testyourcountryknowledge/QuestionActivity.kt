package com.striyank.testyourcountryknowledge

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.striyank.testyourcountryknowledge.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityQuestionBinding
    private var currentQuestionPosition = 1
    private var selectedOptionPosition = 0
    private var numberOfCorrectAnswer : Int = 0
    private var playerName : String? = null

    /**
     * Get the list of questions
     */
    private var questions : ArrayList<Question>? = Data.getQuestion()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Get the player name from the intent
        playerName = intent.getStringExtra(Data.USER_NAME)

        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setQuestion()

        /**
         * Set clickListener on the option
          */
        binding.optionOne.setOnClickListener (this)
        binding.optionTwo.setOnClickListener (this)
        binding.optionThree.setOnClickListener (this)
        binding.optionFour.setOnClickListener (this)
        binding.submitButton.setOnClickListener(this)


    }

    /**
     * Set questions to the view
     */
    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        //Set question to the first question of the list
        val question : Question = questions!![currentQuestionPosition - 1]

        optionView()

        if (currentQuestionPosition == questions!!.size){
            binding.submitButton.text = "FINISH"
        }else{
            binding.submitButton.text = "SUBMIT"
        }
        binding.progressBar.progress = currentQuestionPosition

        //Set progressBar text to n/20 format
        binding.progressBarText.text = "$currentQuestionPosition" + "/" + binding.progressBar.max

        //Set the question text to the asked question
        binding.questionText.text = question.askedquestion

        //Set the flag of each country accordingly based on the question index
        binding.countryFlag.setImageResource(question.flag)

        //Set option based on each country
        binding.optionOne.text = question.option1
        binding.optionTwo.text = question.option2
        binding.optionThree.text = question.option3
        binding.optionFour.text = question.option4
    }

    /**
     * Handle question options View
     */
    private fun optionView(){
        val options = ArrayList<TextView>()
        options.add(0, binding.optionOne)
        options.add(1, binding.optionTwo)
        options.add(2, binding.optionThree)
        options.add(3, binding.optionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.start_button_background)
        }
    }

    /**
     * Set click on each option view and set the view
     */
    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.option_one -> {
                selectedOptionsView(binding.optionOne, 1)
            }

            R.id.option_two -> {
                selectedOptionsView(binding.optionTwo, 2)
            }

            R.id.option_three -> {
                selectedOptionsView(binding.optionThree, 3)
            }

            R.id.option_four -> {
                selectedOptionsView(binding.optionFour, 4)
            }

            /**
             * If the selectedOption position is 0, go to the next question
             */
            R.id.submit_button -> {
                if (selectedOptionPosition == 0){
                    currentQuestionPosition++

                    when{
                        currentQuestionPosition <= questions!!.size ->{
                            setQuestion()
                        }else ->{
                            Toast.makeText(this, "You have successfully completed the quiz",
                                Toast.LENGTH_LONG).show()
                            val intent = Intent(this, ResultActivity::class.java)
                             intent.putExtra(Data.USER_NAME, playerName)
                             intent.putExtra(Data.CORRECT_ANSWER, numberOfCorrectAnswer)
                             intent.putExtra(Data.TOTAL_QUESTION, questions!!.size)
                             startActivity(intent)
                             finish()
                        }
                    }
                }else{
                    val newQuestion = questions!![currentQuestionPosition - 1]
                    if (newQuestion.correctAnswer != selectedOptionPosition){
                        submit(selectedOptionPosition, R.drawable.wrong_option_border_background)
                    }else{
                        numberOfCorrectAnswer ++
                    }
                    submit(newQuestion.correctAnswer, R.drawable.correct_option_border_background)

                    /**
                     * Handle submit button text state depending on the current position value
                     */
                    if (currentQuestionPosition == questions!!.size){
                        binding.submitButton.text = "FINISH"
                    }else{
                        binding.submitButton.text = "GO TO NEXT QUESTION"
                    }
                    selectedOptionPosition = 0
                }
            }
        }
    }

    /**
     * Handle the option view when an answer is selected and submit
     * It takes user's answer and the drawable Id
     */
    private fun submit(answer : Int, drawableId : Int) {
        when(answer){
            1 -> {
                binding.optionOne.background = ContextCompat.getDrawable(this, drawableId)
            }

            2 -> {
                binding.optionTwo.background = ContextCompat.getDrawable(this, drawableId)
            }

            3 -> {
                binding.optionThree.background = ContextCompat.getDrawable(this, drawableId)
            }

            4 -> {
                binding.optionFour.background = ContextCompat.getDrawable(this, drawableId)
            }
        }
    }

    /**
     * Handle the selected option view
     * It takes the option text and its number of position and set the color based on user choice
     */
    private fun selectedOptionsView(view : TextView, selectedOptionNumber : Int){
        optionView()
        selectedOptionPosition = selectedOptionNumber

        view.setTextColor(Color.parseColor("#363A43"))
        view.setTypeface(view.typeface, Typeface.BOLD)
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option_background)
    }
}