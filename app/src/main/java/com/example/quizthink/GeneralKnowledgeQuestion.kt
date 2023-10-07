package com.example.quizthink

data class GeneralKnowledgeQuestion (
    var question: String,
    var option: List<String>,
    var correctAnswerIndex: Int
)