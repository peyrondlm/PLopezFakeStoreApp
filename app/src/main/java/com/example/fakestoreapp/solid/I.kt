package com.example.fakestoreapp.solid

// 4. Principio de Segregación de Interfaz - Interface Segregation Principle
// Las interfaces deben de ser especificaz, y no obligar a implementar métodos innecesarios

interface Trabajador{
    fun trabajar()
    fun descansar()
    fun comer()
    fun cobrar()
}

class Persona : Trabajador {
    override fun cobrar() {
        TODO("Not yet implemented")
    }

    override fun trabajar() {
        TODO("Not yet implemented")
    }

    override fun descansar() {
        TODO("Not yet implemented")
    }

    override fun comer() {
        TODO("Not yet implemented")
    }
}

class Robot : Trabajador {
    override fun cobrar() {
        TODO("Not yet implemented")
    }

    override fun comer() {
        TODO("Not yet implemented")
    }

    override fun descansar() {
        TODO("Not yet implemented")
    }

    override fun trabajar() {
        TODO("Not yet implemented")
    }
}

interface Worker{
    fun work()
    fun rest()
}

interface Eatable{
    fun eat()
}

interface Cashier{
    fun cash()
}

class Person : Worker, Eatable, Cashier {
    override fun cash() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun rest() {
        TODO("Not yet implemented")
    }

    override fun work() {
        TODO("Not yet implemented")
    }
}

class Clanker : Worker {
    override fun rest() {
        TODO("Not yet implemented")
    }

    override fun work() {
        TODO("Not yet implemented")
    }
}