package com.example.musicapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicapp.fragments.fragment_login
import com.google.android.material.bottomnavigation.BottomNavigationView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottomNavigationView_Login)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.btn_navigation_login_login -> {
                    supportFragmentManager.beginTransaction()
                        .add(R.id.fragmentContainerLogin, fragment_login::class.java, null)
                        .commit()
                    true
                }
                R.id.btn_navigation_login_register -> {

                    true
                }
                R.id.btn_navigation_login_help -> {
                    true
                }
                else -> false
            }
        }
    }
}