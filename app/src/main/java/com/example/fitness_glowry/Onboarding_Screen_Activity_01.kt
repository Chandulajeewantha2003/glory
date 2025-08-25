package com.example.fitness_glowry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Onboarding_Screen_Activity_01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding_screen01)

        // Fix window insets for fullscreen
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Find Skip button and set click event
        val skipButton: Button = findViewById(R.id.skipButton)
        skipButton.setOnClickListener {
            val intent = Intent(this, Onboarding_Screen_Activity_02::class.java)
            startAct ivity(intent)
            finish( ) // prevents going back to Onboard screen
        }
    }
}
