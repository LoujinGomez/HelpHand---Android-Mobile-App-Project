package com.example.finalproject_gomez_bislumbre

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button

class supplychecklist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplychecklist)

        val openDialog = findViewById<Button>(R.id.btnEssentials)
        val openDialog2 = findViewById<Button>(R.id.btnSupplies)
        val openDialog3 = findViewById<Button>(R.id.btnComms)
        val openDialog4 = findViewById<Button>(R.id.btnShelter)
        val openDialog5 = findViewById<Button>(R.id.btnPersonal)
        val openDialog6 = findViewById<Button>(R.id.btnTools)

        openDialog.setOnClickListener {
            val message = ""
            showCustomDialogBox(message)
        }

        openDialog2.setOnClickListener {
            val message = ""
            showCustomDialogBox2(message)
        }

        openDialog3.setOnClickListener {
            val message = ""
            showCustomDialogBox3(message)
        }

        openDialog4.setOnClickListener {
            val message = ""
            showCustomDialogBox4(message)
        }

        openDialog5.setOnClickListener {
            val message = ""
            showCustomDialogBox5(message)
        }

        openDialog6.setOnClickListener {
            val message = ""
            showCustomDialogBox6(message)
        }

    }

    private fun showCustomDialogBox(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistessentials)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnDone = findViewById<Button>(R.id.btnDone)

        /*        btnDone.setOnClickListener{
                    dialog.dismiss()
                  */

        dialog.show()
    }

    private fun showCustomDialogBox2(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistmedicalsupplies)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
    }

    private fun showCustomDialogBox3(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistmedicalsupplies)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
    }

    private fun showCustomDialogBox4(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistmedicalsupplies)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
    }

    private fun showCustomDialogBox5(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistmedicalsupplies)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
    }

    private fun showCustomDialogBox6(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checklistmedicalsupplies)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
    }


}

