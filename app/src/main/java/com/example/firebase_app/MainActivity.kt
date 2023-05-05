package com.example.firebase_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var maketxt:EditText
    private lateinit var viewcars_button:Button
    private lateinit var modeltxt:EditText
    private lateinit var carphoto_button:Button
    private lateinit var cardata_button:Button
    private lateinit var pricetxt:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maketxt = findViewById(R.id.carmaketxt)
        viewcars_button = findViewById(R.id.btnviewcars)
        modeltxt = findViewById(R.id.carmodeltxt)
        carphoto_button = findViewById(R.id.btncarphoto)
        cardata_button = findViewById(R.id.btncardata)
        pricetxt = findViewById(R.id.carpricetxt)

        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.getReference("cars")

        viewcars_button.setOnClickListener {

            var viewcars = Intent(this,ViewCarsActivity::class.java)
            startActivity(viewcars)

        }


        cardata_button.setOnClickListener {

            var carmake = maketxt.text.toString().trim()
            var carmodel = modeltxt.text.toString().trim()
            var carprice = pricetxt.text.toString().trim()

                var id = System.currentTimeMillis().toString()

                var ref = database.getReference("cars")

            if (carmake.isEmpty() || carmodel.isEmpty() || carprice.isEmpty()) {

                Toast.makeText(
                    this,
                    "Input required,cannot submit an empty field",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                var usercar = Car(carmake, carmodel, carprice, id)

                var ref = FirebaseDatabase.getInstance().getReference().child("cars")

                ref.setValue(usercar).addOnCompleteListener {

                    if (it.isSuccessful) {

                        Toast.makeText(this, "Car data uploaded successfully", Toast.LENGTH_SHORT)
                            .show()

                    } else {

                        Toast.makeText(this, "Error!Failed to upload car data", Toast.LENGTH_SHORT)
                            .show()

                    }
                }
            }
        }
    }
}