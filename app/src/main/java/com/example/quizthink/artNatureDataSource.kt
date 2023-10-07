package com.example.quizthink

object DataSource {
    val artNatureQuestions = mutableListOf<ArtNatureQuestion>(
        ArtNatureQuestion(
            "1. What is the capital of Bangladesh?",
            listOf("A: Dhaka", "B: Rangpur", "C: Rajshahi", "4: Noakhali"),
            0
        ),
        ArtNatureQuestion(
            "What is the capital of France?",
            listOf("Paris", "Berlin", "London", "Rome"),
            0
        ),ArtNatureQuestion(
            "What is the largest planet in our solar system?",
            listOf("Mars", "Venus", "Jupiter", "Saturn"),
            2
        ),
        ArtNatureQuestion(
            "Who painted the Mona Lisa?",
            listOf("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Michelangelo"),
            0
        )
    )
}
