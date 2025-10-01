/**
 * Descripción: Selección de extras (bebida, papas, postre)
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
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SeleccionExtrasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_extras, container, false)
        val chkBebida = view.findViewById<CheckBox>(R.id.chkBebida)
        val chkPapas = view.findViewById<CheckBox>(R.id.chkPapas)
        val chkPostre = view.findViewById<CheckBox>(R.id.chkPostre)
        val btnSiguiente = view.findViewById<Button>(R.id.btnSiguienteExtras)

        btnSiguiente.setOnClickListener {
            val extras = mutableListOf<String>()
            if (chkBebida.isChecked) extras.add("Bebida")
            if (chkPapas.isChecked) extras.add("Papas")
            if (chkPostre.isChecked) extras.add("Postre")

            val bundle = arguments ?: Bundle()
            bundle.putStringArrayList("extras", ArrayList(extras))

            findNavController().navigate(R.id.action_seleccionExtrasFragment_to_resumenPedidoFragment, bundle)
        }
        return view
    }
}
