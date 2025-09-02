/**
 * Descripción: Clases Shape, Cuadrado, Círculo y Rectángulo con cálculo de área y perímetro.
 * Autor: Carlos Adrian Vizarreta Checya
 */

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}, Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = 4 * lado
}

class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    override fun calcularArea() = largo * ancho
    override fun calcularPerimetro() = 2 * (largo + ancho)
}

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea() = Math.PI * radio * radio
    override fun calcularPerimetro() = 2 * Math.PI * radio
}

fun main() {
    val cuadrado = Cuadrado(4.0)
    val rectangulo = Rectangulo(5.0, 3.0)
    val circulo = Circulo(2.5)

    cuadrado.imprimirResultados()
    rectangulo.imprimirResultados()
    circulo.imprimirResultados()
}
