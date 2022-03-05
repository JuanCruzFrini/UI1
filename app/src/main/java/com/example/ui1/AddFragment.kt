package com.example.ui1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add)
        title = "Registro de personal"

        supportActionBar.let {
            it!!.setHomeButtonEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }

        val nombre = findViewById<EditText>(R.id.nombre)
        val perfil = findViewById<EditText>(R.id.perfilProf)
        val url = findViewById<EditText>(R.id.urlimg)

        findViewById<Button>(R.id.btnRegistrar).setOnClickListener {
            if (nombre.text.isNullOrEmpty() || perfil.text.isNullOrEmpty()){
                Toast.makeText(this, "Debes completar todos los campos para poder continuar", Toast.LENGTH_SHORT).show()
            } else {
                val db = DbEmpleados(this)
                db.addEmpleado(nombre.text.toString(), perfil.text.toString(), url.text.toString())
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

}