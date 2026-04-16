# Prova
📱 *Cadastro de Produtos - Loja Virtual*
---
Aplicativo Android desenvolvido para facilitar o controle de produtos de uma loja de eletrônicos.
O sistema permite cadastrar produtos no estoque e visualizar uma lista com os produtos cadastrados, substituindo o antigo controle feito em caderno.

🎯 *Objetivo do Projeto*
---
Criar um aplicativo simples e funcional utilizando Room Database para armazenamento local de dados, com duas telas principais:

📋 Tela de Cadastro de Produto
📦 Tela de Listagem de Produtos

O aplicativo foi desenvolvido utilizando boas práticas de desenvolvimento Android e validações para garantir a integridade dos dados.

⚙️ *Tecnologias Utilizadas*
---
Java / Kotlin
Room Database
Android SDK
Interface com componentes nativos Android
Arquitetura básica com Entity, DAO e Database

📲 Funcionalidades
---
📝 Cadastro de Produto

Permite cadastrar novos produtos com as seguintes informações:
Nome do produto
Código do produto (alfanumérico)
Preço (R$)
Quantidade em estoque

✅ Validações aplicadas
Nenhum campo pode ficar vazio
O preço deve ser um número positivo com até duas casas decimais
A quantidade deve ser um número inteiro positivo

Após o cadastro, o produto é salvo no banco de dados local (Room).

📦 Listagem de Produtos
---
Tela responsável por exibir todos os produtos cadastrados no banco.

Informações exibidas:

Nome do produto
Código do produto
Preço

A tela também permite retornar para o cadastro de novos produtos.

🗄️ Estrutura do Banco de Dados (Room)
---
O projeto utiliza Room Database para persistência de dados.

Entity

Product

Representa a tabela de produtos no banco de dados.

Campos principais:

id
nome
codigo
preco
quantidade
DAO

ProductDao

Responsável pelas operações de acesso ao banco.

Métodos principais:

Inserção de produtos
Listagem de produtos cadastrados
Database

ProductDatabase

Classe responsável por criar e gerenciar o banco de dados utilizando Room.

🖥️ Interface do Aplicativo
---
O aplicativo utiliza componentes padrão do Android para uma interface simples e funcional:

EditText
Buttons
TextView
RecyclerView ou ListView
ScrollView
Navegação entre Activities
