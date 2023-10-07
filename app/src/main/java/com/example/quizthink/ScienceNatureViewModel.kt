package com.example.quizthink

import androidx.lifecycle.ViewModel

class ScienceNatureViewModel: ViewModel() {
    private var questions = ScienceNatureQuizSource.quizList
    private var quizList: MutableList<ScienceNatureQuesDataModel> = questions

    init {
        quizList.shuffle()
    }

    private var currentQuesIndex = 0
    private var score = 0
    private var showResult = score

    fun restart(){
        currentQuesIndex = 0
        score = 0
        showResult = 0
    }
    fun getCurrentQues(): ScienceNatureQuesDataModel{
        return quizList[currentQuesIndex]
    }
    fun getNextQues(): ScienceNatureQuesDataModel ?{
        currentQuesIndex++
        return if (currentQuesIndex < quizList.size){
            quizList[currentQuesIndex]
        }else{
            null
        }
    }
    fun checkAns(selectedIndex: Int): Boolean {
        var currentQues = quizList[currentQuesIndex]
        return if (selectedIndex == currentQues.correctAnsIndex){
            score++
            true
        }else{
            false
        }
    }
    fun showResult(): Int{
        return showResult
    }
    fun getScore(): Int{
        return score
    }
    fun getSize(): Int{
        return quizList.size
    }
}