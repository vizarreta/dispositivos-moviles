/**
 * Descripción: Muestra el resumen de los datos y permite confirmar o volver a editar
 * Autor: Estudiante
 * Fecha creación: 2025-10-01
 * Última modificación: 2025-10-01
 */
package com.example.practica4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val usuario = intent.getSerializableExtra("usuario") as Usuario

        val txtResumen = findViewById<TextView>(R.id.txtResumen)
        txtResumen.text = "Nombre: ${usuario.nombre}\nEdad: ${usuario.edad}\nCiudad: ${usuario.ciudad}\nCorreo: ${usuario.correo}"

        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)
        val btnEditar = findViewById<Button>(R.id.btnEditar)

        btnConfirmar.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        btnEditar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
