package com.example.manekelsaa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WorkerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_detail)

        val tvName = findViewById<TextView>(R.id.tvNameDetail)
        val tvSkill = findViewById<TextView>(R.id.tvSkillDetail)
        val tvPhone = findViewById<TextView>(R.id.tvPhoneDetail)
        val tvAddress = findViewById<TextView>(R.id.tvAddressDetail)
        val tvExperience = findViewById<TextView>(R.id.tvExperienceDetail)
        val tvDob = findViewById<TextView>(R.id.tvDobDetail)
        val tvRate = findViewById<TextView>(R.id.tvRateDetail)
        val tvAvailable = findViewById<TextView>(R.id.tvAvailableDetail)

        // Get data from intent
        val name = intent.getStringExtra("name")
        val skill = intent.getStringExtra("skill")
        val phone = intent.getStringExtra("phone")
        val address = intent.getStringExtra("address")
        val experience = intent.getStringExtra("experience")
        val dob = intent.getStringExtra("dob")
        val dailyRate = intent.getStringExtra("dailyRate")
        val available = intent.getBooleanExtra("available", false)

        // Set data
        tvName.text = "Name: $name"
        tvSkill.text = "Skill: $skill"
        tvPhone.text = "Phone: $phone"
        tvAddress.text = "Address: $address"
        tvExperience.text = "Experience: $experience"
        tvDob.text = "DOB: $dob"
        tvRate.text = "Daily Rate: $dailyRate"
        tvAvailable.text = "Available"
    }
}