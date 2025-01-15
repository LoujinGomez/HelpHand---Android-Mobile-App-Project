package com.example.finalproject_gomez_bislumbre

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()
        emergencyButton()
        mainToEQpage()
        mainToTyphoonPage()
        mainToSmogPage()
        mainToFlashfloodPage()
        maintoHWPage()
        mainToDroughtPage()
        mainToVEPage()
        mainToSearchPage()
    }



    fun emergencyButton() {
        val emergencyButton: ImageButton = findViewById(R.id.imageButton15)
        emergencyButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:911")
            startActivity(intent)
        }
    }

    fun mainToEQpage() {
        val btntoEQ = findViewById<ImageButton>(R.id.imageButton11)
        btntoEQ.setOnClickListener{
        val i = Intent(this, earthquake1::class.java)
        startActivity(i)
        }
    }

    fun mainToTyphoonPage() {
        val btntoTyphoon = findViewById<ImageButton>(R.id.imageButton17)
        btntoTyphoon.setOnClickListener{
            val i = Intent(this, typhoon1::class.java)
            startActivity(i)
        }
    }

    fun mainToSmogPage() {
        val btntoSmog = findViewById<ImageButton>(R.id.imageButton22)
        btntoSmog.setOnClickListener{
            val i = Intent(this, smog1::class.java)
            startActivity(i)
        }
    }

    fun mainToFlashfloodPage() {
        val btntoFF = findViewById<ImageButton>(R.id.imageButton18)
        btntoFF.setOnClickListener{
            val i = Intent(this, flashfloods1::class.java)
            startActivity(i)
        }
    }

    fun maintoHWPage() {
        val btntoHW = findViewById<ImageButton>(R.id.imageButton19)
        btntoHW.setOnClickListener{
            val i = Intent(this, heatwaves1::class.java)
            startActivity(i)
        }
    }

    fun mainToVEPage() {
        val btntoVE = findViewById<ImageButton>(R.id.imageButton21)
        btntoVE.setOnClickListener{
            val i = Intent(this, volcaniceruption1::class.java)
            startActivity(i)
        }
    }

    fun mainToDroughtPage() {
        val btntoDrought = findViewById<ImageButton>(R.id.droughtbutton)
        btntoDrought.setOnClickListener {
            Log.d("MainActivity", "mainToDroughtPage executed")
            val i = Intent(this, drought1::class.java)
            startActivity(i)
        }

    }

    fun mainToSearchPage() {
        val btntoSearchPage = findViewById<ImageButton>(R.id.imageButton9)
        btntoSearchPage.setOnClickListener{
            val i = Intent(this, SearchActivity::class.java)
            startActivity(i)
        }
    }

    private fun navigateTo(activityClass: Class<*>) {
        if (this::class.java != activityClass || activityClass == MainActivity::class.java) {
            val intent = Intent(this, activityClass)
            if (activityClass != MainActivity::class.java) {
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }

            startActivity(intent)
        }
    }



    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navigateTo(MainActivity::class.java)
                    true
                }

                R.id.checklist -> {
                    navigateTo(SupplyCheckListActivity::class.java)
                    true
                }


                R.id.shop -> {
                    navigateTo(ShopActivity::class.java)
                    true
                }


                R.id.search -> {
                     navigateTo(SearchActivity::class.java)
                     true
                }
                else -> false
            }
        }
    }
}
