package com.example.semanaingenieria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.semanaingenieria.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Cargar Agenda por defecto
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AgendaFragment())
                .commit()
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.agendaFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AgendaFragment())
                        .commit()
                    true
                }
                R.id.competenciasFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, CompetenciasFragment())
                        .commit()
                    true
                }
                R.id.seminariosFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SeminariosFragment())
                        .commit()
                    true
                }
                R.id.ubicacionesFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, UbicacionesFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}

