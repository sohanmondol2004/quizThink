package com.example.quizthink

import androidx.lifecycle.ViewModel

class ArtNatureQuesViewModel: ViewModel() {
    private val quizQuestions = DataSource.artNatureQuestions
    private val quizList: MutableList<ArtNatureQuestion> = quizQuestions

    init {
        quizList.shuffle()
    }

    private var currentQuesIndex = 0
    private var score = 0

    fun restart(){
        currentQuesIndex = 0
        score = 0
    }

    fun getCurrentQuestion(): ArtNatureQuestion{
        return quizList[currentQuesIndex]
    }

    fun getNextQuestion(): ArtNatureQuestion? {
        currentQuesIndex++
        return if (currentQuesIndex < quizList.size){
            quizList[currentQuesIndex]
        }else{
            null
        }
    }

    fun checkAnswer(selectedIndex: Int): Boolean {
        var currentQuestion = quizList[currentQuesIndex]
        return if (selectedIndex == currentQuestion.correctAnsIndex){
            score++
            true
        }else{
            false
        }
    }

    fun getScore(): Int {
        return score
    }

    fun getQuesSize(): Int{
        return quizList.size
    }
}