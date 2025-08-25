package com.example.fitness_glowry

import android.content.Intent
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
                    // Already on Home
                    true
                }
                R.id.nav_discover -> {
                    startActivity(Intent(this, MainActivityDiscover::class.java))
                    overridePendingTransition(0,0) // smooth, no animation
                    true
                }
                R.id.nav_reports -> {
              //      startActivity(Intent(this, MainActivityReport::class.java))
                    overridePendingTransition(0,0)
                    true
                }
                R.id.nav_history -> {
             //       startActivity(Intent(this, MainActivityHistory::class.java))
                    overridePendingTransition(0,0)
                    true
                }
                R.id.nav_account -> {
              //      startActivity(Intent(this, MainActivityAccount::class.java))
                    overridePendingTransition(0,0)
                    true
                }
                else -> false
            }
        }
    }
}
