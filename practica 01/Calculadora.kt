/*
Descripción: Calculadora básica que realiza suma, resta, multiplicación y división.
Autor: Carlos Adrian Vizarreta Checya
Fecha creación: 25/08/2025
Última modificación: 25/08/2025
*/

fun suma(a: Double, b: Double) = a + b
fun resta(a: Double, b: Double) = a - b
fun multiplicacion(a: Double, b: Double) = a * b
fun division(a: Double, b: Double): Double {
    return if (b != 0.0) a / b else Double.NaN
}

fun main() {
    var opcion: Int
    do {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        print("Seleccione una opción: ")

        opcion = readln().toInt()

        if (opcion in 1..4) {
            print("Ingrese el primer número: ")
            val a = readln().toDouble()
            print("Ingrese el segundo número: ")
            val b = readln().toDouble()

            val resultado = when (opcion) {
                1 -> suma(a, b)
                2 -> resta(a, b)
                3 -> multiplicacion(a, b)
                4 -> division(a, b)
                else -> 0.0
            }

            println("Resultado: $resultado")
        } else if (opcion != 5) {
            println("Opción inválida. Intente de nuevo.")
        }
    } while (opcion != 5)

    println("Saliendo de la calculadora...")
}
