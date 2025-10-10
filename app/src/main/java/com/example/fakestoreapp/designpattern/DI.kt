package com.example.fakestoreapp.designpattern

// Inyección de Dependencias
// Separar la creación de dependencias y el uso de las mismas
// mejorar la modularidad

// Procesador
// Memoria RAM
// Tarjeta madre
// Tarjeta gráfica
// Almacenamiento

abstract class Storage{

}

class HDD: Storage(){

}

class SSD: Storage(){

}

class Motherboard: Storage(){

}

class RAM{

}

class Computer(val ram : RAM, val storage : Storage, val motherboard: Motherboard){

}

fun main(){
    val computer = Computer(
        ram = RAM(),
        storage = SSD(),
        motherboard = Motherboard()
    )
}