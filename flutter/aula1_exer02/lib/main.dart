import 'dart:math';
import 'package:flutter/material.dart';

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;
  List<String> comidas = [
    "Macarrão",
    "Arroz",
    "Lasanha",
    "Batata Frita",
    "Omelete",
  ];

  String randomTexto = "";

  void atualizarTela() {
    setState(() {
      // Pega um item aleatório da lista
      randomTexto = comidas[Random().nextInt(comidas.length)];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            randomTexto,
            style: TextStyle(fontSize: 24),
          ),
          SizedBox(height: 20),
          TextButton(
            onPressed: atualizarTela,
            child: Text(
              'Sortear comida',
            ),
          ),
        ],
      ),
    );
  }
}

void main() => runApp(
  MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: Text('Escolha Aleatória'),
        backgroundColor: Colors.orange,
      ),
      body: MyHomePage(),
    ),
  ),
);
