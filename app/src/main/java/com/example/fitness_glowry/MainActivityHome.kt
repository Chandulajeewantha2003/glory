package com.example.fitness_glowry

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class MainActivityHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        // Hero CTA
        findViewById<MaterialButton>(R.id.btnGetStarted).setOnClickListener {
            Toast.makeText(this, "Get Started tapped", Toast.LENGTH_SHORT).show()
        }

        // Bottom nav
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_home
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // already on Home
                    true
                }
                R.id.nav_discover -> {
                    Toast.makeText(this, "Discover", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_reports -> {
                    Toast.makeText(this, "Reports", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_history -> {
                    Toast.makeText(this, "History", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_account -> {
                    Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
