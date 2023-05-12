package com.example.ejemplobasededatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAOPersona {

    @Query("SELECT * FROM persona")
    fun getAll(): List<Persona>

    @Query("SELECT * FROM persona where nombre like :nombreArgs LIMIT 1")
    fun findByName(nombreArgs: String):Persona

    @Insert
    fun agregar(vararg persona: Persona)

    fun buscar(vararg persona: Persona)
}