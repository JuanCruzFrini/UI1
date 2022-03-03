package com.example.ui1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Detalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle)
        title = "Detalle:"

        val nombre = findViewById<TextView>(R.id.nombre)
        nombre.text = intent.extras?.getString("nombre").toString()

        val perfil = findViewById<TextView>(R.id.perfilProf)
        perfil.text = intent.extras?.getString("perfilProf").toString()
    }

}
