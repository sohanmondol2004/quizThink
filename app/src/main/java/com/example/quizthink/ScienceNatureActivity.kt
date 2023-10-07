package com.example.quizthink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.quizthink.databinding.ActivityScienceNatureBinding

class ScienceNatureActivity : AppCompatActivity() {

    private val viewModel: ScienceNatureViewModel by viewModels()
    private lateinit var binding: ActivityScienceNatureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScienceNatureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scienceNatureContainerTopBarTotalQuizLabel.text = "Total Quiz: " // For showing total quiz label
        binding.scienceNatureContainerTopBarTotalQuizTV.text = "${viewModel.getSize()}" // load total quiz when screen initialize
        loadCurrentQues() //When screen initialize Question Will be loaded
        binding.scienceNatureCheckResultBtn.visibility = View.GONE // result button gone


        // LoadNextQuestion when click next ques button
        binding.scienceNatureNextQuesBtn.setOnClickListener(){
            var selectedIndex =
                binding.scienceNatureOptionGroup.indexOfChild(findViewById(binding.scienceNatureOptionGroup.checkedRadioButtonId))
            if (selectedIndex != -1){
                viewModel.checkAns(selectedIndex)
                loadNextQuestion()
            }else{
                Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show()
            }
        }

        // Restart Quiz Button for start quiz again
        binding.scienceNatureRestartQuesBtn.setOnClickListener(){
            viewModel.restart()
            binding.scienceNatureOptionGroup.clearCheck()
            binding.scienceNatureCheckResultBtn.visibility = View.GONE
            binding.scienceNatureRestartQuesBtn.visibility = View.GONE
            binding.afterFinishAllQuizHiddenLayout.visibility = View.GONE
            binding.scienceNatureQuesAnsLayout.visibility = View.VISIBLE
            binding.scienceNatureNextQuesBtn.visibility = View.VISIBLE
        }

        // Show result activity
        binding.scienceNatureCheckResultBtn.setOnClickListener(){
            var resultPage = Intent(this, ResultActivity:: class.java)
            var showResult = "You get ${viewModel.getScore()} out of ${viewModel.getSize()}"
            resultPage.putExtra("SNResult", showResult)
            startActivity(resultPage)
        }

        binding.scienceNatureTopBarClose.setOnClickListener(){
            var goDashboard = Intent(this, DashboardActivity:: class.java)
            startActivity(goDashboard)
            finish()
        }

    }

    private fun loadNextQuestion(){
        var nextQuestion = viewModel.getNextQues()
        if (nextQuestion != null ){
            loadCurrentQues()
        }else{
            Toast.makeText(this, "Congrats you played ${viewModel.getSize()}", Toast.LENGTH_SHORT).show()
            binding.scienceNatureNextQuesBtn.visibility = View.GONE
            binding.scienceNatureQuesAnsLayout.visibility = View.GONE
            binding.afterFinishAllQuizHiddenLayout.visibility = View.VISIBLE
            binding.scienceNatureRestartQuesBtn.visibility = View.VISIBLE
            binding.scienceNatureCheckResultBtn.visibility = View.VISIBLE // result button visible when quiz end
        }
    }

    private fun loadCurrentQues(){
        var currentQues = viewModel.getCurrentQues()
        binding.apply {
            scienceNatureQuesTV.text = currentQues.question
            scienceNatureOption1.text = currentQues.options[0]
            scienceNatureOption2.text = currentQues.options[1]
            scienceNatureOption3.text = currentQues.options[2]
            scienceNatureOption4.text = currentQues.options[3]
            scienceNatureOptionGroup.clearCheck()
        }
    }
}