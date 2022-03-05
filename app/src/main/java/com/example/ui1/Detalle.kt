package com.example.ui1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Detalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle)
        title = "Detalle:"

        val nombre = findViewById<TextView>(R.id.nombre)
        nombre.text = intent.extras?.getString("nombre").toString()

        val perfil = findViewById<TextView>(R.id.perfilProf)
        perfil.text = intent.extras?.getString("perfilProf").toString()

        val imagen = findViewById<ImageView>(R.id.img_item)
        val url = intent.extras!!.getString("url").toString()

        Glide
            .with(this)
            .load(url/*"https://lastfm.freetls.fastly.net/i/u/770x0/1e1b90d26052b292fe3fab2fab9dd0d9.jpg#1e1b90d26052b292fe3fab2fab9dd0d9"*/)
            .centerCrop()
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imagen)
    }

}
