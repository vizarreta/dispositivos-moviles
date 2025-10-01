/**
 * Descripción: Fragmento inicial con botón para iniciar un nuevo pedido
 * Autor: Estudiante
 * Fecha creación: 2025-10-01
 * Última modificación: 2025-10-01
 */
package com.example.practica5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import android.widget.Button

class InicioFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)
        val btnNuevoPedido = view.findViewById<Button>(R.id.btnNuevoPedido)
        btnNuevoPedido.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_seleccionComidaFragment)
        }
        return view
    }
}
