package com.example.simplecontactapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplecontactapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding

    private lateinit var db: AppDatabase
    private var contactId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //getDatabase function called
        db = AppDatabase.getDatabase(this)
        contactId = intent.getIntExtra("id", -1)


        if (contactId != -1) {
            binding.nameET.setText(intent.getStringExtra("name"))
            binding.mobileET.setText(intent.getStringExtra("mobile"))
        }

        binding.button.setOnClickListener {
            val name = binding.nameET.text.toString()
            val mobile = binding.mobileET.text.toString()

            if (contactId== -1){
                //insert
                val contact = Contact(name = name, mobile = mobile)
                db.contactDao().insert(contact)

            }else{
                //Update
                val contact =Contact(id = contactId, name = name, mobile = mobile)
                db.contactDao().update(contact)
            }
            Toast.makeText(this@AddActivity, "data saved successfully", Toast.LENGTH_SHORT).show()

            finish()


        }


    }
}