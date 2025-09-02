/*
Descripción: Juego de piedra, papel o tijera contra la computadora.
Autor: Carlos Adrian Vizarreta Checya
Fecha creación: 25/08/2025
Última modificación: 25/08/2025
*/

import kotlin.random.Random

fun obtenerResultado(usuario: String, computadora: String): String {
    return if (usuario == computadora) {
        "Empate"
    } else if (
        (usuario == "piedra" && computadora == "tijera") ||
        (usuario == "papel" && computadora == "piedra") ||
        (usuario == "tijera" && computadora == "papel")
    ) {
        "Ganaste"
    } else {
        "Perdiste"
    }
}

fun main() {
    val opciones = listOf("piedra", "papel", "tijera")
    val computadora = opciones[Random.nextInt(opciones.size)]

    print("Elige piedra, papel o tijera: ")
    val usuario = readln().lowercase()

    if (usuario !in opciones) {
        println("Opción inválida. Debe ser piedra, papel o tijera.")
    } else {
        println("Computadora eligió: $computadora")
        println("Resultado: ${obtenerResultado(usuario, computadora)}")
    }
}
