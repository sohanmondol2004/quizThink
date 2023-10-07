package com.example.quizthink

import androidx.lifecycle.ViewModel

class GKViewModel: ViewModel() {
    private var gkQuestions = GeneralKnowledgeDataSource.generalQuestions
    private var quizList: MutableList<GeneralKnowledgeQuestion> = gkQuestions

    init {
        quizList.shuffle()
    }
    private var currentQuesIndex = 0
    private var score = 0
    private var showResult = score


    fun restart(){
        currentQuesIndex = 0
        score = 0
    }

    fun getCurrentQUes(): GeneralKnowledgeQuestion{
        return quizList[currentQuesIndex]
    }
    fun getNextQues(): GeneralKnowledgeQuestion ?{
        currentQuesIndex++
        return if(currentQuesIndex < quizList.size){
            quizList[currentQuesIndex]
        }else{
            null
        }
    }
    fun checkAnswer(selectedIndex: Int): Boolean{
        var currentQues = quizList[currentQuesIndex]
        return if (selectedIndex == currentQues.correctAnswerIndex){
            score++
            true
        }else{
            false
        }
    }

    fun getScore():Int{
        return score
    }

    fun showResult(): Int{
        return showResult
    }

    fun quesSize(): Int{
        return quizList.size
    }
}