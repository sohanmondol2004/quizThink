package com.example.quizthink

import androidx.lifecycle.ViewModel

class CodingViewModel: ViewModel() {

    private var codingQues = CodingQuestionSource.codingQuesList
    private var codingQuesList: MutableList<CodingQuesFormat> = codingQues

    private var currentQuesIndex = 0
    private var score = 0

    init {
        codingQuesList.shuffle()
    }
    fun restartQuiz(){
        currentQuesIndex = 0
        score = 0
    }
    fun getCurrentQues(): CodingQuesFormat{
        return codingQuesList[currentQuesIndex]
    }
    fun getNextQues(): CodingQuesFormat ?{
        currentQuesIndex++
        return if (currentQuesIndex < quizSize()){
            codingQuesList[currentQuesIndex]
        }else{
            null
        }
    }
    fun checkCorrectAns(selectedIndex: Int): Boolean{
        var currentQues = codingQuesList[currentQuesIndex]
        return if (selectedIndex == currentQues.correctAnsIndex){
            score++
            true
        }else{
            false
        }
    }
    fun getScore(): Int{
        return score
    }
    fun quizSize(): Int{
        return codingQuesList.size
    }
}