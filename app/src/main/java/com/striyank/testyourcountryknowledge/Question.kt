package com.striyank.testyourcountryknowledge

data class Question(
    val questionId : Int,
    val askedquestion : String,
    val flag : Int,
    val option1 : String,
    val option2 : String,
    val option3 : String,
    val option4 : String,
    val correctAnswer : Int
)
