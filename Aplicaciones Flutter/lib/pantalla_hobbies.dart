import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mis Hobbies'),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: const [
                Icon(Icons.book, color: Colors.deepPurple),
                SizedBox(width: 10),
                Text('Leer libros de tecnología y ciencia'),
              ],
            ),
            const SizedBox(height: 15),
            Row(
              children: const [
                Icon(Icons.music_note, color: Colors.pinkAccent),
                SizedBox(width: 10),
                Text('Escuchar música y aprender guitarra'),
              ],
            ),
            const SizedBox(height: 15),
            Row(
              children: const [
                Icon(Icons.sports_soccer, color: Colors.green),
                SizedBox(width: 10),
                Text('Jugar fútbol con amigos'),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
