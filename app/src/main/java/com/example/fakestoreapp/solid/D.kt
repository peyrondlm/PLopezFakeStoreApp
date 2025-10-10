package com.example.fakestoreapp.solid

// 5. Principio de Inversión de Dependencias - Dependency Inversion Principle
// Las clases deben de depender de abstracciones en lugar de construcciones

// Violación del principio
class MySQLDatabase{
    fun save(data:String){
        val connectionString = ""
        println("Salvando datos")
    }
}

class MongoDatabase(){
    fun save(data:String){
        val connectionString = ""
        println("Datos salvados")
    }
}

class AdminDB{
    val database = MongoDatabase()
    fun save(data:Double){
        val sanitizarDatos = data.toString()
        database.save(sanitizarDatos)
    }
}

// Solución
interface Database{
    fun save(data : String)
}

class MySQLDatabaseImplementation : Database {
    override fun save(data: String) {
        TODO("Not yet implemented")
    }
}

class MongoDatabaseImplementation : Database {
    override fun save(data: String) {
        TODO("Not yet implemented")
    }
}

// Patrón de diseño REPOSITORY
// INYECCIÓN DE DEPENDENCIAS
class UserRepository(val database : Database){
    fun save(data: String){
        database.save(data)
    }
}

fun main(){
    val userRepository = UserRepository(MySQLDatabaseImplementation())
}