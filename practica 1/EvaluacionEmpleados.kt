/*
Descripción: Programa que calcula el nivel de rendimiento y la cantidad de dinero recibida según la puntuación y salario.
Autor: Carlos Adrian Vizarreta Checya
Fecha creación: 25/08/2025
Última modificación: 25/08/2025
*/

fun calcularNivel(puntos: Int): String {
    return when (puntos) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun calcularDinero(salario: Double, puntos: Int): Double {
    return salario * (puntos.toDouble() / 10)
}

fun main() {
    print("Ingrese su salario mensual: ")
    val salario = readln().toDouble()
    print("Ingrese su puntuación (0 a 10): ")
    val puntos = readln().toInt()

    val nivel = calcularNivel(puntos)
    if (nivel == "Puntuación inválida") {
        println("Error: La puntuación debe estar entre 0 y 10.")
    } else {
        val dinero = calcularDinero(salario, puntos)
        println("Nivel de Rendimiento: $nivel")
        println("Cantidad de dinero recibido: $${dinero}")
    }
}
