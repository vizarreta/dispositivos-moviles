/**
 * Descripción: Selección del tipo de comida
 * Autor: Estudiante
 * Fecha creación: 2025-10-01
 * Última modificación: 2025-10-01
 */
package com.example.practica5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SeleccionComidaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_comida, container, false)
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupComida)
        val btnSiguiente = view.findViewById<Button>(R.id.btnSiguienteComida)

        btnSiguiente.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val comida = view.findViewById<RadioButton>(selectedId).text.toString()
                val bundle = Bundle().apply { putString("comida", comida) }
                findNavController().navigate(R.id.action_seleccionComidaFragment_to_seleccionExtrasFragment, bundle)
            }
        }
        return view
    }
}
