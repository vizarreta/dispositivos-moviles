/**
 * Descripción: Clase Producto con precio y descuento, calcula precio final.
 * Autor: Carlos Adrian Vizarreta Checya
 */

class Producto(private var _precio: Double, private var _descuento: Double) {

    var precio: Double
        get() = _precio
        set(value) {
            if (value >= 0) _precio = value else println("El precio no puede ser negativo")
        }

    var descuento: Double
        get() = _descuento
        set(value) {
            if (value in 0.0..100.0) _descuento = value else println("El descuento debe estar entre 0 y 100")
        }

    fun calcularPrecioFinal(): Double {
        return _precio - (_precio * (_descuento / 100))
    }
}

fun main() {
    val producto = Producto(200.0, 20.0)
    println("Precio final: ${producto.calcularPrecioFinal()}")
}
