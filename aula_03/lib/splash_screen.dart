import 'dart:async';
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(home: SplashScreen()));
}

class SplashScreen extends StatefulWidget {
  @override
  _SplashScreenState createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    Timer(Duration(seconds: 3), () {
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => HomeScreen()),
      );
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blue,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Bem-Vindo ao Meu App',
              style: TextStyle(
                fontSize: 24,
                color: Colors.white,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(height: 16),
            Text(
              'Seu destino para uma experiência incrível!',
              style: TextStyle(fontSize: 18, color: Colors.white),
            ),
          ],
        ),
      ),
    );
  }
}

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.cyanAccent.shade200,
        flexibleSpace: Container(
          decoration: BoxDecoration(
            gradient: LinearGradient(
              colors: [Colors.pink.shade300, Colors.cyanAccent.shade700],
            ),
          ),
        ),
        title: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            Image.asset('images/imagem.png', fit: BoxFit.cover, height: 50),
            Icon(Icons.group, color: Colors.grey, size: 35),
            Text(
              'Cadastre-se',
              style: TextStyle(
                fontFamily: 'DancingScript',
                fontSize: 20,
                color: Colors.white,
              ),
            ),
            IconButton(
              icon: Icon(Icons.mode_edit),
              onPressed: () {},
              color: Colors.grey,
              iconSize: 30,
            ),
            ElevatedButton(
              child: Text("Entrar"),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.grey,
                foregroundColor: Colors.white,
              ),
              onPressed: () {
                print("Precionado");
              },
            ),
          ],
        ),
      ),
      body: Container(
        decoration: BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [Colors.cyanAccent.shade700, Colors.pink.shade300],
          ),
        ),
        child: Center(
          child: Text(
            'Bem Vindo catapimbas!',
            style: TextStyle(
              fontFamily: 'DancingScript',
              fontSize: 40,
              fontWeight: FontWeight.bold,
              color: Colors.white,
            ),
          ),
        ),
      ),
      bottomNavigationBar: BottomAppBar(
        color: Colors.cyanAccent,
        child: Padding(
          padding: EdgeInsets.all(16),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Icon(Icons.message, color: Colors.grey, size: 35),
              Icon(Icons.menu, color: Colors.grey, size: 35),
            ],
          ),
        ),
      ),
    );
  }
}
