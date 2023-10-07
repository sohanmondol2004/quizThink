package com.example.quizthink

import androidx.lifecycle.ViewModel

class SocietyViewModel:ViewModel() {

    private var societyQues = SocietyQuesSource.societyQuesList
    private var societyQuesList: MutableList<SocietyQuesFormat> = societyQues

    private var currentQuesIndex = 0
    private var score = 0

    init {
        societyQuesList.shuffle()
    }

    fun restartQuiz(){
        currentQuesIndex = 0
        score = 0
    }
    fun getCurrentQues(): SocietyQuesFormat{
        return societyQuesList[currentQuesIndex]
    }
    fun getNextQues(): SocietyQuesFormat ?{
        currentQuesIndex++
        return if (currentQuesIndex < quizSize()){
            societyQuesList[currentQuesIndex]
        }else{
            null
        }
    }
    fun checkAnswer(selectedIndex: Int): Boolean{
        var currentQues = societyQuesList[currentQuesIndex]
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
    fun quizSize():Int{
        return societyQuesList.size
    }


}