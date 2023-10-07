package com.example.quizthink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val delayHandler = Handler()
        delayHandler.postDelayed({
            val da = Intent(this, DashboardActivity:: class.java)
            startActivity(da)
            finish()
        }, 4000)


    }
}