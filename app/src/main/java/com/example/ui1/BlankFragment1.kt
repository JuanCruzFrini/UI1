package com.example.ui1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BlankFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val vista =  inflater.inflate(R.layout.fragment_blank1, container, false)
        val rv = vista.findViewById<RecyclerView>(R.id.recyclerCard)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = MiCardAdapter(requireContext(), contactos())
        return vista
    }

    fun contactos() : ArrayList<Contacto> {
        val contactos:MutableList<Contacto> = ArrayList()
        contactos.let {
            it.add(Contacto("Juan Cruz Frini", "Junior Android developer"))
            it.add(Contacto("Heraldo Rosa", "Junior web developer"))
            it.add(Contacto("Wachin ReGay", "Inspector junior"))
            it.add(Contacto("JJhon cenna", "Pepeado juliao"))
            it.add(Contacto("Pocahontas", "No me acuerdo"))
            it.add(Contacto("Pacha mama", "Madre Tierra"))
            it.add(Contacto("Riquelme", "Senior fulbo developer"))
            it.add(Contacto("otro", "ghost"))
        }
        return contactos as ArrayList<Contacto>
    }

}