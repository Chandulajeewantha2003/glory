package com.example.fitness_glowry

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivityHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_history)

        // Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Bottom navigation logic
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.nav_history // Mark "history" as selected

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivityHome::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_discover -> {
                    val intent = Intent(this, MainActivityDiscover::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_report -> {
                     val intent = Intent(this, MainActivityReport::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    finish()

                    true
                }

                R.id.nav_history -> {
                  //done
                    true
                }

                R.id.nav_profile -> {
                     val intent = Intent(this, MainActivityProfile::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                else -> false
            }
        }
    }
}
