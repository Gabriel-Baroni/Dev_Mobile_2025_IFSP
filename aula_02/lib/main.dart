import 'package:flutter/material.dart';

void main() => runApp(
  MaterialApp(
    debugShowCheckedModeBanner: false,
    home: Scaffold(
      appBar: AppBar(
        title: Text(' Aula Flutter02'),
        backgroundColor: Colors.blueAccent,
      ),
      body: Container(
        padding: EdgeInsets.fromLTRB(30, 20, 20, 20),
        margin: EdgeInsets.fromLTRB(20, 30, 20, 30),
        decoration: BoxDecoration(
          border: Border.all(width: 3, color: Colors.blueAccent),
          color: Color.fromARGB(99, 60, 139, 230), // Cor de fundo azul claro
        ),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(Icons.access_alarm, color: Colors.red, size: 50),
                Icon(Icons.access_alarm, color: Colors.green, size: 50),
                Icon(Icons.access_alarm, color: Colors.blue, size: 50),
              ],
            ),
            Text(
              'Um texto genérico é aquele que apresenta informações vagas, pouco específicas, ou que aborda muitos tópicos gerais ao mesmo tempo. É o oposto de um conteúdo único, que foca em detalhes e tem uma mensagem clara e direcionada. Em design gráfico e editoração, o "Lorem Ipsum" é um exemplo de texto genérico, usado para preencher espaços em publicações, permitindo que os designers visualizem o layout e a tipografia antes de inserir o conteúdo real. Elaboração:',
              textAlign: TextAlign.justify,
              style: TextStyle(
                fontSize: 25,
                color: Colors.blueAccent,
                fontWeight: FontWeight.bold,
              ),
            ),
            TextButton(
              onPressed: () {
                print("Botão pressionado!");
              },
              child: Text(
                'Clica aqui',
                style: TextStyle(fontSize: 20, color: Colors.red),
              ),
            ),
            Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text("t1"),
                Padding(padding: EdgeInsets.all(30)),
                Text("t2"),
                Padding(padding: EdgeInsets.all(10)),
                Text("t3"),
              ],
            ),
            Image.asset("images/images2.JPG", width: 200, height: 200),
          ],
        ),
      ),
    ),
  ),
);
