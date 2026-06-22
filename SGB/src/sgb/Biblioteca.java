/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgb;

import Utilizadores.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author critical-trojan
 */
public class Biblioteca {

    // <editor-fold defaultstate="collapsed" desc="Funções de Acesso">

    public static int login(ArrayList<Usuario> ALU) {
        Scanner pega = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║             LOGIN            ║");
            System.out.println("╠══════════════════════════════╣");

            // Se tiver um usuario, ele validad iniciar sessao
            if (!ALU.isEmpty())
                System.out.println("║  [1] Iniciar Sessao          ║");
            // Caso a lista de usurio não tenha ainda nenhum usuario,
            // A primeira pessoa ira se cadastrar como ADM
            else
                System.out.println("║  [2] Registar-Se             ║");
            System.out.println("║  [3] Esqueci a senha         ║");
            System.out.println("║                              ║");
            System.out.println("║  [0] Sair                    ║");
            System.out.println("╚══════════════════════════════╝");

            opcao = pega.nextInt();
            switch (opcao) {
                case 1 -> {
                    if (!ALU.isEmpty())
                        return iniciarSessao(ALU);
                    else
                        System.out.println("Escolha a opcao certa!");
                }
                case 2 -> {

                    if (ALU.isEmpty())
                        cadastraSe(ALU);
                    else
                        System.out.println("Escolha a opcao certa!");
                }
                case 0 -> {
                    System.out.println("Encerrando o sistema...");
                }
                default -> {
                    System.out.println("Escolha uma das opcoes acima citados");
                }
            }

        }
        return -1;
    }

    public static boolean cadastraSe(ArrayList<Usuario> ALU) {
        Scanner pega = new Scanner(System.in);
        int id_usuario = 0;
        String nome = " ";
        String bi = " ";
        String email = " ";
        String senha = " ";
        int nivelacesso = 0;

        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║                   !!AVISOS!!                ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║ [!] Registo pela primeira vez:              ║");
        System.out.println("║                                             ║");
        System.out.println("║ Esta opcao so aparece quando nao existe     ║");
        System.out.println("║ um usuario no sistema...                    ║");
        System.out.println("║                                             ║");
        System.out.println("║ O primeiro usuario deve ser sempre o ADM,   ║");
        System.out.println("║ então tu serás registado como um ADM.       ║");
        System.out.println("║                                             ║");
        System.out.println("║ Uma vez registado, a opcao de cadastrar-se  ║");
        System.out.println("║ nao ira aparecer mais, a nao ser que todos  ║");
        System.out.println("║ usuarios sejam eliminados permanentemente   ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║ [!] Importancia Deste Registo               ║");
        System.out.println("║                                             ║");
        System.out.println("║ Esta sera a tua conta principal, perder ela ║");
        System.out.println("║ significa perder acesso a todos os          ║");
        System.out.println("║ privilegios de administrador do sistema.    ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║ [!] Pontos importantes                      ║");
        System.out.println("║                                             ║");
        System.out.println("║ O seu email deve conter o seu nome, o       ║");
        System.out.println("║ simbolo @ no fim do nome, e por fim o       ║");
        System.out.println("║ gmail.com depois do @ para ser validado sem ║");
        System.out.println("║ erros.                                      ║");
        System.out.println("║                                             ║");
        System.out.println("║ A senha deve conter igual ou acima de 9     ║");
        System.out.println("║ caracteres, ao menos um numero e um simbolo.║");
        System.out.println("║                                             ║");
        System.out.println("║ Caso nenhuma dessas condicoes nao forem     ║");
        System.out.println("║ satisfeitas, o sistema ira reportar a       ║");
        System.out.println("║ ausencia do mesmo.                          ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║            !!OBRIGADO PELA ATENCAO!!        ║");
        System.out.println("╚═════════════════════════════════════════════╝");
        espera();
        System.out.println();
        System.out.println();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║         CADASTRAR-SE         ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.println();

        System.out.println("Digite o nome");
        nome = pega.nextLine();
        System.out.println("Digite o numero de BI");
        bi = pega.nextLine();

        nivelacesso = 1;

        System.out.println("Digite o  email");
        do {
            email = pega.nextLine();
        } while (Usuario.gmailVerificacao(email) != 0);

        System.out.println("Digite a senha");
        do {
            senha = pega.nextLine();
        } while (Usuario.senhaVerificacao(senha) != 0);

        if (ALU.add(Usuario.inserirUsuario(id_usuario, nome, email, senha, bi, nivelacesso, true))) {
            System.out.println("Usuario registado com sucesso");
        } else
            System.out.println("Erro ao registar o usuario");

        espera();

        return true;
    }

    public static int iniciarSessao(ArrayList<Usuario> ALU) {
        Scanner pega = new Scanner(System.in);
        int i = 10;
        while (i >= 1) {
            // pegando os dados
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║        INICIAR SESSÃO        ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("Tentativas: " + i);
            System.out.println();
            System.out.println("        DIGITE O EMAIL");
            System.out.println("═════════════════════════════");
            String email = pega.nextLine();
            System.out.println();
            System.out.println();
            System.out.println("        DIGITE A SENHA");
            System.out.println("═════════════════════════════");
            String senha = pega.nextLine();

            // verificando os dados
            int index = Usuario.validarAcesso(ALU, email, senha);
            if (index != -1)
                return index;
            else
                System.out.println("E-mail ou Senha incorreta");
            i--;
        }
        if (i < 1)
            System.out.println(
                    "Numero maximo de tentativas excedidas!!!\nEncerrando o sistema!\nVolte a tentar daqui a 2 minutos\n");

        return 0;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Dashborads">
    public static int LeitorDasboard(ArrayList<Livro> ALL) {
        // Objecto para pegar os dados digitados pelo usuário
        Scanner pega = new Scanner(System.in);

        // Variaveis de decisão
        int opcao = -1;

        while (opcao != 0) {
            // Exibindo o menu principal
            Menu("Leitor");
            opcao = pega.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║            LIVROS            ║");
                    System.out.println("╚══════════════════════════════╝");

                    Livro.mostrarLivros(ALL, 2);
                    System.out.println("\n\n\n");
                    break;
                case 2:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║          EMPRESTIMOS         ║");
                    System.out.println("╚══════════════════════════════╝");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("A opção inválida");
            }
        }

        return 0;
    }

    public static int FuncionarioDashboard(ArrayList<Livro> ALL, ArrayList<Usuario> ALU) {
        // Objecto para pegar os dados digitados pelo usuário
        Scanner pega = new Scanner(System.in);

        // Lista de livros

        // Variaveis de decisão
        int opcao = -1;
        int escolha = -1;

        // variaveis principais para livro
        int id = 0;
        String titulo = " ";
        String autor = " ";
        String genero = " ";

        // variaveis principais para usuarios

        int id_uAutomatico = ALU.get(Usuario.contaUsuarios(ALU) - 1).getId() + 1;
        int id_usuario = 0;
        String nome = " ";
        String bi = " ";
        String email = " ";
        String senha = " ";
        int nivelacesso = 0;

        while (opcao != 0) {
            // Exibindo o menu principal
            Menu("Funcionario");
            opcao = pega.nextInt();

            switch (opcao) {
                case 1 -> {
                    escolha = 0;
                    while (escolha != 5) {
                        Menu("LivrosF");
                        escolha = pega.nextInt();
                        switch (escolha) {
                            case 1 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Registar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");

                                // Tentando ver se regista mesmo o livro no array

                                System.out.println("Digite o ID do livro");
                                id = pega.nextInt();
                                pega.nextLine();

                                System.out.println("Digite o Titulo do livro");
                                titulo = pega.nextLine();

                                System.out.println("Digite o Autor do livro");
                                autor = pega.nextLine();

                                System.out.println("Digite o Gênero do livro");
                                genero = pega.nextLine();

                                // criando e adicionado o livro a lista

                                if (ALL.add(Livro.inserirLivro(id, titulo, autor, genero, true)))
                                    System.out.println("Registo Efectuado com sucesso");
                                else
                                    System.out.println("Erro ao adicionar o livro");

                                espera();
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");

                                System.out.println("Digite o ID do livro");
                                id = pega.nextInt();
                                pega.nextLine();

                                if (Livro.procuraLivroId(id, ALL) != -1) {
                                    int novoId = 0;
                                    System.out.println("Vai alterar o ID do livro?\ny - sim\nn - nao\n");
                                    if (pega.nextLine().charAt(0) == 'y') {
                                        System.out.println("Digite o novo ID");
                                        novoId = pega.nextInt();

                                    } else {
                                        System.out.println(
                                                "Digitar outra qualquer coisa diferente de y, vai ser considerada como opcao de não alterar o ID");
                                    }

                                    System.out.println("Digite o Novo Titulo: ");
                                    titulo = pega.nextLine();

                                    System.out.println("Digite o Novo Autor do livro: ");
                                    autor = pega.nextLine();

                                    System.out.println("Digite o Novo Gênero do livro: ");
                                    genero = pega.nextLine();

                                    Livro.atualizarLivro(ALL, id, novoId, titulo, autor, genero);

                                    System.out.println("Livro Atualizado com sucesso\n");
                                } else {
                                    System.out.println("O livro que procura atualizar não existe\n");
                                }
                                espera();
                            }
                            case 3 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Pesquisar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");

                                System.out.println("Como vai pesquisar\n1 - ID\n2 - Titulo");
                                switch (pega.nextInt()) {
                                    case 1 -> {
                                        System.out.println("Digite o ID");
                                        id = pega.nextInt();
                                        Livro.pesquisarLivro(ALL, id, " ");
                                    }
                                    case 2 -> {
                                        pega.nextLine();
                                        System.out.println("Digite o Titulo");
                                        titulo = pega.nextLine();
                                        Livro.pesquisarLivro(ALL, -1, titulo);
                                    }
                                    default -> System.out.println("Opcao invalida, retornando ao menu dos livros");
                                }
                                espera();
                            }
                            case 4 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Lista de Livros       ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();

                                // Listando os livros
                                Livro.mostrarLivros(ALL, 2);
                                System.out.println();
                                System.out.println();
                            }

                            case 5 -> System.out.println("║          VOLTANDO           ║");
                            default -> System.out.println("Opção inválida!");
                        }
                        id = 0;
                        titulo = " ";
                        autor = " ";
                        genero = " ";

                    }
                }
                case 2 -> {
                    escolha = 0;
                    while (escolha != 4) {
                        Menu("UsuariosF");
                        escolha = pega.nextInt();
                        switch (escolha) {
                            case 1 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Registar Leitor        ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();

                                pega.nextLine();
                                System.out.println("Digite o nome");
                                nome = pega.nextLine();
                                System.out.println("Digite o numero de BI");
                                bi = pega.nextLine();
                                
                                nivelacesso = 3;

                                System.out.println("Digite o  email");
                                do {
                                    email = pega.nextLine();
                                } while (Usuario.gmailVerificacao(email) != 0);

                                System.out.println("Digite a senha");
                                do {
                                    senha = pega.nextLine();
                                } while (Usuario.senhaVerificacao(senha) != 0);

                                if (ALU.add(Usuario.inserirUsuario(id_uAutomatico, nome, email, senha, bi, nivelacesso,
                                        true))) {
                                    System.out.println("Usuario registado com sucesso");
                                    id_uAutomatico += 1;
                                } else
                                    System.out.println("Erro ao registar o usuario");
                                espera();
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Leitor      ║");
                                System.out.println("╚══════════════════════════════╝");

                                System.out.println();
                                System.out.println("Digite o ID do usuario");
                                id_usuario = pega.nextInt();
                                if (Usuario.procuraUsuarioId(id_usuario, ALU) != -1) {
                                    pega.nextLine();
                                    System.out.println("Digite o novo nome");
                                    nome = pega.nextLine();
                                    System.out.println("Digite o novo numero de BI");
                                    bi = pega.nextLine();
                                    System.out.println(
                                            "Digite o novo nivel de acesso\n1 - Administrador\n2 - Funcionario\n3 - Leitor\n");

                                    // Leitor
                                    nivelacesso = 3;

                                    System.out.println("Digite o novo email");
                                    do {
                                        email = pega.nextLine();
                                    } while (Usuario.gmailVerificacao(email) != 0);

                                    System.out.println("Digite a nova senha");
                                    do {
                                        senha = pega.nextLine();
                                    } while (Usuario.senhaVerificacao(senha) != 0);

                                    if (Usuario.atualizarUsuario(ALU, id_usuario, nome, email, senha, bi, nivelacesso,
                                            true)) {
                                        System.out.println("Usuario atualizado com sucesso");
                                    } else
                                        System.out.println("Erro ao registar o usuario");

                                }
                                espera();
                            }
                            case 3 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Mostrar Leitor         ║");
                                System.out.println("╚══════════════════════════════╝");
                                Usuario.mostrarUsuarios(ALU, 2);
                            }
                            case 4 -> System.out.println("║          VOLTANDO           ║");
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }
                case 3 -> {
                    escolha = 0;
                    while (escolha != 4) {
                        Menu("EmprestimosF");
                        escolha = pega.nextInt();
                        switch (escolha) {
                            case 1 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Registar Emprestimo     ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();
                                System.out.println("Dados do leitor");
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Devolver Emprestimo     ║");
                                System.out.println("╚══════════════════════════════╝");
                            }
                            case 3 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Mostrar Emprestimo      ║");
                                System.out.println("╚══════════════════════════════╝");
                            }
                            case 4 -> System.out.println("║          VOLTANDO           ║");
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }
                case 0 -> System.out.println("Terminando Sessao...");
                default -> System.out.println("A opção inválida");
            }
        }

        return 0;
    }

    public static int AdministradorDasboard(ArrayList<Livro> ALL, ArrayList<Usuario> ALU) {
        // Objecto para pegar os dados digitados pelo usuário
        Scanner pega = new Scanner(System.in);

        // Lista de livros

        // Variaveis de decisão
        int opcao = -1;
        int escolha = -1;

        // variaveis principais para livro
        int id = 0;
        String titulo = " ";
        String autor = " ";
        String genero = " ";

        // variaveis principais para usuarios

        int id_uAutomatico = ALU.get(Usuario.contaUsuarios(ALU) - 1).getId() + 1;
        int id_usuario = 0;
        String nome = " ";
        String bi = " ";
        String email = " ";
        String senha = " ";
        int nivelacesso = 0;

        while (opcao != 0) {
            // Exibindo o menu principal
            Menu("Administrador");
            opcao = pega.nextInt();

            switch (opcao) {
                case 1 -> {
                    escolha = 0;
                    while (escolha != 6) {
                        Menu("Livros");
                        escolha = pega.nextInt();
                        switch (escolha) {
                            case 1 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Registar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");

                                // Tentando ver se regista mesmo o livro no array

                                System.out.println("Digite o ID do livro");
                                id = pega.nextInt();
                                pega.nextLine();

                                System.out.println("Digite o Titulo do livro");
                                titulo = pega.nextLine();

                                System.out.println("Digite o Autor do livro");
                                autor = pega.nextLine();

                                System.out.println("Digite o Gênero do livro");
                                genero = pega.nextLine();

                                // criando e adicionado o livro a lista

                                if (ALL.add(Livro.inserirLivro(id, titulo, autor, genero, true)))
                                    System.out.println("Registo Efectuado com sucesso");
                                else
                                    System.out.println("Erro ao adicionar o livro");

                                espera();
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");

                                System.out.println("Digite o ID do livro");
                                id = pega.nextInt();
                                pega.nextLine();

                                if (Livro.procuraLivroId(id, ALL) != -1) {
                                    int novoId = 0;
                                    System.out.println("Vai alterar o ID do livro?\ny - sim\nn - nao\n");
                                    if (pega.nextLine().charAt(0) == 'y') {
                                        System.out.println("Digite o novo ID");
                                        novoId = pega.nextInt();

                                    } else {
                                        System.out.println(
                                                "Digitar outra qualquer coisa diferente de y, vai ser considerada como opcao de não alterar o ID");
                                    }

                                    System.out.println("Digite o Novo Titulo: ");
                                    titulo = pega.nextLine();

                                    System.out.println("Digite o Novo Autor do livro: ");
                                    autor = pega.nextLine();

                                    System.out.println("Digite o Novo Gênero do livro: ");
                                    genero = pega.nextLine();

                                    Livro.atualizarLivro(ALL, id, novoId, titulo, autor, genero);

                                    System.out.println("Livro Atualizado com sucesso\n");
                                } else {
                                    System.out.println("O livro que procura atualizar não existe\n");
                                }
                                espera();
                            }
                            case 3 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Pesquisar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");

                                System.out.println("Como vai pesquisar\n1 - ID\n2 - Titulo");
                                switch (pega.nextInt()) {
                                    case 1 -> {
                                        System.out.println("Digite o ID");
                                        id = pega.nextInt();
                                        Livro.pesquisarLivro(ALL, id, " ");
                                    }
                                    case 2 -> {
                                        pega.nextLine();
                                        System.out.println("Digite o Titulo");
                                        titulo = pega.nextLine();
                                        Livro.pesquisarLivro(ALL, -1, titulo);
                                    }
                                    default -> System.out.println("Opcao invalida, retornando ao menu dos livros");
                                }
                                espera();
                            }
                            case 4 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Lista de Livros       ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();

                                // Listando os livros
                                Livro.mostrarLivros(ALL, 1);
                                System.out.println();
                                System.out.println();
                            }
                            case 5 -> {
                                int index = -1;
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Remover Livro         ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println("Como vai pesquisar para remover o livro?\n1 - ID\n2 - Titulo");
                                switch (pega.nextInt()) {
                                    case 1 -> {
                                        System.out.println("Digite o ID");
                                        id = pega.nextInt();
                                        index = Livro.removerLivro(ALL, id, " ");
                                        if (index == 0)
                                            System.out.println("Livro removido com sucesso");

                                        else if (index == 2)
                                            System.out.println("Livro reativado\n");
                                    }
                                    case 2 -> {
                                        pega.nextLine();
                                        System.out.println("Digite o Titulo");
                                        titulo = pega.nextLine();

                                        index = Livro.removerLivro(ALL, -1, titulo);
                                        if (index == 0)
                                            System.out.println("Livro removido com sucesso");
                                        else if (index == 2)
                                            System.out.println("Livro reativado\n");
                                    }
                                    default -> System.out.println("Opcao invalida, retornando ao menu dos livros");
                                }
                                espera();
                            }
                            case 6 -> System.out.println("║          VOLTANDO           ║");
                            default -> System.out.println("Opção inválida!");
                        }
                        id = 0;
                        titulo = " ";
                        autor = " ";
                        genero = " ";

                    }
                }
                case 2 -> {
                    escolha = 0;
                    while (escolha != 6) {
                        Menu("Usuarios");
                        escolha = pega.nextInt();
                        switch (escolha) {
                            case 1 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Registar Usuario       ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();

                                pega.nextLine();
                                System.out.println("Digite o nome");
                                nome = pega.nextLine();
                                System.out.println("Digite o numero de BI");
                                bi = pega.nextLine();
                                System.out.println(
                                        "Digite o nivel de acesso\n1 - Administrador\n2 - Funcionario\n3 - Leitor\n");
                                int decisao = 0;
                                while (true) {

                                    decisao = pega.nextInt();
                                    switch (decisao) {
                                        case 1 -> {
                                            // ADM
                                            nivelacesso = 1;
                                        }
                                        case 2 -> {
                                            // Funcionario
                                            nivelacesso = 2;
                                        }
                                        case 3 -> {
                                            // Leitor
                                            nivelacesso = 3;
                                        }
                                        default -> {
                                            System.out.println("Recusado, escolha um nivel de acesso da lista");
                                        }
                                    }
                                    if (decisao > 0 && decisao < 4)
                                        break;
                                }
                                pega.nextLine();

                                System.out.println("Digite o  email");
                                do {
                                    email = pega.nextLine();
                                } while (Usuario.gmailVerificacao(email) != 0);

                                System.out.println("Digite a senha");
                                do {
                                    senha = pega.nextLine();
                                } while (Usuario.senhaVerificacao(senha) != 0);

                                if (ALU.add(Usuario.inserirUsuario(id_uAutomatico, nome, email, senha, bi, nivelacesso,
                                        true))) {
                                    System.out.println("Usuario registado com sucesso");
                                    id_uAutomatico += 1;
                                } else
                                    System.out.println("Erro ao registar o usuario");
                                espera();
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Usuario      ║");
                                System.out.println("╚══════════════════════════════╝");

                                System.out.println();
                                System.out.println("Digite o ID do usuario");
                                id_usuario = pega.nextInt();
                                if (Usuario.procuraUsuarioId(id_usuario, ALU) != -1) {
                                    pega.nextLine();
                                    System.out.println("Digite o novo nome");
                                    nome = pega.nextLine();
                                    System.out.println("Digite o novo numero de BI");
                                    bi = pega.nextLine();
                                    System.out.println(
                                            "Digite o novo nivel de acesso\n1 - Administrador\n2 - Funcionario\n3 - Leitor\n");
                                    int decisao = 0;
                                    while (true) {

                                        decisao = pega.nextInt();
                                        switch (decisao) {
                                            case 1 -> {
                                                // ADM
                                                nivelacesso = 1;
                                            }
                                            case 2 -> {
                                                // Funcionario
                                                nivelacesso = 2;
                                            }
                                            case 3 -> {
                                                // Leitor
                                                nivelacesso = 3;
                                            }
                                            default -> {
                                                System.out.println("Recusado, escolha um nivel de acesso da lista");
                                            }
                                        }
                                        if (decisao > 0 && decisao < 4)
                                            break;
                                    }
                                    pega.nextLine();

                                    System.out.println("Digite o novo email");
                                    do {
                                        email = pega.nextLine();
                                    } while (Usuario.gmailVerificacao(email) != 0);

                                    System.out.println("Digite a nova senha");
                                    do {
                                        senha = pega.nextLine();
                                    } while (Usuario.senhaVerificacao(senha) != 0);

                                    if (Usuario.atualizarUsuario(ALU, id_usuario, nome, email, senha, bi, nivelacesso,
                                            true)) {
                                        System.out.println("Usuario atualizado com sucesso");
                                    } else
                                        System.out.println("Erro ao registar o usuario");

                                }
                                espera();
                            }
                            case 3 -> {
                                int index = 0;
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║ Bloquear/Desbloquear Usuario ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println("Como vai pesquisar para remover o livro?\n1 - ID\n2 - Titulo");
                                switch (pega.nextInt()) {
                                    case 1 -> {
                                        System.out.println("Digite o ID");
                                        id_usuario = pega.nextInt();
                                        index = Usuario.bloquearDesbloquearUsuario(ALU, id_usuario, " ");
                                        if (index == 0)
                                            System.out.println("Usuario bloqueado com sucesso");
                                        else if (index == -1)
                                            System.out.println("Usuario nao encontrado!!!");
                                        else if (index == 2)
                                            System.out.println("Usuario desbloqueado\n");
                                    }
                                    case 2 -> {
                                        pega.nextLine();
                                        System.out.println("Digite o gmail");
                                        email = pega.nextLine();

                                        index = Usuario.bloquearDesbloquearUsuario(ALU, -1, email);
                                        if (index == 0)
                                            System.out.println("Usuario bloqueado com sucesso");
                                        else if (index == -1)
                                            System.out.println("Usuario nao encontrado!!!");
                                        else if (index == 2)
                                            System.out.println("Usuario desbloquado\n");
                                    }
                                    default -> System.out.println("Opcao invalida, retornando ao menu dos livros");
                                }
                                espera();

                            }
                            case 4 -> {
                                System.out.println(Usuario.contaUsuarios(ALU));
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Remover Usuario        ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();
                                System.out.println("Digite o ID do usuario");
                                if (Usuario.removerUsuario(ALU, pega.nextInt()))
                                    System.out.println("Usuario removido com sucesso");
                                else
                                    System.out.println("Não foi encontrado um usuario com o ID\nFornecido");
                            }
                            case 5 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Mostrar Usuario        ║");
                                System.out.println("╚══════════════════════════════╝");
                                Usuario.mostrarUsuarios(ALU, 1);
                            }
                            case 6 -> System.out.println("║          VOLTANDO           ║");
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }
                case 3 -> {
                    escolha = 0;
                    while (escolha != 4) {
                        Menu("Emprestimos");
                        escolha = pega.nextInt();
                        switch (escolha) {
                            case 1 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Registar Emprestimo     ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();
                                System.out.println("Dados do leitor");
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Devolver Emprestimo     ║");
                                System.out.println("╚══════════════════════════════╝");
                            }
                            case 3 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Mostrar Emprestimo      ║");
                                System.out.println("╚══════════════════════════════╝");
                            }
                            case 4 -> System.out.println("║          VOLTANDO           ║");
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }
                case 0 -> System.out.println("Terminando Sessao...");
                default -> System.out.println("A opção inválida");
            }
        }

        return 0;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Funções de interface exibição">

    public static void Menu(String qual) {
        switch (qual) {
            case "Administrador":
                System.out.println("═════════════════════════════════════════════════");
                System.out.println("       SISTEMA DE GESTÃO DE BIBLIOTECA");
                System.out.println("═════════════════════════════════════════════════");
                System.out.println();

                System.out.println("┌───────────────────────────────────────────────┐");
                System.out.println("│                                               │");
                System.out.println("│   [1]  GESTÃO DE LIVROS                       │");
                System.out.println("│   [2]  GESTÃO DE UTILIZADORES                 │");
                System.out.println("│   [3]  GESTÃO DE EMPRÉSTIMOS                  │");
                System.out.println("│                                               │");
                System.out.println("│   [0]  TERMINAR SESSAO                        │");
                System.out.println("│                                               │");
                System.out.println("└───────────────────────────────────────────────┘");

                System.out.println();
                System.out.println("═════════════════════════════════════════════════");
                System.out.println("    SGB - SEGURANÇA, CONFIANÇA E EFICIÊNCIA");
                System.out.println("═════════════════════════════════════════════════");
                break;
            case "Funcionario":
                System.out.println("═════════════════════════════════════════════════");
                System.out.println("       SISTEMA DE GESTÃO DE BIBLIOTECA");
                System.out.println("═════════════════════════════════════════════════");
                System.out.println();

                System.out.println("┌───────────────────────────────────────────────┐");
                System.out.println("│                                               │");
                System.out.println("│   [1]  GESTÃO DE LIVROS                       │");
                System.out.println("│   [2]  GESTÃO DE UTILIZADORES                 │");
                System.out.println("│   [3]  GESTÃO DE EMPRÉSTIMOS                  │");
                System.out.println("│                                               │");
                System.out.println("│   [0]  TERMINAR SESSAO                        │");
                System.out.println("│                                               │");
                System.out.println("└───────────────────────────────────────────────┘");

                System.out.println();
                System.out.println("═════════════════════════════════════════════════");
                System.out.println("    SGB - SEGURANÇA, CONFIANÇA E EFICIÊNCIA");
                System.out.println("═════════════════════════════════════════════════");
                break;
            case "Leitor":
                System.out.println("═════════════════════════════════════════════════");
                System.out.println("       SISTEMA DE GESTÃO DE BIBLIOTECA");
                System.out.println("═════════════════════════════════════════════════");
                System.out.println();

                System.out.println("┌───────────────────────────────────────────────┐");
                System.out.println("│                                               │");
                System.out.println("│   [1]  CONSULTAR LIVROS DISPONIVEIS           │");
                System.out.println("│   [2]  VER MEUS EMPRÉSTIMOS                   │");
                System.out.println("│                                               │");
                System.out.println("│   [0]  TERMINAR SESSAO                        │");
                System.out.println("│                                               │");
                System.out.println("└───────────────────────────────────────────────┘");

                System.out.println();
                System.out.println("═════════════════════════════════════════════════");
                System.out.println("    SGB - SEGURANÇA, CONFIANÇA E EFICIÊNCIA");
                System.out.println("═════════════════════════════════════════════════");
                break;
            case "Livros":
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║            LIVROS            ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  [1] Registar                ║");
                System.out.println("║  [2] Atualizar               ║");
                System.out.println("║  [3] Pesquisar               ║");
                System.out.println("║  [4] Mostrar                 ║");
                System.out.println("║  [5] Remover                 ║");
                System.out.println("║  [6] Voltar                  ║");
                System.out.println("╚══════════════════════════════╝");
                break;
            case "Usuarios":
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║           Usuario            ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  [1] Registar                ║");
                System.out.println("║  [2] Atualizar               ║");
                System.out.println("║  [3] Bloquear/Desbloquear    ║");
                System.out.println("║  [4] Remover                 ║");
                System.out.println("║  [5] Mostrar                 ║");
                System.out.println("║  [6] Voltar                  ║");
                System.out.println("╚══════════════════════════════╝");
                break;
            case "Emprestimos":
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║          EMPRESTIMO          ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  [1] Registar                ║");
                System.out.println("║  [2] Devolver                ║");
                System.out.println("║  [3] Mostrar                 ║");
                System.out.println("║  [4] Voltar                  ║");
                System.out.println("╚══════════════════════════════╝");
                break;
            case "LivrosF":
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║            LIVROS            ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  [1] Registar                ║");
                System.out.println("║  [2] Atualizar               ║");
                System.out.println("║  [3] Pesquisar               ║");
                System.out.println("║  [4] Mostrar                 ║");
                System.out.println("║  [5] Voltar                  ║");
                System.out.println("╚══════════════════════════════╝");
                break;
            case "UsuariosF":
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║           Usuario            ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  [1] Registar                ║");
                System.out.println("║  [2] Atualizar               ║");
                System.out.println("║  [3] Mostrar                 ║");
                System.out.println("║  [4] Voltar                  ║");
                System.out.println("╚══════════════════════════════╝");
                break;
            case "EmprestimosF":
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║          EMPRESTIMO          ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  [1] Registar                ║");
                System.out.println("║  [2] Devolver                ║");
                System.out.println("║  [3] Mostrar                 ║");
                System.out.println("║  [4] Voltar                  ║");
                System.out.println("╚══════════════════════════════╝");
                break;

        }
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Utilitáios">

    public static void espera() {
        try {
            Thread.sleep(3000); // 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String limitarTexto(String texto, int limite) {
        if (texto == null)
            return "";
        if (texto.length() <= limite)
            return texto;
        return texto.substring(0, limite - 3) + "...";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Função principal">
    public static int bbtc() {

        // Área dos ArrayLists
        ArrayList<Livro> ALL = new ArrayList<>();
        ArrayList<Usuario> ALU = new ArrayList<>();

        // Área das funções de carregar ficheiro

        // Parte de execução do sistema
        int index = -1;
        int nivel = -1;
        do {

            index = login(ALU);
            if (index != -1) {
                nivel = ALU.get(index).getNivelacesso();

                if (nivel == 1)
                    AdministradorDasboard(ALL, ALU);
                else if (nivel == 2)
                    FuncionarioDashboard(ALL, ALU);
                else if (nivel == 3)
                    LeitorDasboard(ALL);
            }

        } while (index != -1);

        return 0;
    }

    // </editor-fold>

}
