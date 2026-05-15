package com.example.manekelsaa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WorkerAdapter
    private lateinit var workerList: MutableList<Worker>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddWorker = findViewById<Button>(R.id.btnAddWorker)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        workerList = mutableListOf()

        adapter = WorkerAdapter(workerList)

        recyclerView.adapter = adapter

        btnAddWorker.setOnClickListener {

            val intent = Intent(this, AddWorkerActivity::class.java)
            startActivity(intent)
        }

        val database = FirebaseDatabase.getInstance()
        val workerRef = database.getReference("workers")

        workerRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                workerList.clear()

                for (workerSnapshot in snapshot.children) {

                    val worker =
                        workerSnapshot.getValue(Worker::class.java)

                    if (worker != null) {
                        workerList.add(worker)
                    }
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}