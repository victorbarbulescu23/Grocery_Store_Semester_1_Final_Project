package com.example.loginscreenexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var loginText: EditText
    lateinit var passwordText: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginText = findViewById(R.id.username_input)
        passwordText = findViewById(R.id.password_input)
        loginButton = findViewById(R.id.enter_button)

        loginButton.setOnClickListener {
            when(checkLogin(loginText.text.toString(), passwordText.text.toString())){

                LoginSuccess.Login -> {
                    Toast.makeText(this@MainActivity, getString(R.string.error_login), Toast.LENGTH_SHORT).show()
                    loginText.error = ("Invalid Username")
                    loginText.requestFocus()
                    loginText.selectAll()
                }
                LoginSuccess.Password -> {
                    Toast.makeText(applicationContext, getString(R.string.error_password), Toast.LENGTH_SHORT).show()
                    passwordText.error = ("Invalid Password")
                    passwordText.requestFocus()
                    passwordText.selectAll()
                }
                LoginSuccess.Success -> {
                    Toast.makeText(applicationContext, getString(R.string.success), Toast.LENGTH_SHORT).show()
                    loginText.clearAnimation()
                    passwordText.clearAnimation()

                    Intent(this@MainActivity, InputActivity::class.java).also {
                        startActivity(it)
                    }
                }



            }


        }


    }
}

fun checkLogin(login: String, password: String): LoginSuccess{
    val holdLogin = "Victor"
    val holdPassword = "12345"

    if (holdLogin != login){
        return LoginSuccess.Login
    }

    if (holdPassword != password){
        return LoginSuccess.Password
    }

    return LoginSuccess.Success
}

enum class LoginSuccess (){
    Login,
    Password,
    Success

}