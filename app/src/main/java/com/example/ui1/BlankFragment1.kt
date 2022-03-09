package com.example.ui1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BlankFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val vista =  inflater.inflate(R.layout.fragment_blank1, container, false)
        val rv = vista.findViewById<RecyclerView>(R.id.recyclerCard)
        val db = DbEmpleados(context)

        rv.adapter = MiCardAdapter(requireContext(), db.mostarEmpleados()/*contactos()*/)
        rv.layoutManager = LinearLayoutManager(context)
        return vista
    }

   /* fun contactos() : ArrayList<Contacto> {
        val contactos:MutableList<Contacto> = ArrayList()
        contactos.let {
            it.add(Contacto("Juan Cruz Frini", "Junior Android developer", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.last.fm%2Fes%2Fmusic%2FPolo%2BG%2F%2Bimages%2F1e1b90d26052b292fe3fab2fab9dd0d9&psig=AOvVaw3wl4rapinZDfDFfCZEC9Wo&ust=1646597991054000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCOCOsePlr_YCFQAAAAAdAAAAABAE.jpg"))
            *//*it.add(Contacto("Heraldo Rosa", "Junior web developer"))
            it.add(Contacto("Wachin ReGay", "Inspector junior"))
            it.add(Contacto("JJhon cenna", "Pepeado juliao"))
            it.add(Contacto("Pocahontas", "No me acuerdo"))
            it.add(Contacto("Pacha mama", "Madre Tierra"))
            it.add(Contacto("Riquelme", "Senior fulbo developer"))
            it.add(Contacto("otro", "ghost"))*//*
        }
        return contactos as ArrayList<Contacto>
    }*/

}