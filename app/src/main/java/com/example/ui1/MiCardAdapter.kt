package com.example.ui1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

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

        Glide
            .with(context)
            .load("https://lastfm.freetls.fastly.net/i/u/770x0/1e1b90d26052b292fe3fab2fab9dd0d9.jpg#1e1b90d26052b292fe3fab2fab9dd0d9"/*contactos[position].imgurl*/)
            .placeholder(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .circleCrop()
            .into(holder.img)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nombre = itemView.findViewById<TextView>(R.id.nombre)
        var perfilProf = itemView.findViewById<TextView>(R.id.perfilProf)
        var img = itemView.findViewById<ImageView>(R.id.img_item)
        var url = itemView.findViewById<TextView>(R.id.url)

        init {
            itemView.setOnClickListener {
                context.startActivity(Intent(context, Detalle::class.java).let {
                    it.putExtra("nombre", nombre.text.toString())
                    it.putExtra("perfilProf", perfilProf.text.toString())
                    it.putExtra("url", "https://lastfm.freetls.fastly.net/i/u/770x0/1e1b90d26052b292fe3fab2fab9dd0d9.jpg#1e1b90d26052b292fe3fab2fab9dd0d9"/* url.text.toString()*/)
                })
            }
        }
    }
}
