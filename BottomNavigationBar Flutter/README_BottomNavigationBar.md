
### 🧩 **1. ¿Por qué se recomienda usar un StatefulWidget para manejar el índice de la pestaña seleccionada?**

Porque el **índice de la pestaña seleccionada cambia dinámicamente** cuando el usuario toca un ícono diferente en la barra de navegación.
Un `StatefulWidget` permite **mantener y actualizar el estado** (`_selectedIndex`) sin reconstruir toda la aplicación.
Cada vez que el usuario selecciona una pestaña, se llama a `setState()`, lo que actualiza solo la parte necesaria de la interfaz.

📘 *En resumen:* se usa `StatefulWidget` porque la navegación depende del estado actual y debe reaccionar a las acciones del usuario.

---

### 🧱 **2. ¿Qué ventajas ofrece separar cada pestaña en su propio widget o pantalla?**

Separar las pestañas en widgets o archivos diferentes permite:

* **Reutilización del código:** cada pantalla puede ser usada en otros contextos.
* **Mantenimiento más fácil:** se pueden modificar las pantallas sin afectar a las demás.
* **Mejor organización:** el código se vuelve más legible y escalable.
* **Carga más rápida:** Flutter solo renderiza la pestaña visible, optimizando el rendimiento.

📘 *En resumen:* mejora la organización, legibilidad y mantenimiento del proyecto.

---

### 🚀 **3. ¿Cómo cambia la navegación entre pantallas al usar rutas nombradas en lugar de `Navigator.push()`?**

Con **rutas nombradas**, se definen las pantallas en el `MaterialApp` usando un mapa de rutas, lo que:

* Evita escribir rutas directamente con `MaterialPageRoute`.
* Hace el código más limpio y **centraliza la navegación**.
* Permite **navegar y regresar fácilmente** usando los nombres definidos.

📘 *Ejemplo:*

```dart
routes: {
  '/perfil': (context) => const PerfilScreen(),
  '/editar': (context) => const EditarPerfilScreen(),
}

// Navegación
Navigator.pushNamed(context, '/editar');
```

*En cambio, `Navigator.push()` crea rutas directamente en el código.*
Las rutas nombradas son ideales para proyectos grandes con múltiples pantallas.

---

### 🔁 **4. ¿De qué forma el uso de `Navigator.pop(context, data)` facilita la comunicación entre pantallas?**

`Navigator.pop(context, data)` **permite regresar datos** desde una pantalla secundaria hacia la principal.
Por ejemplo, al editar el nombre del usuario, la pantalla “Editar perfil” envía el nuevo nombre a la pantalla “Perfil” sin usar variables globales.

📘 *Ventaja:* facilita la **comunicación de datos entre pantallas** de manera controlada y reactiva.

*Ejemplo:*

```dart
final nombre = await Navigator.push(
  context,
  MaterialPageRoute(builder: (context) => const EditarPerfilScreen()),
);
setState(() {
  _nombreUsuario = nombre;
});
```

---

### 🌟 **5. ¿Qué posibles mejoras o extensiones podrías agregar a esta aplicación para hacerla más completa?**

Algunas mejoras posibles son:

* Agregar **persistencia de datos** (guardar el nombre con `SharedPreferences`).
* Implementar **temas oscuros y claros**.
* Usar **rutas nombradas** y controladores de navegación centralizados.
* Incorporar **animaciones o transiciones** entre pestañas.
* Añadir un **sistema de login** o conexión con una base de datos local (SQLite).
* Dividir el proyecto en **múltiples archivos** (por cada pantalla y clase).

📘 *En resumen:* se puede ampliar el proyecto para hacerlo más funcional, escalable y profesional.

-

