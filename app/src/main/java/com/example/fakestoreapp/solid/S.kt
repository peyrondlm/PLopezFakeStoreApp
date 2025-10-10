package com.example.fakestoreapp.solid

// A PIE ABSTRACCIÓN POLIMORFISMO HERENCIA ENCAPSULAMIENTO
// 1. S - Principio de Responsabilidad Única. Single Responsability Principle
// Cada clase solo debe de tener una responsabilidad

// Violación del principio

class Reportes{
    fun generarReporte(){}
    fun guardarReporte(){}
    fun enviarReporte(){}
    fun generarReportePDF(){}
    fun guardarEnLaNube(){}
}

// Arreglo del problema
class GeneradorReportes{
    fun generarReporte(){}
    fun generarReportePDF(){
        val reporte = transormFromPDFtoCSV("Viene de word")
        return reporte
    }

    private fun transormFromPDFtoCSV(word: String){}
}

class EnviadorReportes{
    fun enviarReportePorCorreo(){}
    fun enviarReportePorTelefono(){}
}

class AlmacenadorReportes{
    fun guardarEnNube(){}
    fun guardarEnComputadora(){}
}