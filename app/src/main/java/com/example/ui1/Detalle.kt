package com.example.ui1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Detalle : AppCompatActivity() {

    var id = 0
    var cambio = false

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle)
        title = "Detalle:"

        id = if (savedInstanceState == null){
            intent.extras?.getInt("ID") ?: 1
        } else {
            savedInstanceState.getSerializable("ID") as Int
        }

        val dbEmpleados = DbEmpleados(this)
        val empleado = dbEmpleados.verContacto(id)

        val nombre = findViewById<EditText>(R.id.nombre)
        nombre.setText(empleado!!.nombre)

        val perfil = findViewById<EditText>(R.id.perfilProf)
        perfil.setText(empleado.perfilProf)

        val imagen = findViewById<ImageView>(R.id.img_item)
        val url = empleado.imgurl

        val urltxt = findViewById<EditText>(R.id.img_url)
        urltxt.setText(url)

        Glide
            .with(this)
            .load(url)
            .centerCrop()
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground).error("https://pbs.twimg.com/profile_images/794633494794272768/KhJpT9pP_400x400.jpg")
            .into(imagen)

        val editarbtn = findViewById<ImageButton>(R.id.editarbtn)
        val guardarbtn = findViewById<ImageButton>(R.id.guardarbtn)

        val verurl = findViewById<Button>(R.id.verurl)
        val desver = findViewById<Button>(R.id.desverurl)

        editarbtn.setOnClickListener {
            perfil.isEnabled = true
            nombre.isEnabled = true
            urltxt.isEnabled = true
            urltxt.visibility = View.VISIBLE
            editarbtn.visibility = View.GONE
            guardarbtn.visibility = View.VISIBLE
        }

        guardarbtn.setOnClickListener {
            dbEmpleados.editEmpleado(id, nombre.text.toString(), perfil.text.toString(), urltxt.text.toString())
            cambio = true
            perfil.isEnabled = false
            nombre.isEnabled = false
            urltxt.isEnabled = false
            urltxt.visibility = View.GONE
            editarbtn.visibility = View.VISIBLE
            guardarbtn.visibility = View.GONE
        }

        verurl.setOnClickListener {
            urltxt.visibility = View.VISIBLE
            verurl.visibility = View.GONE
            desver.visibility = View.VISIBLE
        }

        desver.setOnClickListener {
            urltxt.visibility = View.GONE
            verurl.visibility = View.VISIBLE
            desver.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        if (cambio){
            startActivity(Intent(this, MainActivity::class.java).putExtra("cambio", true))
        }
        super.onBackPressed()
    }
}
