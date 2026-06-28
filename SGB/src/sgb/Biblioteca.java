package sgb;

import Utilizadores.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import dados.Ficheiro;

public class Biblioteca {

    public static Scanner pega = new Scanner(System.in);

    // <editor-fold defaultstate="collapsed" desc="Funções de Acesso">

    public static int login(ArrayList<Usuario> ALU) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║             LOGIN            ║");
            System.out.println("╠══════════════════════════════╣");

            if (!ALU.isEmpty())
                System.out.println("║  [1] Iniciar Sessao          ║");
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
                case 3 -> recuperarSenha(ALU);
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Escolha uma das opcoes acima citados");
            }
        }
        return -1;
    }

    public static boolean cadastraSe(ArrayList<Usuario> ALU) {
        int id_usuario = 0;
        String nome, bi, email, senha;
        int nivelacesso;

        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║                   !!AVISOS!!                ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║ [!] Registo pela primeira vez:              ║");
        System.out.println("║ O primeiro usuario sera o ADM.              ║");
        System.out.println("║ Email valido: nome@gmail.com                ║");
        System.out.println("║ BI valido (Angola): 003590748LA033          ║");
        System.out.println("║ Senha: >=9 chars, 1 numero e 1 simbolo.     ║");
        System.out.println("╚═════════════════════════════════════════════╝");
        espera();
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║         CADASTRAR-SE         ║");
        System.out.println("╚══════════════════════════════╝\n");

        pega.nextLine();

        System.out.println("Digite o nome");
        nome = pega.nextLine();
        System.out.println("Digite o numero de BI");
        bi = lerBi();

        nivelacesso = 1;

        System.out.println("Digite o email");
        email = lerEmail();

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
        int i = 10;
        while (i >= 1) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║        INICIAR SESSÃO        ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("Tentativas: " + i + "\n");
            pega.nextLine();
            System.out.println("        DIGITE O EMAIL");
            System.out.println("═════════════════════════════");
            String email = pega.nextLine();
            System.out.println("\n        DIGITE A SENHA");
            System.out.println("═════════════════════════════");
            String senha = pega.nextLine();

            int index = Usuario.validarAcesso(ALU, email, senha);
            if (index != -1)
                return index;
            else
                System.out.println("E-mail ou Senha incorreta");
            i--;
        }
        if (i < 1)
            System.out.println("Numero maximo de tentativas excedidas!!!\nEncerrando o sistema!\n");
        return 0;
    }

    public static void recuperarSenha(ArrayList<Usuario> ALU) {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║       RECUPERAR SENHA        ║");
        System.out.println("╚══════════════════════════════╝");

        pega.nextLine();
        System.out.println("Digite o seu email:");
        String email = lerEmail();
        int index = Usuario.procuraUsuarioGmail(email, ALU);
        if (index == -1) {
            System.out.println("Nao existe conta com esse email.");
            espera();
            return;
        }

        System.out.println("Digite o seu numero de BI para confirmar:");
        String bi = lerBi();
        if (!ALU.get(index).getBi().equalsIgnoreCase(bi)) {
            System.out.println("BI nao corresponde a esta conta. Operacao cancelada.");
            espera();
            return;
        }

        System.out.println("Digite a nova senha:");
        String nova;
        do {
            nova = pega.nextLine();
        } while (Usuario.senhaVerificacao(nova) != 0);

        ALU.get(index).setSenha(nova);
        System.out.println("Senha alterada com sucesso!");
        espera();
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Dashborads">
    public static int LeitorDasboard(ArrayList<Livro> ALL) {
        int opcao = -1;
        while (opcao != 0) {
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
                    Emprestimo.mostrarEmprestimos(Emprestimo.AEMP);
                    System.out.println("\n\n\n");
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
        int opcao = -1;
        int escolha;

        long id = 0;
        String titulo = " ", autor = " ", genero = " ";

        int id_uAutomatico = ALU.get(Usuario.contaUsuarios(ALU) - 1).getId() + 1;
        int id_usuario;
        String nome, bi, email, senha;
        int nivelacesso;

        while (opcao != 0) {
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
                                System.out.println("Digite o ISBN-13 do livro (Ex: 9789720000000)");
                                id = lerIsbn();
                                System.out.println("Digite o Titulo do livro");
                                titulo = pega.nextLine();
                                System.out.println("Digite o Autor do livro");
                                autor = pega.nextLine();
                                System.out.println("Digite o Gênero do livro");
                                genero = pega.nextLine();
                                if (ALL.add(Livro.inserirLivro(id, titulo, autor, genero, true))) {
                                    System.out.println("Registo Efectuado com sucesso");
                                } else
                                    System.out.println("Erro ao adicionar o livro");
                                espera();
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println("Digite o ISBN-13 do livro");
                                id = lerIsbn();
                                if (Livro.procuraLivroId(id, ALL) != -1) {
                                    long novoId = 0;
                                    System.out.println("Vai alterar o ISBN do livro?\ny - sim\nn - nao");
                                    if (pega.nextLine().charAt(0) == 'y') {
                                        System.out.println("Digite o novo ISBN-13");
                                        novoId = lerIsbn();
                                    }
                                    System.out.println("Digite o Novo Titulo: ");
                                    titulo = pega.nextLine();
                                    System.out.println("Digite o Novo Autor do livro: ");
                                    autor = pega.nextLine();
                                    System.out.println("Digite o Novo Gênero do livro: ");
                                    genero = pega.nextLine();
                                    Livro.atualizarLivro(ALL, id, novoId, titulo, autor, genero);
                                    System.out.println("Livro Atualizado com sucesso\n");
                                } else
                                    System.out.println("O livro que procura atualizar não existe\n");
                                espera();
                            }
                            case 3 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Pesquisar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println("Como vai pesquisar\n1 - ISBN\n2 - Titulo");
                                switch (pega.nextInt()) {
                                    case 1 -> {
                                        System.out.println("Digite o ISBN-13");
                                        id = lerIsbn();
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
                                Livro.mostrarLivros(ALL, 2);
                                System.out.println("\n");
                            }
                            case 5 -> System.out.println("║          VOLTANDO           ║");
                            default -> System.out.println("Opção inválida!");
                        }
                        id = 0; titulo = " "; autor = " "; genero = " ";
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
                                System.out.println("╚══════════════════════════════╝\n");
                                pega.nextLine();
                                System.out.println("Digite o nome");
                                nome = pega.nextLine();
                                System.out.println("Digite o numero de BI");
                                bi = lerBi();
                                nivelacesso = 3;
                                System.out.println("Digite o email");
                                email = lerEmail();
                                System.out.println("Digite a senha");
                                do { senha = pega.nextLine(); } while (Usuario.senhaVerificacao(senha) != 0);
                                if (ALU.add(Usuario.inserirUsuario(id_uAutomatico, nome, email, senha, bi, nivelacesso, true))) {
                                    System.out.println("Usuario registado com sucesso");
                                    id_uAutomatico += 1;
                                } else
                                    System.out.println("Erro ao registar o usuario");
                                espera();
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Leitor      ║");
                                System.out.println("╚══════════════════════════════╝\n");
                                System.out.println("Digite o ID do usuario");
                                id_usuario = pega.nextInt();
                                if (Usuario.procuraUsuarioId(id_usuario, ALU) != -1) {
                                    pega.nextLine();
                                    System.out.println("Digite o novo nome");
                                    nome = pega.nextLine();
                                    System.out.println("Digite o novo numero de BI");
                                    bi = lerBi();
                                    nivelacesso = 3;
                                    System.out.println("Digite o novo email");
                                    email = lerEmail();
                                    System.out.println("Digite a nova senha");
                                    do { senha = pega.nextLine(); } while (Usuario.senhaVerificacao(senha) != 0);
                                    if (Usuario.atualizarUsuario(ALU, id_usuario, nome, email, senha, bi, nivelacesso, true)) {
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
                case 3 -> menuEmprestimos(ALU,ALL, "EmprestimosF");
                case 0 -> System.out.println("Terminando Sessao...");
                default -> System.out.println("A opção inválida");
            }
        }
        return 0;
    }

    public static int AdministradorDasboard(ArrayList<Livro> ALL, ArrayList<Usuario> ALU) {
        int opcao = -1;
        int escolha;

        long id = 0;
        String titulo = " ", autor = " ", genero = " ";

        int id_uAutomatico = ALU.get(Usuario.contaUsuarios(ALU) - 1).getId() + 1;
        int id_usuario;
        String nome, bi, email, senha;
        int nivelacesso;

        while (opcao != 0) {
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
                                System.out.println("Digite o ISBN-13 do livro (Ex: 9789720000000)");
                                id = lerIsbn();
                                System.out.println("Digite o Titulo do livro");
                                titulo = pega.nextLine();
                                System.out.println("Digite o Autor do livro");
                                autor = pega.nextLine();
                                System.out.println("Digite o Gênero do livro");
                                genero = pega.nextLine();
                                if (ALL.add(Livro.inserirLivro(id, titulo, autor, genero, true))) {
                                    System.out.println("Registo Efectuado com sucesso");
                                } else
                                    System.out.println("Erro ao adicionar o livro");
                                espera();
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println("Digite o ISBN-13 do livro");
                                id = lerIsbn();
                                if (Livro.procuraLivroId(id, ALL) != -1) {
                                    long novoId = 0;
                                    System.out.println("Vai alterar o ISBN do livro?\ny - sim\nn - nao");
                                    if (pega.nextLine().charAt(0) == 'y') {
                                        System.out.println("Digite o novo ISBN-13");
                                        novoId = lerIsbn();
                                    }
                                    System.out.println("Digite o Novo Titulo: ");
                                    titulo = pega.nextLine();
                                    System.out.println("Digite o Novo Autor do livro: ");
                                    autor = pega.nextLine();
                                    System.out.println("Digite o Novo Gênero do livro: ");
                                    genero = pega.nextLine();
                                    Livro.atualizarLivro(ALL, id, novoId, titulo, autor, genero);
                                    System.out.println("Livro Atualizado com sucesso\n");
                                } else
                                    System.out.println("O livro que procura atualizar não existe\n");
                                espera();
                            }
                            case 3 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Pesquisar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println("Como vai pesquisar\n1 - ISBN\n2 - Titulo");
                                switch (pega.nextInt()) {
                                    case 1 -> {
                                        System.out.println("Digite o ISBN-13");
                                        id = lerIsbn();
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
                                Livro.mostrarLivros(ALL, 1);
                                System.out.println("\n");
                            }
                            case 5 -> {
                                int index;
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Remover Livro         ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println("Como vai pesquisar?\n1 - ISBN\n2 - Titulo");
                                switch (pega.nextInt()) {
                                    case 1 -> {
                                        System.out.println("Digite o ISBN-13");
                                        id = lerIsbn();
                                        index = Livro.removerLivro(ALL, id, " ");
                                        if (index == 0) System.out.println("Livro removido com sucesso");
                                        else if (index == 2) System.out.println("Livro reativado\n");
                                    }
                                    case 2 -> {
                                        pega.nextLine();
                                        System.out.println("Digite o Titulo");
                                        titulo = pega.nextLine();
                                        index = Livro.removerLivro(ALL, -1, titulo);
                                        if (index == 0) System.out.println("Livro removido com sucesso");
                                        else if (index == 2) System.out.println("Livro reativado\n");
                                    }
                                    default -> System.out.println("Opcao invalida, retornando ao menu dos livros");
                                }
                                espera();
                            }
                            case 6 -> System.out.println("║          VOLTANDO           ║");
                            default -> System.out.println("Opção inválida!");
                        }
                        id = 0; titulo = " "; autor = " "; genero = " ";
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
                                System.out.println("╚══════════════════════════════╝\n");
                                pega.nextLine();
                                System.out.println("Digite o nome");
                                nome = pega.nextLine();
                                System.out.println("Digite o numero de BI");
                                bi = lerBi();
                                System.out.println("Nivel de acesso\n1 - Administrador\n2 - Funcionario\n3 - Leitor");
                                nivelacesso = lerNivelAcesso();
                                System.out.println("Digite o email");
                                email = lerEmail();
                                System.out.println("Digite a senha");
                                do { senha = pega.nextLine(); } while (Usuario.senhaVerificacao(senha) != 0);
                                if (ALU.add(Usuario.inserirUsuario(id_uAutomatico, nome, email, senha, bi, nivelacesso, true))) {
                                    System.out.println("Usuario registado com sucesso");
                                    id_uAutomatico += 1;
                                } else
                                    System.out.println("Erro ao registar o usuario");
                                espera();
                            }
                            case 2 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Usuario      ║");
                                System.out.println("╚══════════════════════════════╝\n");
                                System.out.println("Digite o ID do usuario");
                                id_usuario = pega.nextInt();
                                if (Usuario.procuraUsuarioId(id_usuario, ALU) != -1) {
                                    pega.nextLine();
                                    System.out.println("Digite o novo nome");
                                    nome = pega.nextLine();
                                    System.out.println("Digite o novo numero de BI");
                                    bi = lerBi();
                                    System.out.println("Nivel de acesso\n1 - Administrador\n2 - Funcionario\n3 - Leitor");
                                    nivelacesso = lerNivelAcesso();
                                    System.out.println("Digite o novo email");
                                    email = lerEmail();
                                    System.out.println("Digite a nova senha");
                                    do { senha = pega.nextLine(); } while (Usuario.senhaVerificacao(senha) != 0);
                                    if (Usuario.atualizarUsuario(ALU, id_usuario, nome, email, senha, bi, nivelacesso, true)) {
                                        System.out.println("Usuario atualizado com sucesso");
                                    } else
                                        System.out.println("Erro ao registar o usuario");
                                }
                                espera();
                            }
                            case 3 -> {
                                int index;
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║ Bloquear/Desbloquear Usuario ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println("Como vai pesquisar?\n1 - ID\n2 - Email");
                                switch (pega.nextInt()) {
                                    case 1 -> {
                                        System.out.println("Digite o ID");
                                        id_usuario = pega.nextInt();
                                        index = Usuario.bloquearDesbloquearUsuario(ALU, id_usuario, " ");
                                        if (index == 0) System.out.println("Usuario bloqueado com sucesso");
                                        else if (index == -1) System.out.println("Usuario nao encontrado!!!");
                                        else if (index == 2) System.out.println("Usuario desbloqueado\n");
                                    }
                                    case 2 -> {
                                        pega.nextLine();
                                        System.out.println("Digite o email");
                                        email = pega.nextLine();
                                        index = Usuario.bloquearDesbloquearUsuario(ALU, -1, email);
                                        if (index == 0) System.out.println("Usuario bloqueado com sucesso");
                                        else if (index == -1) System.out.println("Usuario nao encontrado!!!");
                                        else if (index == 2) System.out.println("Usuario desbloqueado\n");
                                    }
                                    default -> System.out.println("Opcao invalida");
                                }
                                espera();
                            }
                            case 4 -> {
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Remover Usuario        ║");
                                System.out.println("╚══════════════════════════════╝\n");
                                System.out.println("Digite o ID do usuario");
                                if (Usuario.removerUsuario(ALU, pega.nextInt())) {
                                    System.out.println("Usuario removido com sucesso");
                                } else
                                    System.out.println("Não foi encontrado um usuario com o ID fornecido");
                                espera();
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
                case 3 -> menuEmprestimos(ALU,ALL, "Emprestimos");
                case 0 -> System.out.println("Terminando Sessao...");
                default -> System.out.println("A opção inválida");
            }
        }
        return 0;
    }

    private static void menuEmprestimos(ArrayList<Usuario> ALU,ArrayList <Livro> ALL, String qualMenu) {
        int escolha = 0;
        while (escolha != 5) {
            Menu(qualMenu);
            escolha = pega.nextInt();
            switch (escolha) {
                case 1 -> {
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║      Registar Emprestimo     ║");
                    System.out.println("╚══════════════════════════════╝");
                    System.out.println("Dados do leitor");
                    pega.nextLine();
                    System.out.println("Email do leitor:");
                    String emailEmp = lerEmail();
                    System.out.println("Senha do leitor:");
                    String senhaEmp = pega.nextLine();
                    System.out.println("Titulo do livro:");
                    String livroEmp = pega.nextLine();
                    if(Livro.procuraLivroTitulo(livroEmp, ALL) ==-1)
                    {
                        System.out.println("O livro que deseja não foi encontrado\nEncerrando processo de emprestimo\n");
                    }
                    else
                    {
                        System.out.println("Data de devolucao (Ex: 2026-07-10):");
                        String dataDevEmp = pega.nextLine();
                        Emprestimo.adicionarEmprestimo(Emprestimo.AEMP, ALU,ALL, livroEmp, emailEmp, senhaEmp, dataDevEmp);
                    
                    }
                    espera();
                }
                case 2 -> {
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║      Devolver Emprestimo     ║");
                    System.out.println("╚══════════════════════════════╝");
                    System.out.println("Digite o ID do emprestimo:");
                    int idEmp = pega.nextInt();
                    Emprestimo.devolverLivro(Emprestimo.AEMP, idEmp);
                    espera();
                }
                case 3 -> {
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║      Mostrar Emprestimo      ║");
                    System.out.println("╚══════════════════════════════╝");
                    Emprestimo.mostrarEmprestimos(Emprestimo.AEMP);
                    espera();
                }
                case 4 -> {
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║          Ver Multa           ║");
                    System.out.println("╚══════════════════════════════╝");
                    System.out.println("Digite o ID do emprestimo:");
                    int idMulta = pega.nextInt();
                    Emprestimo.mostrarMulta(Emprestimo.AEMP, idMulta);
                    espera();
                }
                case 5 -> System.out.println("║          VOLTANDO           ║");
                default -> System.out.println("Opção inválida!");
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Validacoes por regex">

    public static String lerEmail() {
        while (true) {
            String e = pega.nextLine();
            if (e.trim().isEmpty()) continue;
            if (e.matches("[\\w.+-]+@[\\w-]+\\.[\\w.-]+")) return e;
            System.out.println("Email invalido. Ex: nome@gmail.com");
        }
    }

    public static String lerBi() {
        while (true) {
            String b = pega.nextLine();
            if (b.trim().isEmpty()) continue;
            if (b.matches("\\d{9}[A-Za-z]{2}\\d{3}")) return b.toUpperCase();
            System.out.println("BI invalido. Ex: 003590748LA033");
        }
    }

    public static long lerIsbn() {
        while (true) {
            String s = pega.nextLine();
            if (s.trim().isEmpty()) continue;
            if (s.matches("\\d{13}")) return Long.parseLong(s);
            System.out.println("ISBN-13 invalido. Deve ter 13 digitos. Ex: 9789720000000");
        }
    }

    private static int lerNivelAcesso() {
        while (true) {
            int d = pega.nextInt();
            if (d >= 1 && d <= 3) { pega.nextLine(); return d; }
            System.out.println("Recusado, escolha 1, 2 ou 3");
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Funções de interface exibição">

    public static void Menu(String qual) {
        switch (qual) {
            case "Administrador", "Funcionario" -> {
                System.out.println("═════════════════════════════════════════════════");
                System.out.println("       SISTEMA DE GESTÃO DE BIBLIOTECA");
                System.out.println("═════════════════════════════════════════════════\n");
                System.out.println("┌───────────────────────────────────────────────┐");
                System.out.println("│   [1]  GESTÃO DE LIVROS                       │");
                System.out.println("│   [2]  GESTÃO DE UTILIZADORES                 │");
                System.out.println("│   [3]  GESTÃO DE EMPRÉSTIMOS                  │");
                System.out.println("│   [0]  TERMINAR SESSAO                        │");
                System.out.println("└───────────────────────────────────────────────┘");
                System.out.println("\n═════════════════════════════════════════════════");
                System.out.println("    SGB - SEGURANÇA, CONFIANÇA E EFICIÊNCIA");
                System.out.println("═════════════════════════════════════════════════");
            }
            case "Leitor" -> {
                System.out.println("═════════════════════════════════════════════════");
                System.out.println("       SISTEMA DE GESTÃO DE BIBLIOTECA");
                System.out.println("═════════════════════════════════════════════════\n");
                System.out.println("┌───────────────────────────────────────────────┐");
                System.out.println("│   [1]  CONSULTAR LIVROS DISPONIVEIS           │");
                System.out.println("│   [2]  VER MEUS EMPRÉSTIMOS                   │");
                System.out.println("│   [0]  TERMINAR SESSAO                        │");
                System.out.println("└───────────────────────────────────────────────┘");
            }
            case "Livros" -> {
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
            }
            case "Usuarios" -> {
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
            }
            case "Emprestimos", "EmprestimosF" -> {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║          EMPRESTIMO          ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  [1] Registar                ║");
                System.out.println("║  [2] Devolver                ║");
                System.out.println("║  [3] Mostrar                 ║");
                System.out.println("║  [4] Multa                   ║");
                System.out.println("║  [5] Voltar                  ║");
                System.out.println("╚══════════════════════════════╝");
            }
            case "LivrosF" -> {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║            LIVROS            ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  [1] Registar                ║");
                System.out.println("║  [2] Atualizar               ║");
                System.out.println("║  [3] Pesquisar               ║");
                System.out.println("║  [4] Mostrar                 ║");
                System.out.println("║  [5] Voltar                  ║");
                System.out.println("╚══════════════════════════════╝");
            }
            case "UsuariosF" -> {
                System.out.println("╔══════════════════════════════╗");
                System.out.println("║           Usuario            ║");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("║  [1] Registar                ║");
                System.out.println("║  [2] Atualizar               ║");
                System.out.println("║  [3] Mostrar                 ║");
                System.out.println("║  [4] Voltar                  ║");
                System.out.println("╚══════════════════════════════╝");
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Utilitáios">
    public static void espera() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String limitarTexto(String texto, int limite) {
        if (texto == null) return "";
        if (texto.length() <= limite) return texto;
        return texto.substring(0, limite - 3) + "...";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Função principal">
    public static int bbtc() {
        // Usa as listas "donas" de cada classe (carregadas pelo Ficheiro)
        ArrayList<Livro> ALL = Livro.ALL;
        ArrayList<Usuario> ALU = Usuario.ALU;

        int index = -1;
        int nivel;
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