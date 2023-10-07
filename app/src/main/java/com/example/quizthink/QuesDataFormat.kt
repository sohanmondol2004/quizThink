package com.example.quizthink

data class TechAndGadgetQuesFormat(
    var question: String,
    var option: List<String>,
    var correctAnsIndex: Int
)
data class CodingQuesFormat(
    var question: String,
    var option: List<String>,
    var correctAnsIndex: Int
)

data class SocietyQuesFormat(
    var question: String,
    var option: List<String>,
    var correctAnsIndex: Int
)