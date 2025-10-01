/**
 * Descripción: Muestra la nota y permite compartirla o editarla de nuevo
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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OpcionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val nota = intent.getStringExtra("nota")

        val txtNota = findViewById<TextView>(R.id.txtNota)
        txtNota.text = nota

        val btnCompartir = findViewById<Button>(R.id.btnCompartirCorreo)
        val btnEditar = findViewById<Button>(R.id.btnEditarNota)

        btnCompartir.setOnClickListener {
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show()
        }

        btnEditar.setOnClickListener {
            val intent = Intent()
            intent.putExtra("nota", nota)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
