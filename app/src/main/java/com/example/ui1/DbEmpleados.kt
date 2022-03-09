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

    fun verContacto(id: Int): Contacto? {
        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        var contacto: Contacto? = null
        val cursorContactos: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE id = $id LIMIT 1", null)
        if (cursorContactos.moveToFirst()) {
            contacto = Contacto(cursorContactos.getInt(1), cursorContactos.getString(1),cursorContactos.getString(2), cursorContactos.getString(3))
        }
        cursorContactos.close()
        return contacto
    }

    fun mostarEmpleados() : ArrayList<Contacto> {
        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        val listaEmpleados = ArrayList<Contacto>()
        var empleado: Contacto
        val cursor:Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()){
            do {
                empleado = Contacto(
                        cursor.getInt(0),     // corresponde al ID (columna)
                        cursor.getString(1),  //nombre
                        cursor.getString(2),  //perfil profesional
                        cursor.getString(3)   //imagen url
                )
                listaEmpleados.add(empleado)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return listaEmpleados
    }

    fun borrarEmpleado(id:Int) : Boolean{
        var correcto = false
        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        correcto = try {
            db.execSQL("DELETE FROM $TABLE_NAME WHERE id = '$id'")
            true
        } catch (ex: Exception) {
            ex.toString()
            false
        } finally {
            db.close()
        }
        return correcto
    }

    fun editEmpleado(id:Int, nombre:String, perfilProf: String, imagen:String) : Boolean{
        val dbEmpleados = DbEmpleados(context)
        val db = dbEmpleados.writableDatabase
        var correcto = false

        correcto = try {
            db.execSQL("UPDATE $TABLE_NAME SET nombre='$nombre', perfilProf='$perfilProf', imagen='$imagen' WHERE id = '$id'")
            true
        } catch (ex: Exception){
            ex.toString()
            false
        } finally {
            db.close()
        }
        return correcto
    }
}