package com.example.quizthink

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.quizthink.databinding.ActivityArtNatureBinding

class ArtNatureActivity : AppCompatActivity() {


    private val viewModel: ArtNatureQuesViewModel by viewModels()
    private lateinit var binding: ActivityArtNatureBinding



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtNatureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.totalQuizNumberLabel.text = "Total Quiz: " // showing quiz label
        binding.totalQuizNumber.text = "${viewModel.getQuesSize()}" // showing total quiz number
        showCurrentQues() // showing current question when screen initialized
        binding.resultBtn.visibility = View.GONE

//        show next question when click submit button
        binding.nextQuestion.setOnClickListener(){
            var selectOptionIndex =
                binding.quizOptionsGroup.indexOfChild(findViewById(binding.quizOptionsGroup.checkedRadioButtonId))

            if (selectOptionIndex != -1){
                viewModel.checkAnswer(selectOptionIndex)
                showNextQues()
            }else{
                Toast.makeText(this, "Select One", Toast.LENGTH_SHORT).show()
            }
        }

//        quiz restart when click Play Again Button id == artNatureRestartQuizBtn
        binding.artNatureRestartQuizBtn.setOnClickListener {
            viewModel.restart() //this is for quiz restart
            binding.resultBtn.visibility = View.GONE
            binding.quizOptionsGroup.clearCheck() // this is for clear options group
            Toast.makeText(this, "Quiz Reloaded", Toast.LENGTH_SHORT).show() //this is for a simple toast
            binding.artNatureRestartQuizBtn.visibility = View.GONE // this is for Hiding Play quiz button when quiz restart
            binding.afterFinishArtNatureQuizHiddenLayout.visibility = View.GONE //this is for hiding hidden layout when quiz restart
            binding.categoryQuesAns.visibility = View.VISIBLE //this is for visible QuesAns layout for showing ques ans content
            binding.nextQuestion.visibility = View.VISIBLE // this is for visible Submit button when quiz restart
        }



//        When click check result button
        binding.resultBtn.setOnClickListener(){
            val resultPage = Intent(this, ResultActivity:: class.java)
            val artNatureResultMsg = "You get ${viewModel.getScore()} out of ${viewModel.getQuesSize()}"
            resultPage.putExtra("anResult", artNatureResultMsg)
            startActivity(resultPage)
        }

//        When click top bar back icon
        binding.categoryBack.setOnClickListener(){
            val backCategory = Intent(this, DashboardActivity:: class.java)
            startActivity(backCategory)
            finish()
        }
    }

    private fun showNextQues(){
        val nextQuestion = viewModel.getNextQuestion()
        if (nextQuestion != null){
            showCurrentQues()
        }else{
            Toast.makeText(this, "Congrats you played ${viewModel.getQuesSize()} Quiz",
                Toast.LENGTH_SHORT).show()
            binding.categoryQuesAns.visibility = View.GONE
            binding.nextQuestion.visibility = View.GONE
            binding.afterFinishArtNatureQuizHiddenLayout.visibility = View.VISIBLE
            binding.artNatureRestartQuizBtn.visibility = View.VISIBLE
            binding.resultBtn.visibility = View.VISIBLE
        }
    }


    private fun showCurrentQues(){
        val currentQues = viewModel.getCurrentQuestion()
        binding.apply {
            quizQuesTV.text = currentQues.question
            quizOption1.text = currentQues.options[0]
            quizOption2.text = currentQues.options[1]
            quizOption3.text = currentQues.options[2]
            quizOption4.text = currentQues.options[3]
            quizOptionsGroup.clearCheck()
        }
    }
}