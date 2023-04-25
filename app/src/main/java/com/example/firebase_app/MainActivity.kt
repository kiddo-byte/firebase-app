package com.example.firebase_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var datatxt:EditText
    private lateinit var entry_button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datatxt = findViewById(R.id.Entertxt)
        entry_button = findViewById(R.id.btnentry)

        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.reference

        entry_button.setOnClickListener {

            var user_data = datatxt.text.toString().trim()

            databaseRef.setValue(user_data)

            Toast.makeText(this, "User data saved successfully", Toast.LENGTH_SHORT).show()
        }
    }
}