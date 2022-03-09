package com.example.ui1

import android.app.AlertDialog
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
        holder.url.text = contactos[position].imgurl

        Glide
            .with(context)
            .load(contactos[position].imgurl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .circleCrop().error("https://pbs.twimg.com/profile_images/794633494794272768/KhJpT9pP_400x400.jpg")
            .into(holder.img)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nombre = itemView.findViewById<TextView>(R.id.nombre)
        var perfilProf = itemView.findViewById<TextView>(R.id.perfilProf)
        var img = itemView.findViewById<ImageView>(R.id.img_item)
        var url = itemView.findViewById<TextView>(R.id.url)

        init {
            itemView.setOnClickListener {
                context.startActivity(Intent(context, Detalle::class.java).putExtra("ID", contactos[adapterPosition].id))
            }

            val onLongClickListener = View.OnLongClickListener { v ->
                AlertDialog.Builder(context)
                        .setTitle("Desea Borrar el elemento?")
                        .setMessage("Estas seguro?")
                        .setPositiveButton("Ok") { _, _ ->
                            DbEmpleados(context).borrarEmpleado(contactos[adapterPosition].id)
                            context.startActivity(Intent(context, MainActivity::class.java))
                        }
                        .setCancelable(true)
                        .show()
                true
            }
            itemView.setOnLongClickListener(onLongClickListener)
        }
    }
}
