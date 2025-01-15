package com.example.finalproject_gomez_bislumbre

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class volcaniceruption1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volcaniceruption1)
        setupBottomNavigation()
    }

    fun MoveToVE2(view: View) {
        val ve1 = Intent(this, volcaniceruption2::class.java)
        startActivity(ve1)
    }

    fun VEtoWebsite1(view: View) {
        val url = "https://www.youtube.com/watch?v=UFz2fLrqZuk" // Replace this with your desired URL
        val ve2 = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(ve2)
    }

    fun VEtoMain(view: View){
        val i = Intent (this, MainActivity::class.java)
        startActivity(i)
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
