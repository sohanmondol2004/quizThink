package com.example.quizthink

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quizthink.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var resultViewClose: View

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultViewClose = findViewById(R.id.resultViewClose)

        resultViewClose.setOnClickListener(){
            Toast.makeText(this, "Back Success", Toast.LENGTH_SHORT).show()
            finish()
        }

//      showing result using intent
        var resultAN = intent.getStringExtra("anResult") //result from Art Nature Activity
        var result = intent.getStringExtra("GKResult") //result from gk activity
        var resultOfScienceNature = intent.getStringExtra("SNResult") // result form science nature activity
        var techGadgetResult = intent.getStringExtra("techGadgetResult") //result from tech gadget activity
        var codingViewModel = intent.getStringExtra("codingResult") // result from coding activity
        var societyViewModel = intent.getStringExtra("societyResult") // result from society activity

        binding.resultViewScoreTVForAN.text = resultAN // showing artNature Result
        binding.resultViewScoreTVForGK.text = result // showing gk result
        binding.resultViewScoreTVForSNA.text = resultOfScienceNature //showing science nature result
        binding.resultViewScoreTVForTechGadget.text = techGadgetResult // showing tech gadget result
        binding.resultViewScoreTVForCoding.text = codingViewModel // showing society result
        binding.resultViewScoreTVForSociety.text = societyViewModel // showing society score
    }

}