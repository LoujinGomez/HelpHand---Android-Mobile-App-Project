package com.example.finalproject_gomez_bislumbre

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class heatwaves1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heatwaves1)
        setupBottomNavigation()
    }

    fun MovetoHW2(view: View) {
        val hw1 = Intent(this, heatwaves2::class.java)
        startActivity(hw1)
    }

    fun HWtoMain(view: View){
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