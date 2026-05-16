<h1 align="center"> SGB </h1>

<h2 align="center"> SISTAMA DE GESTÃO DE BIBLIOTECA </h2>

---

## **INTEGRANTES**

- **Faustino Marcos** : 2023 - 0156;
- **Mily Dos Santos** : 2023 - 0934;
- **Rodolfo Guzman** : 2023 - 0090;

---

## **Sobre o Projeto**

Este **Sistema de Gestão de Biblioteca** tem por finalidade melhorar a gestão das tarefas em uma biblioteca, melhorando o desempenho das funções entre os funcionários e os leitores, criando assim um ambiente controlado e devidamente bem monitorado.

---

## **Funcionalidades**

O presente sistema possui as seguintes funcionalidades:

- Registar livros;
- Atualizar Livros;
- Eliminar Livros;
- Registar Eleitores;
- Atualizar Leitores;
- Eliminar Leitor;
- Bloquear Leitor;
- Registar Emprestimos;
- Conferir Devoulções;
- Controlar Multas;

---

## **Tecnologias**

- Java (With Ant);

---

## **Estrutura do Projecto**

---

## **Classes**

- Biblioteca
- Livro
- Usuario
- Emprestimo

---

## **Atributos**

1. Biblioteca

- listaLivros
- listaUsuarios
- listaEmprestimos

2. Livro

- id
- titulo
- autor
- genero
- disponivel

3. Usuario

- id
- nome
- email
- bi
- nivelAcesso
- ativo

4. Emprestimo

- id
- livro
- usuario
- dataEmprestimo
- dataDevolucao
- devolvido

---

## **Métodos**

1. Biblioteca

- menu()
- adicionarLivro()
- atualizarLivro()
- eliminarLivro()
- listarLivros()
- adicionarUsuario()
- atualizarUsuario()
- bloquearUsuario()
- eliminarUsuario()
- adicionarEmprestimo()
- devolverLivro()
- verificarMulta()
- carregarLivros()
- carregarUsuarios()
- carregarEmprestimos()

2. Livro

- cadastrar()
- atualizar()
- remover()
- listar()

3. Usuario

- cadastrar()
- atualizar()
- bloquear()
- remover()

4. Emprestimo

- realizarEmprestimo()
- devolverLivro()
- calcularMulta()

---

## **Ficheiros**

- Livro;
- Usuario;
- Emprestimo;

## **Como Executar**

## **Futuras melhorias**
