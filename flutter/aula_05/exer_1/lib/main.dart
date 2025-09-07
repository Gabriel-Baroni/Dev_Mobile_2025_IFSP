import 'package:flutter/material.dart';

// Classe do item com nome e URL da imagem
class Item {
  final String name;
  final String imageUrl;

  Item({required this.name, required this.imageUrl});
}

// Tela principal com lista de itens
class MainScreen extends StatelessWidget {
  final List<Item> items = [
    Item(name: 'Item 1', imageUrl: 'http://picsum.photos/id/237/200/300'),
    Item(name: 'Item 2', imageUrl: 'http://picsum.photos/201'),
    Item(name: 'Item 3', imageUrl: 'http://picsum.photos/202'),
    Item(name: 'Item 4', imageUrl: 'http://picsum.photos/203'),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Lista de Itens')),
      body: ListView.builder(
        itemCount: items.length,
        itemBuilder: (context, index) {
          final item = items[index];
          return ListTile(
            title: Text(item.name),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder:
                      (context) => ItemDetailsScreen(
                        item: item,
                        imageUrl: item.imageUrl, // Passa a URL diretamente
                      ),
                ),
              );
            },
          );
        },
      ),
    );
  }
}

// Tela de detalhes do item
class ItemDetailsScreen extends StatelessWidget {
  final Item item;
  final String imageUrl;

  ItemDetailsScreen({required this.item, required this.imageUrl});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Detalhes do Item')),
      body: Column(
        children: [
          Image.network(imageUrl),
          SizedBox(height: 16),
          Text(item.name, style: TextStyle(fontSize: 20)),
        ],
      ),
    );
  }
}

// Função principal
void main() {
  runApp(MaterialApp(title: 'Lista de Itens', home: MainScreen()));
}
