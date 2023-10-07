package com.example.quizthink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.quizthink.databinding.ActivityGeneralKnowledgeBinding

class GeneralKnowledgeActivity : AppCompatActivity() {

    private val viewModel: GKViewModel by viewModels()
    private lateinit var binding: ActivityGeneralKnowledgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeneralKnowledgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gkContainerTopBarTotalQuizLabel.text = "Total Quiz: " // showing quiz label when screen initialize
        binding.gkContainerTopBarTotalQuizTV.text = "${viewModel.quesSize()}" // loading total quiz when screen initialize

        currentQuestion() //Showing Current Question when screen Initialize
        binding.checkResultBtn.visibility = View.GONE // result button gone when screen initialize

//        Show next ques when click next button
        binding.gkCategoryNextQuesBtn.setOnClickListener(){
            var selectedIndex = binding.gkQuizOptions.indexOfChild(findViewById(binding.gkQuizOptions.checkedRadioButtonId))
            
            if (selectedIndex != -1){
                viewModel.checkAnswer(selectedIndex)
                showNextQues()
            }else{
                Toast.makeText(this, "Select AnyOne", Toast.LENGTH_SHORT).show()
            }
        }

//        When click restart button quiz will be restart
        binding.gkCategoryRestartBtn.setOnClickListener {
            viewModel.restart()
            binding.checkResultBtn.visibility = View.GONE
            binding.gkCategoryRestartBtn.visibility = View.GONE
            binding.showResultMsgLayout.visibility = View.GONE
            binding.qkQuesAnsLayout.visibility = View.VISIBLE
            binding.gkCategoryNextQuesBtn.visibility = View.VISIBLE
            binding.gkQuizOptions.clearCheck()


        }

//        When click check result show the result
        binding.checkResultBtn.setOnClickListener(){
            var goResultPage = Intent(this, ResultActivity:: class.java)
            var showResultGK = "You get ${viewModel.getScore()} out of ${viewModel.quesSize()}"
            goResultPage.putExtra("GKResult", showResultGK)
            startActivity(goResultPage)
        }

//        When clicked TopBar close icon
        binding.gkBack.setOnClickListener(){
            var goDashboard = Intent(this, DashboardActivity::class.java)
            startActivity(goDashboard)
            finish()
        }

    }
    // show next ques function all data from view model
    private fun showNextQues() {
        val nextQues = viewModel.getNextQues()
        if (nextQues != null){
            currentQuestion()
        }else{
            Toast.makeText(this, "Congrats you played ${viewModel.quesSize()}", Toast.LENGTH_SHORT).show()
            binding.qkQuesAnsLayout.visibility = View.GONE // When quiz end quiz layout invisible
            binding.gkCategoryNextQuesBtn.visibility = View.GONE // when quiz end next question button invisible
            binding.showResultMsgLayout.visibility = View.VISIBLE // when quiz end result show message visible
            binding.gkCategoryRestartBtn.visibility = View.VISIBLE // when quiz end show restart button
            binding.checkResultBtn.visibility = View.VISIBLE // result button visible when quiz end

        }
    }
    // show current ques fun for loading ques
    private fun currentQuestion(){
        var currentQues = viewModel.getCurrentQUes()
        binding.apply { 
            gkQuesTV.text = currentQues.question
            gkOption1.text = currentQues.option[0]
            gkOption2.text = currentQues.option[1]
            gkOption3.text = currentQues.option[2]
            gkOption4.text = currentQues.option[3]
            gkQuizOptions.clearCheck()
        }
    }
}