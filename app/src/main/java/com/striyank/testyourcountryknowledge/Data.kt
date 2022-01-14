package com.striyank.testyourcountryknowledge

object Data {

    //CONSTANTS
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTION : String = "total_question"
    const val CORRECT_ANSWER : String = "correct_answer"

    fun getQuestion() : ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.algeria,
            "America",
            "Benin",
            "Algeria",
            "France",
            3
        )

        questionList.add(question1)


        val question2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.belgium,
            "Belgium",
            "Togo",
            "Jordan",
            "Cuba",
            1
        )

        questionList.add(question2)


        val question3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.benin,
            "Kenya",
            "Benin",
            "Australia",
            "Nigeria",
            2
        )

        questionList.add(question3)

        val question4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.angola,
            "Senegal",
            "Chine",
            "Italy",
            "Angola",
            4
        )

        questionList.add(question4)

        val question5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.canada,
            "Canada",
            "Mali",
            "Egypt",
            "Germany",
            1
        )

        questionList.add(question5)

        val question6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.france,
            "Kuwait",
            "Angola",
            "Turkey",
            "France",
            4
        )

        questionList.add(question6)

        val question7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.china,
            "China",
            "Ghana",
            "Dubai",
            "Island",
            1
        )

        questionList.add(question7)

        val question8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.brazilia,
            "Libya",
            "Brazil",
            "Palestine",
            "South of Africa",
            2
        )

        questionList.add(question8)

        val question9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ghana,
            "Botswana",
            "Cameroon",
            "Ghana",
            "Belize",
            3
        )

        questionList.add(question9)

        val question10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.argentina,
            "Morocco",
            "Argentina",
            "Monaco",
            "France",
            2
        )

        questionList.add(question10)

        val question11 = Question(
            11,
            "What country does this flag belong to?",
            R.drawable.australia,
            "Australia",
            "Cote of Ivory",
            "Ethiopia",
            "Austria",
            1
        )

        questionList.add(question11)

        val question12 = Question(
            12,
            "What country does this flag belong to?",
            R.drawable.haiti,
            "Panama",
            "Peru",
            "Haiti",
            "Namibia",
            3
        )

        questionList.add(question12)

        val question13 = Question(
            13,
            "What country does this flag belong to?",
            R.drawable.croatia,
            "Qatar",
            "Croatia",
            "Armenia",
            "Belarus",
            2
        )

        questionList.add(question13)

        val question14 = Question(
            14,
            "What country does this flag belong to?",
            R.drawable.island,
            "Island",
            "Russia",
            "Anguilla",
            "America",
            1
        )

        questionList.add(question14)

        val question15 = Question(
            15,
            "What country does this flag belong to?",
            R.drawable.portugal,
            "Romania",
            "Albania",
            "Bolivia",
            "Portugal",
            4
        )

        questionList.add(question15)

        val question16 = Question(
            16,
            "What country does this flag belong to?",
            R.drawable.nigeria,
            "Bulgaria",
            "Nigeria",
            "Chad",
            "Chile",
            2
        )

        questionList.add(question16)

        val question17 = Question(
            17,
            "What country does this flag belong to?",
            R.drawable.turkey,
            "Turkey",
            "China",
            "Colombia",
            "Dr Congo",
            1
        )

        questionList.add(question17)

        val question18 = Question(
            18,
            "What country does this flag belong to?",
            R.drawable.senegal,
            "Djibouti",
            "Denmark",
            "England",
            "Senegal",
            4
        )

        questionList.add(question18)

        val question19 = Question(
            19,
            "What country does this flag belong to?",
            R.drawable.guinea,
            "Honduras",
            "Guinea",
            "Hungary",
            "India",
            2
        )

        questionList.add(question19)

        val question20 = Question(
            20,
            "What country does this flag belong to?",
            R.drawable.india,
            "India",
            "Japan",
            "Iran",
            "Jamaica",
            1
        )

        questionList.add(question20)

        return questionList
    }
}