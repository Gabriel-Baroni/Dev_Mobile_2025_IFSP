import 'package:flutter/material.dart';

void main() => runApp(
  MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: Text('Primeiro Projeto'),
        backgroundColor: Colors.red,
      ),
      body: Center(child: Text("Olá Mundo")),
    ),
  ),
);
