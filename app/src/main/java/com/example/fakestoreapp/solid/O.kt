package com.example.fakestoreapp.solid

// 2. Principio de Abierto/Cerrado - Open/Close Principle
// El código debe de estar abierto para extender pero cerrado para modificar

// Violación del principio
class CalculadoraDescuentos{
    fun calcularDescuento(precio : Double, tipo : String) : Double {
        val result = if(tipo == "ESTUDIANTE") precio * 0.9
        else if(tipo == "PROFESOR") precio * 0.95
        else precio
        return result
    }
}

// Solución al principio
interface Discount{
    fun apply(precio : Double) : Double
}

class StudentDiscount : Discount{
    override fun apply(precio: Double): Double {
        return precio * 0.9
    }

}