# BottomNavigationBar - Flutter 🚀

Este proyecto implementa una **navegación inferior (BottomNavigationBar)** en Flutter con cuatro pestañas: *Inicio*, *Usuarios*, *Configuración* y *Perfil*.  
Incluye comunicación entre pantallas, manejo de estado y aplicación de buenas prácticas de desarrollo.

---

## 🎯 Objetivo
Comprender y aplicar el uso del **BottomNavigationBar** junto con **StatefulWidget**, la **navegación con paso de datos** y la **modularización del código** en Flutter.

---

## 🧩 Características
- Navegación inferior con 4 pestañas.  
- Pantalla de perfil con opción para editar el nombre del usuario.  
- Comunicación entre pantallas usando `Navigator.push()` y `Navigator.pop()`.  
- Uso de una clase `AppStrings` para evitar strings directos.  
- Código limpio, comentado y estructurado.

---

## 🧱 Estructura del Código
```
lib/
│
├── main.dart              # Archivo principal con la clase MyApp y navegación
├── perfil_tab.dart        # Widget de la pestaña Perfil
├── editar_perfil.dart     # Pantalla de edición de perfil
└── utils/
    └── app_strings.dart   # Clase con los textos reutilizables
```

---

## ⚙️ Ejecución del Proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/bottom_navigation_flutter.git
   ```

2. Ingresa al directorio del proyecto:
   ```bash
   cd bottom_navigation_flutter
   ```

3. Instala las dependencias:
   ```bash
   flutter pub get
   ```

4. Ejecuta la aplicación:
   ```bash
   flutter run
   ```

---

## 💡 Reflexión
Este proyecto permite reforzar los conceptos de:
- Manejo del estado con `StatefulWidget`.
- Navegación entre pantallas con paso de datos.
- Modularización y documentación del código.

---

## 🧠 Autor
**[Tu Nombre]**  
Universidad La Salle – Ingeniería de Software  
Curso: *Aplicaciones Móviles (Flutter)*

---

## 📄 Licencia
Este proyecto se distribuye bajo la licencia MIT. Puedes modificarlo y usarlo libremente para fines educativos.
