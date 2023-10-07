package com.example.quizthink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.quizthink.databinding.ActivitySocietyBinding

class SocietyActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySocietyBinding
    private val viewModel: SocietyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySocietyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.societyContainerTotalQuizLabel.text = "Total Quiz: " // showing total quiz label on container top bar
        binding.societyContainerTotalQuizNumber.text = "${viewModel.quizSize()}" // showing quiz no on total quiz

        showCurrentQues() // showing current ques when quiz screen initialize
        binding.societyCheckResultBtn.visibility = View.GONE // result button gone

        //Load next ques when click next ques button
        binding.societyNextQuesBtn.setOnClickListener {
            var selectIndex = binding.societyOptionGroup.indexOfChild(findViewById(binding.societyOptionGroup.checkedRadioButtonId))
            if (selectIndex != -1){
                viewModel.checkAnswer(selectIndex)
                showNextQues()
            }else{
                Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show()
            }
        }

        // Restart quiz when click restart button
        binding.societyQuizRestartBtn.setOnClickListener {
            viewModel.restartQuiz()
            binding.apply {
                societyCheckResultBtn.visibility = View.GONE
                societyOptionGroup.clearCheck()
                societyQuizRestartBtn.visibility = View.GONE
                societyNextQuesBtn.visibility = View.VISIBLE
                societyHiddenLayoutForShowingCheckResultAlert.visibility = View.GONE
                societyQuesAnsLayout.visibility = View.VISIBLE
            }
        }

        // check result when click check result button
        binding.societyCheckResultBtn.setOnClickListener {
            val checkResult = Intent(this, ResultActivity::class.java)
            val resultText = "You got ${viewModel.getScore()}  out of ${viewModel.quizSize()}"
            checkResult.putExtra("societyResult", resultText)
            startActivity(checkResult)
        }

        

        // TopBar close icon press back function
        binding.societyTopBarClose.setOnClickListener {
            var goDashboard = Intent(this, DashboardActivity:: class.java)
            startActivity(goDashboard)
            finish()
        }
    }

    private fun showNextQues(){
        var nextQues = viewModel.getNextQues()
        if (nextQues != null){
            showCurrentQues()
        }else{
            Toast.makeText(this, "Congrats you played ${viewModel.quizSize()} quiz", Toast.LENGTH_SHORT).show()
            binding.apply {
                societyQuesAnsLayout.visibility = View.GONE
                societyNextQuesBtn.visibility = View.GONE
                societyHiddenLayoutForShowingCheckResultAlert.visibility = View.VISIBLE
                societyQuizRestartBtn.visibility = View.VISIBLE
                binding.societyCheckResultBtn.visibility = View.VISIBLE // quiz end result btn visible
            }
        }
    }

    private fun showCurrentQues(){
        var currentQues = viewModel.getCurrentQues()
        binding.apply {
            societyQuesTV.text = currentQues.question
            societyOption1.text = currentQues.option[0]
            societyOption2.text = currentQues.option[1]
            societyOption3.text = currentQues.option[2]
            societyOption4.text = currentQues.option[3]
            societyOptionGroup.clearCheck()
        }
    }
}