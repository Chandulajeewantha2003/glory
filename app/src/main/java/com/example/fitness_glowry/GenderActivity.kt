package com.example.fitness_glowry

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class GenderActivity : AppCompatActivity() {

    private var selectedGender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gender)   // <-- your gender XML

        // Views
        val cardMale   = findViewById<MaterialCardView>(R.id.cardMale)
        val cardFemale = findViewById<MaterialCardView>(R.id.cardFemale)
        val tvMale     = findViewById<TextView>(R.id.tvMale)
        val tvFemale   = findViewById<TextView>(R.id.tvFemale)

        val btnContinue = findViewById<MaterialButton>(R.id.btnContinue)
        val btnSkip     = findViewById<MaterialButton>(R.id.btnSkip)

        // If your XML has android:enabled="false", we’ll turn it on after selection
        btnContinue.isEnabled = false

        // Selection styling helper
        fun updateSelection(gender: String) {
            selectedGender = gender
            btnContinue.isEnabled = true

            val stroke = resources.getDimensionPixelSize(R.dimen.sel_stroke) // define below
            val none   = 0

            if (gender == "male") {
                cardMale.strokeWidth = stroke
                cardFemale.strokeWidth = none
                cardMale.setStrokeColor(getColor(R.color.secondaryColor)) // yellow
            } else {
                cardFemale.strokeWidth = stroke
                cardMale.strokeWidth = none
                cardFemale.setStrokeColor(getColor(R.color.secondaryColor))
            }

            // Optional: text emphasis
            tvMale.setTextColor(if (gender=="male") getColor(R.color.accentColor) else getColor(R.color.white70))
            tvFemale.setTextColor(if (gender=="female") getColor(R.color.accentColor) else getColor(R.color.white70))
        }

        // Card taps
        cardMale.setOnClickListener   { updateSelection("male") }
        cardFemale.setOnClickListener { updateSelection("female") }

        // Continue → Age
        btnContinue.setOnClickListener {
            startActivity(Intent(this, AgeActivity::class.java))
            finish() // remove if you want Back to return here
        }

        // Skip → Age (optional)
        btnSkip.setOnClickListener {
            startActivity(Intent(this, AgeActivity::class.java))
            finish()
        }
    }
}
