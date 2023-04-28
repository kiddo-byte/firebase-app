package com.example.firebase_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

     lateinit var edtname:EditText
     lateinit var edtmail:EditText
     lateinit var edtpassword:EditText
     lateinit var createbutton:Button
     lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtname = findViewById(R.id.nametext)
        edtmail = findViewById(R.id.emailtext)
        edtpassword = findViewById(R.id.passwordtext)
        createbutton = findViewById(R.id.btncreate)

        auth = FirebaseAuth.getInstance()

        createbutton.setOnClickListener {

          var name = edtname.text.toString().trim()
          var email = edtmail.text.toString().trim()
          var password = edtpassword.text.toString().trim()

          if(name.isEmpty() || email.isEmpty() || password.isEmpty())  {

              Toast.makeText(this, "Input required,cannot submit an empty field", Toast.LENGTH_SHORT).show()

          }else{

              auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener() {

                  if (it.isSuccessful) {

                      Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()

                      var gotologin = Intent(this, LoginActivity::class.java)
                      startActivity(gotologin)

                  } else {

                      Toast.makeText(this, "Error!Failed to create user", Toast.LENGTH_SHORT).show()
                  }
              }
          }
        }

    }
}