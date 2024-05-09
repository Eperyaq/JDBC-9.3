package com.conexionDataBase.Repo

import com.conexionDataBase.DB_Connections.DataBase
import com.conexionDataBase.Item
import java.sql.SQLException

class Repository: IRepo {

    /**
     * Inserta un item en la base de datos
     * @param id Id del objeto
     * @param name Nombre del objeto
     * @param price Precio del objeto
     * @param description Descripcion del objeto
     * @param brand Marca del objeto
     * @param category Categoria del item
     */
    override fun insertItem( item: Item):Item? {

        val connection = DataBase.connectDB()
            val sql = "INSERT INTO products (id, name, price, description, brand, category ) VALUES (?, ?, ?, ?, ?, ?)"

        return try {
            connection.use { conn ->
                conn?.prepareStatement(sql).use { statement ->
                    statement?.setInt(1,item.id)
                    statement?.setString(2, item.name)
                    statement?.setFloat(3, item.price)
                    statement?.setString(4, item.description)
                    statement?.setString(5, item.brand)
                    statement?.setString(6, item.category)
                    val rs = statement?.executeUpdate()
                    if (rs ==1){
                        item
                    } else {
                        println("Error, insert query failed ($rs records inserted)")
                        null
                    }

                }
            }
        }catch (e:SQLException){
            println("Error, ${e.message}")
            null
        }finally {
            DataBase.closeDB(connection)
        }
    }

}