/**
 * Descripción: Formulario de usuario que envía datos a ResumenActivity
 * Autor: Estudiante
 * Fecha creación: 2025-10-01
 * Última modificación: 2025-10-01
 */
package com.example.practica4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtEdad: EditText
    private lateinit var edtCiudad: EditText
    private lateinit var edtCorreo: EditText

    private val resumenLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        edtNombre = findViewById(R.id.edtNombre)
        edtEdad = findViewById(R.id.edtEdad)
        edtCiudad = findViewById(R.id.edtCiudad)
        edtCorreo = findViewById(R.id.edtCorreo)

        val btnContinuar = findViewById<Button>(R.id.btnContinuar)
        btnContinuar.setOnClickListener {
            val usuario = Usuario(
                edtNombre.text.toString(),
                edtEdad.text.toString(),
                edtCiudad.text.toString(),
                edtCorreo.text.toString()
            )
            val intent = Intent(this, ResumenActivity::class.java)
            intent.putExtra("usuario", usuario)
            resumenLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", edtNombre.text.toString())
        outState.putString("edad", edtEdad.text.toString())
        outState.putString("ciudad", edtCiudad.text.toString())
        outState.putString("correo", edtCorreo.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        edtNombre.setText(savedInstanceState.getString("nombre"))
        edtEdad.setText(savedInstanceState.getString("edad"))
        edtCiudad.setText(savedInstanceState.getString("ciudad"))
        edtCorreo.setText(savedInstanceState.getString("correo"))
    }
}
