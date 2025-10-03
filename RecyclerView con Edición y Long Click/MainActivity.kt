/*
Descripción: MainActivity con RecyclerView que permite editar y eliminar usuarios con long click y AlertDialog personalizado.
Autor: Estudiante
Fecha creación: 02/10/2025
Última modificación: 02/10/2025
*/

package com.example.recyclerviewdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var usuarioAdapter: UsuarioAdapter
    private val listaUsuarios = mutableListOf(
        Usuario("Carlos", 21, "carlos@mail.com"),
        Usuario("Ana", 25, "ana@mail.com"),
        Usuario("Luis", 30, "luis@mail.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        usuarioAdapter = UsuarioAdapter(listaUsuarios,
            onEditClick = { pos, usuario ->
                listaUsuarios[pos] = usuario
                usuarioAdapter.notifyItemChanged(pos)
            },
            onDeleteClick = { pos ->
                listaUsuarios.removeAt(pos)
                usuarioAdapter.notifyItemRemoved(pos)
            })

        recyclerView.adapter = usuarioAdapter
    }
}
