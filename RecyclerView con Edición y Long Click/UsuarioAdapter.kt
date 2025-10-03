/*
Descripción: Adapter de RecyclerView con soporte para edición y eliminación mediante long click y diálogo personalizado.
Autor: Estudiante
Fecha creación: 02/10/2025
Última modificación: 02/10/2025
*/

package com.example.recyclerviewdialog

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(
    private val usuarios: MutableList<Usuario>,
    private val onEditClick: (Int, Usuario) -> Unit,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    inner class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtNombre: TextView = itemView.findViewById(R.id.txtNombre)
        private val txtEdad: TextView = itemView.findViewById(R.id.txtEdad)
        private val txtCorreo: TextView = itemView.findViewById(R.id.txtCorreo)

        fun bind(usuario: Usuario) {
            txtNombre.text = usuario.nombre
            txtEdad.text = "Edad: ${usuario.edad}"
            txtCorreo.text = usuario.correo

            itemView.setOnLongClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    AlertDialog.Builder(itemView.context)
                        .setTitle("Acción")
                        .setItems(arrayOf("Editar", "Eliminar")) { _, which ->
                            when (which) {
                                0 -> showEditDialog(usuario, pos)
                                1 -> onDeleteClick(pos)
                            }
                        }
                        .show()
                }
                true
            }
        }

        private fun showEditDialog(usuario: Usuario, pos: Int) {
            val context = itemView.context
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_usuario, null)

            val editNombre = dialogView.findViewById<EditText>(R.id.editNombre)
            val editEdad = dialogView.findViewById<EditText>(R.id.editEdad)
            val editCorreo = dialogView.findViewById<EditText>(R.id.editCorreo)

            editNombre.setText(usuario.nombre)
            editEdad.setText(usuario.edad.toString())
            editCorreo.setText(usuario.correo)

            AlertDialog.Builder(context)
                .setTitle("Editar usuario")
                .setView(dialogView)
                .setPositiveButton("Guardar") { _, _ ->
                    usuario.nombre = editNombre.text.toString()
                    usuario.edad = editEdad.text.toString().toIntOrNull() ?: usuario.edad
                    usuario.correo = editCorreo.text.toString()
                    onEditClick(pos, usuario)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.bind(usuarios[position])
    }

    override fun getItemCount() = usuarios.size
}
