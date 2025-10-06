package com.example.fakestoreapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

// Callback
// Hell callbacks
fun main() {
    val a = 1
    val b = 2
    val result = suma(a, b)
    print(result)
    OperacionDeNumeros(a, b, operacion = { a, b -> suma(a, b) })
}

// Función que reciba dos números y regrese dos números
fun OperacionDeNumeros(a: Int, b: Int, operacion : (Int, Int) -> Int ) {
    println("El número a vale: $a")
    println("El número b vale: $b")
    val result = operacion(a, b)
    println(result)
}

fun suma(a : Int, b: Int) : Int {
    return a + b
}

fun resta(a : Int, b: Int) : Int{
    return a - b
}

//@Composable
//fun MyCard(navController: NavController){
//    Row {
//        MyCustomButton(navController)
//        Text("Hola")
//    }
//}

//@Composable
//fun MyCustomButton(navController:NavController){
//    Button(onClick = {navController.navigate()}) {}
//}

@Composable
fun BookCard(onClick : () -> Unit) {
    Column (
        modifier = Modifier
            .clickable{
                onClick()
            }
    ){
        // BLA BLA BLA BLA
    }
}

@Composable
fun HomeScreen() {
    Column {
        BookCard {
            
        }
    }
}