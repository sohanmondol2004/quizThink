package com.example.quizthink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.quizthink.databinding.ActivityScienceNatureBinding
import com.example.quizthink.databinding.ActivityTechAndGadgetBinding

class TechAndGadgetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTechAndGadgetBinding
    private val viewModel: TechGadgetViewModel by viewModels()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechAndGadgetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // show total quiz
        var totalQuiz = ViewModelProvider(this)[TechGadgetViewModel::class.java]
        binding.techAndGadgetTotalQuesCount.text = "${totalQuiz.quizSize()}"
        binding.techAndGadgetTotalQuesLabel.text = "Total Quiz: " //change total quiz label


        binding.checkResultButton.visibility = View.GONE // result btn gone
        showCurrentQues() // showing current question when quiz screen initialized


        // show next ques when clicked next question
        binding.nextQuesButton.setOnClickListener {
            var selectIndex =
                binding.techAndGadgetQuizOptionGroup.indexOfChild(findViewById(binding.techAndGadgetQuizOptionGroup.checkedRadioButtonId))

            if (selectIndex != -1) {
                viewModel.checkAnswer(selectIndex)
                showNextQues()
            }
            else{
                Toast.makeText(this, "Select an Option", Toast.LENGTH_SHORT).show()
            }
        }

        //When click restart button for play quiz again
        binding.restartQuizButton.setOnClickListener {
            viewModel.restartQuiz()

            binding.apply {
                checkResultButton.visibility = View.GONE
                techAndGadgetQuizOptionGroup.clearCheck()
                afterFinishTechGadgetHiddenLayout.visibility = View.GONE
                techAndGadgetQuesAnsLayout.visibility = View.VISIBLE
                restartQuizButton.visibility = View.GONE
                nextQuesButton.visibility = View.VISIBLE
            }
        }

        //Check result when click check result button
        binding.checkResultButton.setOnClickListener {
            var checkResultPage = Intent(this, ResultActivity::class.java)
            var showResultText = "You get ${viewModel.getScore()} out of ${viewModel.quizSize()}"
            checkResultPage.putExtra("techGadgetResult", showResultText)
            startActivity(checkResultPage)
        }

        // close screen when click top bar close icon
        binding.generalKnowledgeTopBarClose.setOnClickListener {
            var goDashboard = Intent(this, DashboardActivity::class.java)
            startActivity(goDashboard)
            finish()
        }

    }

    private fun showNextQues(){
        var nextQues = viewModel.getNextQues()
        if (nextQues != null){
            showCurrentQues()
        }else{
            Toast.makeText(this, "Congrats you played ${viewModel.quizSize()}", Toast.LENGTH_SHORT).show()
            binding.techAndGadgetQuesAnsLayout.visibility = View.GONE
            binding.nextQuesButton.visibility = View.GONE
            binding.afterFinishTechGadgetHiddenLayout.visibility = View.VISIBLE
            binding.restartQuizButton.visibility = View.VISIBLE
            binding.checkResultButton.visibility = View.VISIBLE // result visible when quiz end

        }
    }

    private fun showCurrentQues(){
        var currentQues = viewModel.getCurrentQues()
        binding.apply {
            techAndGadgetQuizQuesTV.text = currentQues.question
            techAndGadgetQuizOption1.text = currentQues.option[0]
            techAndGadgetQuizOption2.text = currentQues.option[1]
            techAndGadgetQuizOption3.text = currentQues.option[2]
            techAndGadgetQuizOption4.text = currentQues.option[3]
            techAndGadgetQuizOptionGroup.clearCheck()
        }
    }
}