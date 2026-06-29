<h1 align="center"> SGB </h1>

<h2 align="center"> SISTEMA DE GESTÃO DE BIBLIOTECA </h2>

---

## **INTEGRANTES**

- **Faustino Marcos** : 2023 - 0156;
- **Milicrisney Dos Santos** : 2023 - 0934;
- **Rodolfo Guzman** : 2023 - 0090;

---

## **Sobre o Projeto**

Este **Sistema de Gestão de Biblioteca** tem por finalidade melhorar a gestão das tarefas em uma biblioteca, melhorando o desempenho das funções entre os funcionários e os leitores, criando assim um ambiente controlado e devidamente bem monitorado.

---

## **Funcionalidades**

O presente sistema possui as seguintes funcionalidades:

### Para os Livros

- Registar livros;
- Atualizar Livros;
- Pesquisar Livros;
- Mostrar Livros;
- Bloquear/Desbloquear Livros;
- Remover Livros;

### Para Usuarios

- Iniciar Sessão
- Registar-se pela primeira vez como adm
- Recuperar Senha

- Registar Usuario;
- Atualizar Usuario;
- Bloquear/Desbloquear Usuario;
- Remover Usuario;
- Mostrar Usuario;

### Para Emprestimos

- Registar Emprestimo;
- Devolver Emprestimo;
- Mostrar Emprestimo;
- Multa;

---

## **Tecnologias**

- Java (With Ant);

---

## **Estrutura do Projecto**

```text
SGB
├── build
│   ├── built-jar.properties
│   ├── classes
│   │   ├── dados
│   │   │   └── Ficheiro.class
│   │   ├── sgb
│   │   │   ├── Biblioteca.class
│   │   │   ├── Emprestimo.class
│   │   │   ├── Livro.class
│   │   │   ├── SGB.class
│   │   │   └── Usuario.class
│   │   └── Utilizadores
│   │       └── Usuario.class
│   ├── empty
│   └── generated-sources
│       └── ap-source-output
├── build.xml
├── emprestimos.txt
├── livros.txt
├── manifest.mf
├── nbproject
│   ├── build-impl.xml
│   ├── genfiles.properties
│   ├── private
│   │   ├── private.properties
│   │   └── private.xml
│   ├── project.properties
│   └── project.xml
├── src
│   ├── dados
│   │   └── Ficheiro.java
│   ├── sgb
│   │   ├── Biblioteca.java
│   │   ├── Emprestimo.java
│   │   ├── Livro.java
│   │   └── SGB.java
│   └── Utilizadores
│       └── Usuario.java
├── test
└── utilizadores.txt
```

---

## **Classes**

- Biblioteca
- Livro
- Usuario
- Emprestimo
- Ficheiro

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

5. Ficheiro

- LIVROS (livro.txt);
- UTILIZADORES (utilizadores.txt);
- EMPRESTIMOS (emprestimos.txt);

---

## **Métodos**

0. SGB(A main)

- carregarTudo();// Carrega todas os dados guardados em ficheiros permanentemente para os ArrayList
- bbtc();
- salvarTudo(); //Salva todos os dados armazenados nos ArrayList

1. Biblioteca

- login();
- cadastrarSe();
- iniciarSessao();
- recuperarSenha();
- LeitorDasboard();
- FuncionarioDasboard();
- AdministradorDasboard();
- menuEmprestimo();
- lerEmail();
- lerBi();
- lerIsbn();
- lerNivelAcesso();
- Menu();
- espera();
- limitarTexto();
- bbtc();

2. Livro

- inserirLivro();
- mostrarLivros();
- procurarLivroId();
- procurarLivroTitulo();
- atualizarLivro();
- pesquisarLivro();
- bloquearDesbloquearLivro();
- removerLivro();
- reativarLivro();

3. Usuario

- inserirUsuario();
- procurarUsuarioId();
- procurarUsuarioGmail();
- atualizarUsuario();
- mostrarUsuario();
- bloquearDesbloquearUsuario();
- removerUsuario();
- gmailVerificacao();
- senhaVerificacao();
- validarAcesso();
- contaUsuarios();

4. Emprestimo

- inserirEmprestimo();
- adicionarEmprestimo();
- mostrarEmprestimos();
- devolverLivro();
- calcularMulta();
- mostrarMulta();

5. Ficheiro

- salvarLivros();
- carregarLivros();
- salvarUsuarios();
- carregarUsuarios();
- salvarEmprestimos();
- carregarEmprestimos();
- salvarTudo();
- carregarTudo();

---

## **Ficheiros**

- Livro;
- Usuario;
- Emprestimo;

---

## **Como Executar**

- Baixar o programa para computador (NETBEANS);
- Clicar no botão file;
- Clicar em open project;
- Procurar pela pasta do projecto na aba que irá pedir para adicionar o projecto no ambiente do netbeans;
- Clicar na tecla F6 ou botão run do neatbean;

## **Futuras melhorias**

- Adicionar Login Para funcionarios(para ter controle de usuários)
