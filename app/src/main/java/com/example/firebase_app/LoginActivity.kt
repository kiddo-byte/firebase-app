package com.example.firebase_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var edtemail:EditText
    private lateinit var edtpass:EditText
    private lateinit var loginbutton:Button
    private lateinit var registerbutton:Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtemail = findViewById(R.id.emailtxt)
        edtpass = findViewById(R.id.passtxt)
        loginbutton = findViewById(R.id.btnlogin)
        registerbutton = findViewById(R.id.btnregister)

        auth = FirebaseAuth.getInstance()

        registerbutton.setOnClickListener {

            var gotoreg =Intent(this, RegisterActivity::class.java)
            startActivity(gotoreg)
        }

        loginbutton.setOnClickListener {

            var email = edtemail.text.toString().trim()
            var password = edtpass.text.toString().trim()

            if(email.isEmpty() || password.isEmpty()){

                Toast.makeText(this, "Input required,cannot submit an empty field", Toast.LENGTH_SHORT).show()

            }else{

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){

                    if(it.isSuccessful){

                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                        var gotomain = Intent(this,MainActivity::class.java)
                        startActivity(gotomain)
                        finish()

                    }else{

                        Toast.makeText(this, "Error!Failed to login", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }
}