package com.example.finalproject_gomez_bislumbre

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class earthquake2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_earthquake2)
        setupBottomNavigation()
    }

    fun eqtoWebsite1(view: View) {
        val url =
            "https://calacademy.org/explore-science/how-to-prepare-for-an-earthquake" // Replace this with your desired URL
        val eq2 = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(eq2)
    }

    fun eqtoWebsite2(view: View) {
        val url =
            "https://www.youtube.com/watch?v=ea1RJUOiNfQ" // Replace this with your desired URL
        val eq3 = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(eq3)

    }

    fun movetoEQ1(view: View) {
        val eq4 = Intent(this, earthquake1::class.java)
        startActivity(eq4)

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


        // Set the initially selected item
        //bottomNav.selectedItemId = selectedItemId



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