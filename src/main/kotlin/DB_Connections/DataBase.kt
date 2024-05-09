package com.conexionDataBase.DB_Connections

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DataBase {

    const val URL = "jdbc:h2:file:C:\\Users\\usuariot\\reposgit\\Tienda-JDBC\\default"
    const val USUARIO = "user"
    const val CONTRASENIA = "user"

    /**
     * Funcion que establece la conexion con la base de datos
     * @return La conexion con la base de datos
     */
    fun connectDB(): Connection?{
        var conexion : Connection? = null

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENIA) //Dar conexion con la base de datos
        } catch ( e: SQLException){
            e.printStackTrace()
        }

        return conexion
    }

    /**
     * Funcion que cierra la database
     * @param conexion Conexion que hay que cerrar
     */
    fun closeDB(conexion:Connection?) {
        try {
            conexion?.close()
        } catch (e:SQLException){
            e.printStackTrace()
        }
    }

}