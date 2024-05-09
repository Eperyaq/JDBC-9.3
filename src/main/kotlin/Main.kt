package com.conexionDataBase

import com.conexionDataBase.DB_Connections.DataBase
import com.conexionDataBase.Repo.Repository


fun main() {

    val product = Item(2, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    val productId = Repository().insertItem(product)

    println("Product ID: $productId")

}