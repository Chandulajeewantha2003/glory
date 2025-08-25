package com.example.fitness_glowry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TargetWeightActivity : AppCompatActivity() {

    private var targetWeight = 82 // kg default
    private lateinit var tvPrev: TextView
    private lateinit var tvSelected: TextView
    private lateinit var tvNext: TextView
    private lateinit var np: NumberPicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target_weight)

        targetWeight = savedInstanceState?.getInt("target_weight_kg") ?: targetWeight

        tvPrev = findViewById(R.id.tvPrev)
        tvSelected = findViewById(R.id.tvSelected)
        tvNext = findViewById(R.id.tvNext)
        np = findViewById(R.id.npTargetWeight)

        setupPicker()

        findViewById<MaterialButton>(R.id.btnSkip).setOnClickListener { finish() }
        findViewById<MaterialButton>(R.id.btnContinue).setOnClickListener {
            // TODO: go next — use targetWeight (kg)
            // startActivity(Intent(this, NextActivity::class.java).putExtra("target_weight_kg", targetWeight))
            finish()
        }

        val skipButton: Button = findViewById(R.id.btnContinue)
        skipButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // prevents going back to Onboard screen
        }
    }

    private fun setupPicker() {
        // 30..200 kg
        val values = (30..200).map { it.toString() }.toTypedArray()

        np.displayedValues = null
        np.minValue = 0
        np.maxValue = values.lastIndex
        np.displayedValues = values
        np.wrapSelectorWheel = false

        val startIdx = (targetWeight - 30).coerceIn(0, values.lastIndex)
        np.value = startIdx
        updateOverlay(startIdx)

        np.setOnValueChangedListener { _, _, newIndex ->
            targetWeight = 30 + newIndex
            updateOverlay(newIndex)
            tvSelected.animate().scaleX(1.08f).scaleY(1.08f).setDuration(90).withEndAction {
                tvSelected.scaleX = 1f; tvSelected.scaleY = 1f
            }.start()
        }

        // wheel behavior; no keyboard focus
        np.isFocusable = false
        np.isClickable = true
        np.isEnabled = true
        np.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
    }

    private fun updateOverlay(index: Int) {
        val w = 30 + index
        tvSelected.text = w.toString()
        tvPrev.text = if (w > 30) (w - 1).toString() else ""
        tvNext.text = if (w < 200) (w + 1).toString() else ""
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("target_weight_kg", targetWeight)
        super.onSaveInstanceState(outState)
    }
}
