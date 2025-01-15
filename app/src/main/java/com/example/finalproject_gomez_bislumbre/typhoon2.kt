package com.example.finalproject_gomez_bislumbre

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class typhoon2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typhoon2)
        setupBottomNavigation()
    }

    fun typhoontoWebsite1(view: View) {
        val url = "https://www.cdc.gov/disasters/hurricanes/before.html" // Replace this with your desired URL
        val t2 = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(t2)
    }

    fun MovetoTyphoon1(view: View) {
        val t3 = Intent(this, typhoon1::class.java)
        startActivity(t3)
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