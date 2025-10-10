package com.example.fakestoreapp.solid

// 3. Principio de Sustitución de Liskov - Liskov Substitution Principle
// Las clases hijas deben de poder reemplazar a las clases padre sin tener que romper el programa

open class Ave{
    open fun volar(){
        println("VUELO!!!!!!!")
    }
}

class Pinguino : Ave(){
    override fun volar(){
        throw Exception("LOS PINGUINOS NO VUELAN PADRE")
    }
}

fun main(){
    val pinguino = Pinguino()
    pinguino.volar()
}

// Solución
interface Bird{
    fun eat()
}

interface FlyingBird{
    fun fly()
}

class Eagle : Bird, FlyingBird{
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }
}

class Penguin : Bird{
    override fun eat() {
        TODO("Not yet implemented")
    }
}