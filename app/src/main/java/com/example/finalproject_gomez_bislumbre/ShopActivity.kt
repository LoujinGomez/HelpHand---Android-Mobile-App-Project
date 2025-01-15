package com.example.finalproject_gomez_bislumbre

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ShopActivity : AppCompatActivity() {
    private var selectedItemId: Int = R.id.shop
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        setupBottomNavigation()

        val openDialog = findViewById<ImageButton>(R.id.btngauzepads)
        openDialog.setOnClickListener {
            val message = ""
            showCustomDialogBox(message)
        }

        val openDialog2 = findViewById<ImageButton>(R.id.btnbatteries)
        openDialog2.setOnClickListener {
            val message = ""
            showCustomDialogBox2(message)
        }

        val openDialog3 = findViewById<ImageButton>(R.id.btnthermometer)
        openDialog3.setOnClickListener {
            val message = ""
            showCustomDialogBox3(message)
        }

        val openDialog4 = findViewById<ImageButton>(R.id.btnflashlight)
        openDialog4.setOnClickListener {
            val message = ""
            showCustomDialogBox4(message)
        }

        val openDialog5 = findViewById<ImageButton>(R.id.btnbandages)
        openDialog5.setOnClickListener {
            val message = ""
            showCustomDialogBox5(message)
        }


    }

    private fun showCustomDialogBox(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.activity_shop_gauze_pads)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        val quantityInput = dialog.findViewById<TextView>(R.id.editTextQuantity)
        val calculateButton = dialog.findViewById<Button>(R.id.btnDone)
        val calculatedPrice = dialog.findViewById<TextView>(R.id.gauzepadsCalculatedPrice)


        calculateButton.setOnClickListener {

            val quantity = quantityInput.text.toString().toIntOrNull() ?: 0
            val totalAmount = 3.40 * quantity
            calculatedPrice.text = "Total: ₱${String.format("%.2f", totalAmount)}"



        }

        dialog.show()
    }



    private fun showCustomDialogBox2(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.activity_shop_batteries)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val quantityInput = dialog.findViewById<TextView>(R.id.editTextQuantityBattery)
        val calculateButton = dialog.findViewById<Button>(R.id.btnDone)
        val calculatedPrice = dialog.findViewById<TextView>(R.id.batteryCalculatedPrice)

        calculateButton.setOnClickListener {

            val quantity = quantityInput.text.toString().toIntOrNull() ?: 0

            val totalAmount = 299.99 * quantity

            calculatedPrice.text = "Total: ₱${String.format("%.2f", totalAmount)}"



        }

        dialog.show()
    }




    private fun showCustomDialogBox3(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.activity_shop_thermometers)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val quantityInput = dialog.findViewById<TextView>(R.id.editTextQuantityThermometer)
        val calculateButton = dialog.findViewById<Button>(R.id.btnDone)
        val calculatedPrice = dialog.findViewById<TextView>(R.id.thermometerCalculatedPrice)

        calculateButton.setOnClickListener {

            val quantity = quantityInput.text.toString().toIntOrNull() ?: 0
            val totalAmount = 699.99 * quantity
            calculatedPrice.text = "Total: ₱${String.format("%.2f", totalAmount)}"



        }

        dialog.show()
    }

    private fun showCustomDialogBox4(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.activity_shop_flashlights)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val quantityInput = dialog.findViewById<TextView>(R.id.editTextQuantityFlashlight)
        val calculateButton = dialog.findViewById<Button>(R.id.btnDone)
        val calculatedPrice = dialog.findViewById<TextView>(R.id.textViewFlashlightCalculatedPrice)

        calculateButton.setOnClickListener {

            val quantity = quantityInput.text.toString().toIntOrNull() ?: 0
            val totalAmount = 499.00 * quantity
            calculatedPrice.text = "Total: ₱${String.format("%.2f", totalAmount)}"



        }



        dialog.show()
    }

    private fun showCustomDialogBox5(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.activity_shop_bandages)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val quantityInput = dialog.findViewById<TextView>(R.id.editTextQuantityBandages)
        val calculateButton = dialog.findViewById<Button>(R.id.btnDone)
        val calculatedPrice = dialog.findViewById<TextView>(R.id.textViewCalculatedPriceBandages)

        calculateButton.setOnClickListener {

            val quantity = quantityInput.text.toString().toIntOrNull() ?: 0


            val totalAmount = 7.50 * quantity


            calculatedPrice.text = "Total: ₱${String.format("%.2f", totalAmount)}"


        }



        dialog.show()
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
        bottomNav.selectedItemId = R.id.shop
    }




    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavView)


        // Set the initially selected item
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
                 selectedItemId = R.id.shop
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
