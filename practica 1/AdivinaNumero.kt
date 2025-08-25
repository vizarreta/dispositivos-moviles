/*
Descripción: Juego de adivinar un número entre 1 y 30 con un máximo de 5 intentos.
Autor: Carlos Adrian Vizarreta Checya
Fecha creación: 25/08/2025
Última modificación: 25/08/2025
*/

import kotlin.random.Random

fun main() {
    val numeroSecreto = Random.nextInt(1, 31)
    var intentos = 5
    var adivinado = false

    println("Adivina el número (entre 1 y 30). Tienes $intentos intentos.")

    while (intentos > 0 && !adivinado) {
        print("Ingresa tu número: ")
        val intento = readln().toInt()

        if (intento == numeroSecreto) {
            println("¡Felicidades! Adivinaste el número.")
            adivinado = true
        } else {
            intentos--
            if (intentos > 0) {
                if (intento < numeroSecreto) {
                    println("El número secreto es mayor. Te quedan $intentos intentos.")
                } else {
                    println("El número secreto es menor. Te quedan $intentos intentos.")
                }
            }
        }
    }

    if (!adivinado) {
        println("Game Over. El número secreto era $numeroSecreto.")
    }
}
