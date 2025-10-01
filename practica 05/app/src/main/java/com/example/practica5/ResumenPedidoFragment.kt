/**
 * Descripción: Muestra resumen del pedido y permite confirmar o editar
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
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController

class ResumenPedidoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resumen_pedido, container, false)
        val txtResumen = view.findViewById<TextView>(R.id.txtResumen)
        val btnConfirmar = view.findViewById<Button>(R.id.btnConfirmar)
        val btnEditar = view.findViewById<Button>(R.id.btnEditar)

        val comida = arguments?.getString("comida")
        val extras = arguments?.getStringArrayList("extras")

        txtResumen.text = "Comida: $comida\nExtras: ${extras?.joinToString(", ")}"

        btnConfirmar.setOnClickListener {
            Toast.makeText(requireContext(), "Pedido confirmado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_resumenPedidoFragment_to_inicioFragment)
        }

        btnEditar.setOnClickListener {
            val result = Bundle().apply {
                putString("comida", comida)
                putStringArrayList("extras", extras)
            }
            setFragmentResult("pedido_editado", result)
            findNavController().popBackStack(R.id.seleccionComidaFragment, false)
        }

        return view
    }
}
