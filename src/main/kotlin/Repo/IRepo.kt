package com.conexionDataBase.Repo

import com.conexionDataBase.DB_Connections.DataBase
import com.conexionDataBase.Item
import javax.xml.crypto.Data

interface IRepo {

    /**
     * Inserta en la tabla de la DB un item
     * @param id Id del objeto
     * @param name Nombre del objeto
     * @param price Precio del objeto
     * @param description Descripcion del objeto
     * @param brand Marca del objeto
     * @param category Categoria del item
     */
    fun insertItem( item: Item):Item?
}