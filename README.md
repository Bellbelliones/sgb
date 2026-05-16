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

1 - Registar livros;
2 - Atualizar Livros;
3 - Eliminar Livros;
4 - Registar Eleitores;
5 - Atualizar Leitores;
6 - Eliminar Leitor;
7 - Bloquear Leitor;
8 - Registar Emprestimos;
9 - Conferir Devoulções;
10 - Controlar Multas;

---

## **Tecnologias**

- Java (With Ant);

---

## **Estrutura do Projecto**

---

## **Classes**

1 - Biblioteca;
2 - Livros;
3 - User;
4 - Emprestimos;

---

## **Atributos**

### 1 **Biblioteca**

- ...

### 2 **Livros**

- id_livro;
- titulo;
- autor;
- genero;
- Estado (boolean);

### 3 **User**

- id_user;
- nome;
- email;
- bi;
- nivelAcesso(Leitor, Funcionario);
- estado(bolean);

### 3 **Emprestimos**

- id_leitor;
- dataEmprestimo;
- dataFimEmprestimo;
- id_livro;

---

## **Métodos**

### 1 **Biblioteca**

- ArrayList de Livros;
- ArrayList de Leitores;
- ArrayList de Emprestimos;
- Menu;

### 2 **Livros**

- Registar;
- Atualizar;
- Eliminar;

### 3 **User**

- Registar;
- Atualizar;
- Bloquear;
- Eliminar;
- nivelAcesso(Leitor, Funcionario);
- estado(bolean);

### 3 **Emprestimos**

- Registar;
- Devolver;
- Multa;

---

## **Como Executar**

## **Futuras melhorias**
