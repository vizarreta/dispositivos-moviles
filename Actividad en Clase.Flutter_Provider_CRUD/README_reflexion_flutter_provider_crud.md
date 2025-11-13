# Flutter Provider CRUD (MVVM) 

## 🧩 Descripción general

Este proyecto implementa una aplicación **Flutter** que permite **agregar, editar y eliminar usuarios** de una lista en memoria, aplicando el patrón **MVVM (Model–View–ViewModel)** y utilizando **Provider** para el manejo del estado.

La app refuerza conceptos como la separación de capas, las listas dinámicas, el uso de formularios y la reactividad en Flutter.

---

## 🎯 Objetivos

- Aplicar el patrón **MVVM** para separar la lógica de negocio de la interfaz.
- Implementar **Provider** como gestor de estado reactivo.
- Utilizar componentes de Flutter como `RadioButton`, `Switch` y `ListView.builder`.
- Validar formularios y actualizar la interfaz en tiempo real.

---

## 🧠 Preguntas de reflexión y respuestas

### 1️⃣ ¿Qué ventajas ofrece usar **Provider** frente a **setState()**?

Usar **Provider** permite manejar el estado de forma **global y reactiva**, mientras que `setState()` solo actualiza el estado dentro del mismo widget.

Ventajas de Provider:
- Separa la lógica de negocio de la interfaz (siguiendo MVVM).
- Permite que varias vistas compartan el mismo estado.
- Los cambios se notifican automáticamente a todos los widgets dependientes.
- Facilita la escalabilidad en proyectos grandes.

`setState()` es útil para estados locales simples, pero no es recomendable cuando se requiere comunicación entre múltiples widgets o pantallas.

---

### 2️⃣ ¿Por qué es importante usar **ChangeNotifier** en el ViewModel?

`ChangeNotifier` permite que el **ViewModel notifique a las vistas (Widgets)** cuando ocurre un cambio en los datos.

Esto garantiza que la UI se **actualice automáticamente** al modificarse la información, sin necesidad de usar `setState()` manualmente.

En el patrón MVVM:
- El ViewModel gestiona los datos y su lógica.
- Llama a `notifyListeners()` para informar a las vistas sobre cambios.

Sin `ChangeNotifier`, las vistas no se actualizarían, rompiendo la conexión entre la capa lógica y la interfaz.

---

### 3️⃣ ¿Qué sucedería si no se llamara a **notifyListeners()** después de editar un usuario?

Si no se llama a `notifyListeners()`, la vista **no reflejaría los cambios** realizados en los datos, aunque internamente el modelo haya sido actualizado.

Esto significa que:
> Los datos cambian, pero la interfaz **no se entera**.

El resultado sería que las modificaciones (como agregar, editar o eliminar usuarios) no aparecerían en pantalla hasta que se reinicie o recargue el widget manualmente.

---

## 🧩 Actividades complementarias sugeridas

- Agregar un campo **edad** (`TextField` numérico) y mostrarlo en la lista.
- Validar que el nombre no esté vacío y la edad sea mayor que 0.
- Agregar un campo **correo electrónico** con validación de formato.
- Implementar un **filtro** para mostrar solo usuarios activos.

---

## 🧭 Conclusión

Esta práctica demuestra cómo **Provider y MVVM** permiten desarrollar aplicaciones Flutter más **ordenadas, reactivas y mantenibles**.

El uso de `ChangeNotifier` simplifica la comunicación entre la lógica de negocio y la interfaz, promoviendo un flujo de datos limpio y eficiente.

En resumen:
- **Provider** reemplaza el uso excesivo de `setState()`.
- **ChangeNotifier** mantiene sincronizada la vista con los datos.
- **MVVM** separa responsabilidades y facilita el mantenimiento.

---
