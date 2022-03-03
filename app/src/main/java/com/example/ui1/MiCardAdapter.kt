package com.example.ui1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MiCardAdapter(val context: Context, var contactos: ArrayList<Contacto>) : RecyclerView.Adapter<MiCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = contactos[position].nombre
        holder.perfilProf.text = contactos[position].perfilProf
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nombre = itemView.findViewById<TextView>(R.id.nombre)
        var perfilProf = itemView.findViewById<TextView>(R.id.perfilProf)

        init {
            itemView.setOnClickListener {
                context.startActivity(Intent(context, Detalle::class.java).let {
                    it.putExtra("nombre", nombre.text.toString())
                    it.putExtra("perfilProf", perfilProf.text.toString())
                })
            }
        }
    }
}
