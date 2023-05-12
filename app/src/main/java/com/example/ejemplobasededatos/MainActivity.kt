package com.example.ejemplobasededatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    lateinit var edId: EditText
    lateinit var edNombre: EditText
    lateinit var edTelefono: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edId = findViewById(R.id.edID)
        edNombre = findViewById(R.id.edNombre)
        edTelefono = findViewById(R.id.edTelefono)
    }

    fun buscar(nombre: String): List<Persona> {
        val db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "contactos").allowMainThreadQueries().build()
        val personas = db.personaDAO().buscar(nombre)
        return personas
    }

    fun consultar(v:View){
        //se crea puntero a la base de datos
        val db = Room.databaseBuilder(applicationContext,AppDataBase::class.java,"contactos").allowMainThreadQueries().build()

        val personas= db.personaDAO().getAll()
        personas.forEach{
            persona -> Log.e("Dato", "${persona.id} ${persona.nombre}")
        }
        Toast.makeText(this, "Se consulto", Toast.LENGTH_LONG).show()
    }

    fun agregarDato(v:View){

        val id = edId.text.toString().toInt()
        val nombre = edNombre.text.toString()
        val telefono = edTelefono.text.toString()

        //crear objeto persona
        val persona  = Persona(id,nombre,telefono)

        //se crea puntero a la base de datos
        val db = Room.databaseBuilder(applicationContext,AppDataBase::class.java,"contactos").allowMainThreadQueries().build()

        db.personaDAO().agregar(persona)
        Toast.makeText(this, "Se grabo", Toast.LENGTH_LONG).show()
    }
}