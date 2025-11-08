
// Flutter BottomNavigationBar mejorado con buenas prácticas
// Autor: [Tu nombre]
// Descripción: Ejemplo de navegación inferior con 4 pestañas y comunicación entre pantallas.

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

/// Clase de textos reutilizables (evita strings directos en el código)
class AppStrings {
  static const appTitle = 'Ejemplo BottomNavigationBar';
  static const inicio = 'Inicio';
  static const usuarios = 'Usuarios';
  static const configuracion = 'Configuración';
  static const perfil = 'Perfil';
  static const editarPerfil = 'Editar perfil';
  static const guardar = 'Guardar';
  static const nombre = 'Nombre';
}

/// Widget principal del proyecto
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: AppStrings.appTitle,
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const MyHomePage(),
      debugShowCheckedModeBanner: false,
    );
  }
}

/// Pantalla principal con navegación inferior
class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;
  String _nombreUsuario = 'Invitado';

  /// Construye el contenido de cada pestaña con ícono y texto
  Widget buildTabContent(IconData icon, String text) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(icon, size: 60, color: Colors.blueAccent),
          const SizedBox(height: 10),
          Text(text, style: const TextStyle(fontSize: 22)),
        ],
      ),
    );
  }

  /// Lista de páginas principales
  late final List<Widget> _pages = [
    buildTabContent(Icons.home, AppStrings.inicio),
    buildTabContent(Icons.people, AppStrings.usuarios),
    buildTabContent(Icons.settings, AppStrings.configuracion),
    PerfilTab(
      nombreUsuario: _nombreUsuario,
      onNombreCambiado: (nuevoNombre) {
        setState(() {
          _nombreUsuario = nuevoNombre;
        });
      },
    ),
  ];

  /// Cambia la pestaña seleccionada
  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text(AppStrings.appTitle)),
      body: _pages[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
        type: BottomNavigationBarType.fixed,
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: AppStrings.inicio),
          BottomNavigationBarItem(icon: Icon(Icons.people), label: AppStrings.usuarios),
          BottomNavigationBarItem(icon: Icon(Icons.settings), label: AppStrings.configuracion),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: AppStrings.perfil),
        ],
      ),
    );
  }
}

/// Pestaña Perfil
class PerfilTab extends StatefulWidget {
  final String nombreUsuario;
  final Function(String) onNombreCambiado;

  const PerfilTab({super.key, required this.nombreUsuario, required this.onNombreCambiado});

  @override
  State<PerfilTab> createState() => _PerfilTabState();
}

class _PerfilTabState extends State<PerfilTab> {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text('Usuario: ${widget.nombreUsuario}', style: const TextStyle(fontSize: 20)),
          const SizedBox(height: 20),
          ElevatedButton(
            onPressed: () async {
              final nombre = await Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => const EditarPerfilScreen()),
              );
              if (nombre != null && nombre.toString().trim().isNotEmpty) {
                widget.onNombreCambiado(nombre);
              }
            },
            child: const Text(AppStrings.editarPerfil),
          ),
        ],
      ),
    );
  }
}

/// Pantalla de edición de perfil
class EditarPerfilScreen extends StatefulWidget {
  const EditarPerfilScreen({super.key});

  @override
  State<EditarPerfilScreen> createState() => _EditarPerfilScreenState();
}

class _EditarPerfilScreenState extends State<EditarPerfilScreen> {
  final TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text(AppStrings.editarPerfil)),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _controller,
              decoration: const InputDecoration(labelText: AppStrings.nombre),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context, _controller.text);
              },
              child: const Text(AppStrings.guardar),
            ),
          ],
        ),
      ),
    );
  }
}
