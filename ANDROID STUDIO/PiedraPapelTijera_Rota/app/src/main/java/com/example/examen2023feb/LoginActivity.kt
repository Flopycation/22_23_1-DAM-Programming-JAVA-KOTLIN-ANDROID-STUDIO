package com.example.examen2023feb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.examen2023feb.databinding.ActivityLoginBinding


/**
 * Created by sergi on 28/03/2022.
 */

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bt_entrar = findViewById<Button>(R.id.login_btn_login)
        bt_entrar.setOnClickListener {
            val usertext = binding.loginEdUser.text.toString()
            val passtext = binding.loginEdPass.toString()
            compruebaLogin(usertext, passtext)
        }


        //todo autologin para testear
        //abrirMainActivity("Usuario")
    }

    private fun compruebaLogin(user: String, pass: String) {

        if (user.isEmpty()) {
            binding.loginEdUser.error = "El campo está vacío"
            return
        }
        if (pass.isEmpty()) {
            binding.loginEdPass.error = "El campo está vacío"
            return
        }

        if (pass != "12345") {
            binding.loginEdPass.error = "Contraseña incorrecta"
            return
        }

        abrirMainActivity(user)
    }

    private fun abrirMainActivity(usuario: String) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}