package com.example.quizthink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.quizthink.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    // initialize all needed id
    private lateinit var dashboardTotalQuesTV:TextView
    private lateinit var dashboardScoreTV: TextView
    private lateinit var artCategory: ConstraintLayout
    private lateinit var gkCategory: ConstraintLayout
    private lateinit var scienceCategory: ConstraintLayout
    private lateinit var technologyCategory: ConstraintLayout
    private lateinit var devCategory: ConstraintLayout
    private lateinit var socialCategory: ConstraintLayout
    private lateinit var dashboardUpgradeBtn: AppCompatButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // introducing all needed id
        dashboardTotalQuesTV = findViewById(R.id.dashboardTotalQuesTV)
        dashboardScoreTV = findViewById(R.id.dashboardScoreTV)
        artCategory = findViewById(R.id.artCategory)
        gkCategory = findViewById(R.id.gkCategory)
        scienceCategory = findViewById(R.id.scienceCategory)
        technologyCategory = findViewById(R.id.technologyCategory)
        devCategory = findViewById(R.id.devCategory)
        socialCategory = findViewById(R.id.socialCategory)
        dashboardUpgradeBtn = findViewById(R.id.dashboardUpgradeBtn)

        // initializing all view model using View Model Provider
        val artNatureViewModel = ViewModelProvider(this)[ArtNatureQuesViewModel::class.java]
        val generalKnowledgeViewModel = ViewModelProvider(this)[GKViewModel:: class.java]
        val scienceNatureViewModel = ViewModelProvider(this)[ScienceNatureViewModel:: class.java]
        val techGadgetViewModel = ViewModelProvider(this)[TechGadgetViewModel:: class.java]
        val codingActivityViewModel = ViewModelProvider(this)[CodingViewModel::class.java]
        val societyViewModel = ViewModelProvider(this)[SocietyViewModel::class.java]
        // showing sum of total quiz in dashboard
        val totalQuiz =
            artNatureViewModel.getQuesSize() + generalKnowledgeViewModel.quesSize() + scienceNatureViewModel.getSize() + techGadgetViewModel.quizSize() + codingActivityViewModel.quizSize() + societyViewModel.quizSize()
        dashboardTotalQuesTV.text = totalQuiz.toString() // showing total number of quiz





        // art category listener
        artCategory.setOnClickListener(){
            val artCategory = Intent(this, ArtNatureActivity:: class.java)
            startActivity(artCategory)
        }

        // gk category click listener
        gkCategory.setOnClickListener(){
            val gkCategory = Intent(this, GeneralKnowledgeActivity:: class.java)
            startActivity(gkCategory)
            Toast.makeText(this, "General Knowledge open successfully", Toast.LENGTH_SHORT).show()
        }


        // science category click listener
        scienceCategory.setOnClickListener(){
            val scienceCategory = Intent(this, ScienceNatureActivity:: class.java)
            startActivity(scienceCategory)
            Toast.makeText(this, "Science Category open successfully", Toast.LENGTH_SHORT).show()

        }

        // technology click listener
        technologyCategory.setOnClickListener(){
            val technologyCategory = Intent(this, TechAndGadgetActivity:: class.java)
            startActivity(technologyCategory)
            Toast.makeText(this, "Tech and Gadget open successfully", Toast.LENGTH_SHORT).show()
        }


        // devCategory click listener
        devCategory.setOnClickListener(){
            val devCategory = Intent(this, CodingActivity:: class.java)
            startActivity(devCategory)
            Toast.makeText(this, "Developer Category Test Running, Art Category", Toast.LENGTH_SHORT).show()
        }


        // social category click listener
        socialCategory.setOnClickListener(){
            val socialCategory = Intent(this, SocietyActivity:: class.java)
            startActivity(socialCategory)
            Toast.makeText(this, "Social Category Test Running, Art Category", Toast.LENGTH_SHORT).show()

        }

        // Upgrade button click listener
        dashboardUpgradeBtn.setOnClickListener(){
            Toast.makeText(this, "Button coming soon", Toast.LENGTH_SHORT).show()
        }

    }

    // when double press back
    private var doubleBackToExitPressedOnce = false

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()

        // Set a delay for the second back press (e.g., 2 seconds)
        var backPressHandler = Handler()
        backPressHandler.postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)
    }
}