package com.example.quizthink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.quizthink.databinding.ActivityCodingBinding

class CodingActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityCodingBinding
    private val viewModel: CodingViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // showing Total Quiz
        binding.codingContainerTotalQuizNumber.text = "${viewModel.quizSize()}"
        
        showCurrentQues() // showing current ques when quiz page initialize
        binding.codingCheckResultBtn.visibility = View.GONE // result button invisible when screen initialize
        
        // showing next ques when click next ques button
        binding.codingNextQuesBtn.setOnClickListener { 
            var selectedIndex = binding.codingQuizOptionGroup.indexOfChild(findViewById(binding.codingQuizOptionGroup.checkedRadioButtonId))
            if (selectedIndex != -1){
                viewModel.checkCorrectAns(selectedIndex)
                showNextQues()
            }else{
                Toast.makeText(this, "Select An option", Toast.LENGTH_SHORT).show()
            }
        }

        // restart quiz when click restart button
        binding.codingQuizRestartBtn.setOnClickListener {
            viewModel.restartQuiz()
            binding.apply {
                codingCheckResultBtn.visibility = View.GONE
                codingQuizOptionGroup.clearCheck()
                afterFinishAllQuizHiddenLayout.visibility = View.GONE
                codingQuizQuesAnsLayout.visibility = View.VISIBLE
                codingQuizRestartBtn.visibility = View.GONE
                codingNextQuesBtn.visibility = View.VISIBLE
            }
        }

        // check result when click check result button
        binding.codingCheckResultBtn.setOnClickListener {
            val checkResultPage = Intent(this, ResultActivity::class.java)
            val showCodingResult = "You get ${viewModel.getScore()} out of ${viewModel.quizSize()}"
            checkResultPage.putExtra("codingResult", showCodingResult)
            startActivity(checkResultPage)
        }



        // close screen when click top bar close icon
        binding.codingTopBarCloseIcon.setOnClickListener {
            var goDashboard = Intent(this, DashboardActivity::class.java)
            startActivity(goDashboard)
        }
        
        
    }
    private fun showNextQues(){
        val nextQues = viewModel.getNextQues()
        if (nextQues != null){
            showCurrentQues()
        }else{
            Toast.makeText(this, "Congrats you played ${viewModel.quizSize()}", Toast.LENGTH_SHORT).show()
            binding.apply {
                codingNextQuesBtn.visibility = View.GONE
                codingQuizQuesAnsLayout.visibility = View.GONE
                afterFinishAllQuizHiddenLayout.visibility = View.VISIBLE
                codingQuizRestartBtn.visibility = View.VISIBLE
                binding.codingCheckResultBtn.visibility = View.VISIBLE // when quiz end result button visible
            }

        }
    }
    
    private fun showCurrentQues(){
        val currentQues = viewModel.getCurrentQues()
        binding.apply { 
            codingQuestionTV.text = currentQues.question
            codingQuizOption1.text = currentQues.option[0]
            codingQuizOption2.text = currentQues.option[1]
            codingQuizOption3.text = currentQues.option[2]
            codingQuizOption4.text = currentQues.option[3]
            codingQuizOptionGroup.clearCheck()
        }
    }
}