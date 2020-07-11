package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.activitylifecycle.R.id.btnLogin

class LoginActivity : AppCompatActivity(){


    lateinit var etMobileNumber:EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin:Button
    lateinit var txtForgotPassword:TextView
    lateinit var txtRegister:TextView
    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("tony","steve","bruce","thanos")

    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)

        if (isLoggedIn){
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener {

            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameofAvenger = "Avenger"
            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            if ((mobileNumber == validMobileNumber)) {

                if (password==validPassword[0]){


                    nameofAvenger = "Iron Man"
                    savepreferences(nameofAvenger)
                    startActivity(intent)


                }else if (password==validPassword[1]){


                    nameofAvenger = "Captain America"
                    savepreferences(nameofAvenger)
                    startActivity(intent)


                }else if (password==validPassword[2]){


                    nameofAvenger = "The Hulk"
                    savepreferences(nameofAvenger)
                    startActivity(intent)

                }else if (password==validPassword[3]){


                    nameofAvenger = "The Avengers"
                    savepreferences(nameofAvenger)
                    startActivity(intent)

                }



            } else {
                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savepreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
