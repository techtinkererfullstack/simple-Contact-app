package com.example.simplecontactapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplecontactapp.databinding.ActivityHomeBinding

class ActivityHome : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }


        db = AppDatabase.getDatabase(this)
        loadData()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)



    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        val list = db.noteDao().getAllNotes()
        val adapter = NoteAdapter(list)
        binding.recyclerView.adapter = adapter

    }
}