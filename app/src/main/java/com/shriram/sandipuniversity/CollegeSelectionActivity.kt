package com.shriram.sandipuniversity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CollegeSelectionActivity : AppCompatActivity() {

    companion object {
        const val PREF_NAME = "CollegePrefs"
        const val SELECTED_COLLEGE = "selected_college"
        const val COLLEGE_NASHIK = "nashik"
        const val COLLEGE_SIJOUL = "sijoul"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_college_selection)

        // Check if college is already selected
        val prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val selectedCollege = prefs.getString(SELECTED_COLLEGE, null)
        if (selectedCollege != null) {
            // If college is already selected, go to main activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        val radioGroup = findViewById<RadioGroup>(R.id.collegeRadioGroup)
        val continueButton = findViewById<Button>(R.id.continueButton)

        continueButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Please select your college", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val radioButton = findViewById<RadioButton>(selectedId)
            val college = when (radioButton.id) {
                R.id.nashikRadio -> COLLEGE_NASHIK
                R.id.sijoulRadio -> COLLEGE_SIJOUL
                else -> COLLEGE_NASHIK
            }

            // Save selection to SharedPreferences
            prefs.edit().putString(SELECTED_COLLEGE, college).apply()

            // Navigate to MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
} 