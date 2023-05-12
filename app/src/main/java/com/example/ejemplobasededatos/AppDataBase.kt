package com.example.ejemplobasededatos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Persona::class], version = 1, exportSchema = false)

abstract class AppDataBase:RoomDatabase() {

    //todos ado's
    abstract fun personaDAO():DAOPersona
}