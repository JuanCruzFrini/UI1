package com.example.ui1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DbEmpleados(var context: Context?) : DbHelper(context) {

    fun addEmpleado(nombre:String, perfilProf:String, img:String) : Long {
        val dbhelper = DbHelper(context)
        val db = dbhelper.writableDatabase
        var id: Long = 0

        val values = ContentValues()
        values.put("nombre", nombre)
        values.put("perfilProf", perfilProf)
        values.put("imagen", img)

        id = db.insert(TABLE_NAME, null, values)

        return id
    }

    fun mostarEmpleado() : ArrayList<Contacto> {
        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        val listaEmpleados = ArrayList<Contacto>()
        var empleado: Contacto
        val cursor:Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()){
            do {
                empleado = Contacto(
                      //cursor.getString(0) corresponde al ID (columna)
                        cursor.getString(1), //nombre
                        cursor.getString(2), //perfil profesional
                        cursor.getString(3) //imagen url
                )
                listaEmpleados.add(empleado)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return listaEmpleados
    }

}