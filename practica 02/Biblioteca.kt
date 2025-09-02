/**
 * Descripción: Sistema de Biblioteca con Material, Libro, Revista, Usuario e implementación de préstamos.
 * Autor: Carlos Adrian Vizarreta Checya
 */

abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numPaginas")
    }
}

class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, ISSN: $issn, Vol: $volumen, Nº: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestar(usuario: Usuario, material: Material)
    fun devolver(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservados(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()
    private val usuarios = mutableListOf<Usuario>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    override fun prestar(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            prestamos.computeIfAbsent(usuario) { mutableListOf() }.add(material)
            println("${usuario.nombre} ha tomado prestado: ${material.titulo}")
        } else {
            println("El material no está disponible")
        }
    }

    override fun devolver(usuario: Usuario, material: Material) {
        prestamos[usuario]?.remove(material)
        materialesDisponibles.add(material)
        println("${usuario.nombre} ha devuelto: ${material.titulo}")
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservados(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre}:")
        prestamos[usuario]?.forEach { it.mostrarDetalles() }
    }
}

fun main() {
    val biblioteca = Biblioteca()
    val usuario = Usuario("Carlos", "Vizarreta", 21)

    val libro = Libro("Kotlin para Todos", "JetBrains", 2022, "Programación", 350)
    val revista = Revista("Ciencia Hoy", "Varios", 2023, "1234-5678", 12, 5, "Editorial Científica")

    biblioteca.registrarUsuario(usuario)
    biblioteca.registrarMaterial(libro)
    biblioteca.registrarMaterial(revista)

    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.prestar(usuario, libro)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservados(usuario)
    biblioteca.devolver(usuario, libro)
    biblioteca.mostrarMaterialesDisponibles()
}
