package com.example.fitness_glowry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class AgeActivity : AppCompatActivity() {

    private var selectedAge = 28
    private lateinit var tvPrev: TextView
    private lateinit var tvSelected: TextView
    private lateinit var tvNext: TextView
    private lateinit var np: NumberPicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)

        selectedAge = savedInstanceState?.getInt("age") ?: selectedAge

        tvPrev = findViewById(R.id.tvPrev)
        tvSelected = findViewById(R.id.tvSelected)
        tvNext = findViewById(R.id.tvNext)
        np = findViewById(R.id.npAge)

        setupPicker()

        // Buttons
        findViewById<MaterialButton>(R.id.btnSkip).setOnClickListener { finish() }
        findViewById<MaterialButton>(R.id.btnContinue).setOnClickListener {
            // TODO: navigate, use selectedAge
            finish()
        }

        val skipButton: Button = findViewById(R.id.btnContinue)
        skipButton.setOnClickListener {
            val intent = Intent(this, HeightActivity::class.java)
            startActivity(intent)
            finish() // prevents going back to Onboard screen
        }
    }

    private fun setupPicker() {
        // build explicit list 10..80 so wheel scrolls reliably on all devices
        val values = (10..80).map { it.toString() }.toTypedArray()

        np.displayedValues = null
        np.minValue = 0
        np.maxValue = values.lastIndex
        np.displayedValues = values
        np.wrapSelectorWheel = false

        // place at default
        val startIdx = (selectedAge - 10).coerceIn(0, values.lastIndex)
        np.value = startIdx
        updateOverlay(startIdx)

        // keep overlay synced
        np.setOnValueChangedListener { _, _, newIndex ->
            selectedAge = 10 + newIndex
            updateOverlay(newIndex)
            // small pulse on center label
            tvSelected.animate().scaleX(1.08f).scaleY(1.08f).setDuration(90).withEndAction {
                tvSelected.scaleX = 1f; tvSelected.scaleY = 1f
            }.start()
        }

        // make sure the picker takes touch as a wheel (no keyboard)
        np.isFocusable = false
        np.isClickable = true
        np.isEnabled = true
        np.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
    }

    private fun updateOverlay(index: Int) {
        val age = 10 + index
        tvSelected.text = age.toString()
        tvPrev.text = if (age > 10) (age - 1).toString() else ""
        tvNext.text = if (age < 80) (age + 1).toString() else ""
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("age", selectedAge)
        super.onSaveInstanceState(outState)
    }
}

