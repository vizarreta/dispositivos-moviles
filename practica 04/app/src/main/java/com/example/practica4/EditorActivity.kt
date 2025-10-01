/**
 * Descripción: Editor de nota rápida que envía el texto a OpcionesActivity
 * Autor: Estudiante
 * Fecha creación: 2025-10-01
 * Última modificación: 2025-10-01
 */
package com.example.practica4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class EditorActivity : AppCompatActivity() {

    private lateinit var edtNota: EditText

    private val opcionesLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            edtNota.setText(result.data?.getStringExtra("nota"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        edtNota = findViewById(R.id.edtNota)
        val btnCompartir = findViewById<Button>(R.id.btnCompartir)

        btnCompartir.setOnClickListener {
            val intent = Intent(this, OpcionesActivity::class.java)
            intent.putExtra("nota", edtNota.text.toString())
            opcionesLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nota", edtNota.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        edtNota.setText(savedInstanceState.getString("nota"))
    }
}
