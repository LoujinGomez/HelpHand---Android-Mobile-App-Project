package com.example.finalproject_gomez_bislumbre

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity:AppCompatActivity() {
    private var selectedItemId: Int = R.id.search
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setupBottomNavigation()

        val databaseHandler = DatabaseHandler(this)
        databaseHandler.clearDatabase()
        databaseHandler.insertSampleDisasters()


        val listView = findViewById<ListView>(R.id.disasterListView)
        val disasterAdapter = MyDisasterListAdapter(this, emptyList())



        listView.adapter = disasterAdapter

        // Set up item click listener for ListView
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedDisaster = disasterAdapter.getItem(position) as NaturalDisastersModelClass
            navigateToDetailPage(selectedDisaster)

        }


        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Update search results dynamically based on the user input
                val results = databaseHandler.searchDisasters(newText.orEmpty())
                disasterAdapter.updateData(results)
                // Update search results dynamically based on the user input
                if (newText.isNullOrEmpty()) {
                    // Don't perform search if the query is empty
                    disasterAdapter.updateData(emptyList())
                } else {
                    // Perform search and update the adapter with the results
                    val results = databaseHandler.searchDisasters(newText)
                    disasterAdapter.updateData(results)
                }
                return true

            }
        })


    }


    private fun navigateToDetailPage(disaster: NaturalDisastersModelClass) {

        val intent: Intent = when (disaster.disasterType) {
            "Earthquake" -> Intent(this, earthquake1::class.java)
            "Flash floods" -> Intent(this, flashfloods1::class.java)
            "Typhoon" -> Intent(this, typhoon1::class.java)
            "Drought" -> Intent(this, drought1::class.java)
            "Heatwaves" -> Intent(this, heatwaves1::class.java)
            "Smog" -> Intent(this, smog1::class.java)
            "Volcanic Eruption" -> Intent(this, volcaniceruption1::class.java)

            "Earthquake Preparedness and First Aid" -> Intent(this, earthquake2::class.java)
            "Flash floods Preparedness Tips" -> Intent(this, flashfloods2::class.java)
            "Typhoon Preparedness Tips and First Aid Information" -> Intent(this, typhoon2::class.java)
            "Drought First Aid Information" -> Intent(this, drought2::class.java)
            "Heatwaves Preparedness Tips and First Aid Information" -> Intent(this, heatwaves2::class.java)
            "Smog Inhalation Symptoms and First Aid Information" -> Intent(this, smog2::class.java)
            "Volcanic Eruption Preparedness Tips" -> Intent(this, volcaniceruption2::class.java)



            else -> {
                Intent(this, MainActivity::class.java)
            }


        }
        startActivity(intent)

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

    override fun onResume() {
        super.onResume()

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNav.selectedItemId = R.id.search
    }




    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavView)


        bottomNav.selectedItemId = selectedItemId



        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navigateTo(MainActivity::class.java)
                    selectedItemId = R.id.home
                    true
                }

                R.id.checklist -> {
                    navigateTo(SupplyCheckListActivity::class.java)
                    selectedItemId = R.id.checklist
                    true
                }



                R.id.shop -> {
                    navigateTo(ShopActivity::class.java)
                    true
                }

                R.id.search -> {
                    navigateTo(SearchActivity::class.java)
                    selectedItemId = R.id.search
                    true
                }

                else -> false
            }
        }
    }
}