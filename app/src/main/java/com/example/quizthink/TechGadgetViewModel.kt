package com.example.quizthink

import androidx.lifecycle.ViewModel

class TechGadgetViewModel: ViewModel() {

    private val quizQues = TechAndGadgetQuestionsSource.techGadgetQuesList
    private val quizList: MutableList<TechAndGadgetQuesFormat> = quizQues

    private var currentQuesIndex = 0
    private var score = 0

    init {
        quizList.shuffle()
    }
    fun restartQuiz(){
        currentQuesIndex = 0
        score = 0
    }

    fun getCurrentQues():TechAndGadgetQuesFormat {
        return quizList[currentQuesIndex]
    }

    fun getNextQues(): TechAndGadgetQuesFormat ?{
        currentQuesIndex++
        return if (currentQuesIndex < quizList.size){
            quizList[currentQuesIndex]
        }else{
            null
        }
    }
    fun checkAnswer(selectedIndex:Int ):Boolean{
        var currentQues = quizList[currentQuesIndex]
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
        return quizList.size
    }
}