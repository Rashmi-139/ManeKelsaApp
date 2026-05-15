package com.example.manekelsaa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class AddWorkerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_worker)

        val etName = findViewById<EditText>(R.id.etName)
        val etSkill = findViewById<EditText>(R.id.etSkill)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etExperience = findViewById<EditText>(R.id.etExperience)
        val etDob = findViewById<EditText>(R.id.etDob)
        val etDailyRate = findViewById<EditText>(R.id.etDailyRate)
        val btnSave = findViewById<Button>(R.id.btnSave)


        val database = FirebaseDatabase.getInstance()
        val workerRef = database.getReference("workers")

        btnSave.setOnClickListener {
            if (etName.text.toString().isEmpty() ||
                etSkill.text.toString().isEmpty() ||
                etPhone.text.toString().isEmpty()) {

                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val worker = Worker(
                etName.text.toString(),
                etSkill.text.toString(),
                etPhone.text.toString(),
                etAddress.text.toString(),
                etExperience.text.toString(),
                etDob.text.toString(),
                etDailyRate.text.toString(),

            )

            workerRef.push().setValue(worker)
                .addOnSuccessListener {
                    Toast.makeText(this, "Worker Saved", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
        }
    }
}