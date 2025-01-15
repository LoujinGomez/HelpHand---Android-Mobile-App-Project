package com.example.finalproject_gomez_bislumbre

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.CheckBox
import com.google.android.material.bottomnavigation.BottomNavigationView

class SupplyCheckListActivity : AppCompatActivity() {


    private var selectedItemId: Int = R.id.checklist
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplychecklist)
        setupBottomNavigation()



        setupBottomNavigation()

        val openDialog = findViewById<Button>(R.id.btnEssentials)
        val openDialog2 = findViewById<Button>(R.id.btnSupplies)
        val openDialog3 = findViewById<Button>(R.id.btnComms)
        val openDialog4 = findViewById<Button>(R.id.btnShelter)
        val openDialog5 = findViewById<Button>(R.id.btnPersonal)
        val openDialog6 = findViewById<Button>(R.id.btnTools)

        openDialog.setOnClickListener {
            val message = ""
            showEssentialsDialogBox(message)
        }

        openDialog2.setOnClickListener {
            val message = ""
            showSuppliesDialogBox(message)
        }

        openDialog3.setOnClickListener {
            val message = ""
            showCommsDialogBox(message)
        }

        openDialog4.setOnClickListener {
            val message = ""
            showShelterDialogBox(message)
        }

        openDialog5.setOnClickListener {
            val message = ""
            showPersonalDialogBox(message)
        }

        openDialog6.setOnClickListener {
            val message = ""
            showToolsDialogBox(message)
        }


    }

    private fun showEssentialsDialogBox(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistessentials)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val water = dialog.findViewById<CheckBox>(R.id.cbWater)
        val food = dialog.findViewById<CheckBox>(R.id.cbNonPerishableFoods)
        val flashlight = dialog.findViewById<CheckBox>(R.id.cbFlashlights)
        val firstAidKit = dialog.findViewById<CheckBox>(R.id.cbKit)
        val mtKnife = dialog.findViewById<CheckBox>(R.id.cbKnife)
        val blankets = dialog.findViewById<CheckBox>(R.id.cbBlankets)
        val clothing = dialog.findViewById<CheckBox>(R.id.cbClothing)


        val btnDone = dialog.findViewById<Button>(R.id.btnDone)

        loadCheckboxState(water, "cbWaterState")
        loadCheckboxState(food, "cbFoodState")
        loadCheckboxState(flashlight, "cbFlashlightState")
        loadCheckboxState(firstAidKit, "cbFirstAidKitState")
        loadCheckboxState(mtKnife, "cbKnifeState")
        loadCheckboxState(blankets, "cbBlanketsState")
        loadCheckboxState(clothing, "cbClothingState")



        btnDone.setOnClickListener {
            saveCheckboxState(water, "cbWaterState")
            saveCheckboxState(food, "cbFoodState")
            saveCheckboxState(firstAidKit, "cbFirstAidKitState")
            saveCheckboxState(flashlight, "cbFlashlightState")
            saveCheckboxState(mtKnife, "cbKnifeState")
            saveCheckboxState(blankets, "cbBlanketsState")
            saveCheckboxState(clothing, "cbClothingState")

            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showSuppliesDialogBox(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistmedicalsupplies)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val medication = dialog.findViewById<CheckBox>(R.id.cbPrescription)
        val personalHygiene = dialog.findViewById<CheckBox>(R.id.cbHygiene)
        val firstAidManual = dialog.findViewById<CheckBox>(R.id.cbFirstAidManuals)

        val btnDone = dialog.findViewById<Button>(R.id.btnDone)

        loadCheckboxState(medication, "cbMedicationState")
        loadCheckboxState(personalHygiene, "cbPersonalHygieneState")
        loadCheckboxState(firstAidManual, "cbFirstAidManualState")

        btnDone.setOnClickListener {

            saveCheckboxState(medication, "cbMedicationState")
            saveCheckboxState(personalHygiene, "cbPersonalHygieneState")
            saveCheckboxState(firstAidManual, "cbFirstAidManualState")


            dialog.dismiss()
        }

        dialog.show()
    }


    private fun showCommsDialogBox(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistcommunication)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val radio = dialog.findViewById<CheckBox>(R.id.cbRadio)
        val whistle = dialog.findViewById<CheckBox>(R.id.cbWhistle)
        val localMaps = dialog.findViewById<CheckBox>(R.id.cbLocalMaps)

        val btnDone = dialog.findViewById<Button>(R.id.btnDone)

        loadCheckboxState(radio, "cbRadioState")
        loadCheckboxState(whistle, "cbWhistleState")
        loadCheckboxState(localMaps, "cbLocalMapsState")

        btnDone.setOnClickListener {

            saveCheckboxState(radio, "cbRadioState")
            saveCheckboxState(whistle, "cbWhistleState")
            saveCheckboxState(localMaps, "cbLocalMapsState")

            dialog.dismiss()
        }

        dialog.show()
    }


    private fun showShelterDialogBox(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistshelter)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tarpOrEmergencyShelter = dialog.findViewById<CheckBox>(R.id.cbTarp)
        val handWarmers = dialog.findViewById<CheckBox>(R.id.cbHandWarmers)

        loadCheckboxState(tarpOrEmergencyShelter, "cbTarpOrEmergencyShelterState")
        loadCheckboxState(handWarmers, "cbWhistleState")

        val btnDone = dialog.findViewById<Button>(R.id.btnDone)

        btnDone.setOnClickListener {

            saveCheckboxState(tarpOrEmergencyShelter, "cbTarpOrEmergencyShelterState")
            saveCheckboxState(handWarmers, "cbWhistleState")
            dialog.dismiss()
        }

        dialog.show()
    }


    private fun showPersonalDialogBox(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistpersonal)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val identification = dialog.findViewById<CheckBox>(R.id.cbIdentification)
        val emergencyContactNumber = dialog.findViewById<CheckBox>(R.id.cbEmergencyInformation)

        loadCheckboxState(identification, "cbIdentificationState")
        loadCheckboxState(emergencyContactNumber, "cbEmergencyContactNumberState")


        val btnDone = dialog.findViewById<Button>(R.id.btnDone)



        btnDone.setOnClickListener {
            saveCheckboxState(identification, "cbIdentificationState")
            saveCheckboxState(emergencyContactNumber, "cbEmergencyContactNumberState")
            dialog.dismiss()
        }

        dialog.show()
    }


    private fun showToolsDialogBox(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklisttools)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val ductTape = dialog.findViewById<CheckBox>(R.id.cbDuctTape)
        val multipurposeTool = dialog.findViewById<CheckBox>(R.id.cbMultipurpose)

        val btnDone = dialog.findViewById<Button>(R.id.btnDone)

        loadCheckboxState(ductTape, "cbDuctTapeState")
        loadCheckboxState(multipurposeTool, "cbMultiPurposeToolState")

        btnDone.setOnClickListener {

            saveCheckboxState(ductTape, "cbDuctTapeState")
            saveCheckboxState(multipurposeTool, "cbMultiPurposeToolState")
            dialog.dismiss()
        }

        dialog.show()
    }


    private fun saveCheckboxState(checkBox: CheckBox, key: String) {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, checkBox.isChecked)
        editor.apply()
    }

    private fun loadCheckboxState(checkBox: CheckBox, key: String) {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        checkBox.isChecked = sharedPreferences.getBoolean(key, false)
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
        bottomNav.selectedItemId = R.id.checklist
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
                    true
               }

                else -> false
            }
        }
    }


}