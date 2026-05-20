/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgb;

import java.util.Scanner;

/**
 *
 * @author critical-trojan
 */
public class Biblioteca {
       
    public static int verificaAcesso()
    {
        Scanner pega = new Scanner(System.in);
        int i=10;
       while(i>=1) {
            //pegando os dados
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║        INICIAR SESSÃO        ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("Tentativas: "+i);
            System.out.println();
            System.out.println("        DIGITE O EMAIL");
            System.out.println("═════════════════════════════");
            String email = pega.nextLine();
        
            System.out.println("        DIGITE A SENHA");
            System.out.println("═════════════════════════════");
            String senha = pega.nextLine();
        
            //verificando os dados
            if(email.compareTo("rodolfo@gmail.com")==0 && senha.compareTo("123") == 0)
                return 1;
            else if(email.compareTo("milly@gmail.com")==0 && senha.compareTo("123") == 0)
                return 2;
            else
                System.out.println("E-mail ou Senha incorreta");
            i--;
       }
        return 0;
    }
    public static int LeitorDasboard()
    {
         //Objecto para pegar os dados digitados pelo usuário
        Scanner pega = new Scanner(System.in);
        
        //Variaveis de decisão
        int opcao = -1;
        int escolha = -1;
        
        
        //Atenção, como as opções do leitor são directas, não têm opcoes dentro de opcoes, entao não é necessário
        // construir toda ela por enquanto
        
        //while(opcao != 0)
        //{
            //Exibindo o menu principal
            Menu("Leitor");
            
            
            /*opcao = pega.nextInt();

            switch(opcao)
            {
                case 1:
                    escolha = 0;
                    while(escolha != 6)
                    {
                        Menu("Livros");
                        escolha = pega.nextInt();
                        switch(escolha)
                        {
                            case 1:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Registar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 2:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 3:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Pesquisar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 4:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Mostrar Livro         ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 5:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Remover Livro         ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 6:
                                 System.out.println("║          VOLTANDO           ║");
                            break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                break;
                case 2:
                    escolha = 0;
                    while(escolha != 6)
                    {
                        Menu("Usuarios");
                        escolha = pega.nextInt();
                        switch(escolha)
                        {
                            case 1:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Registar Usuario       ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 2:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Usuario      ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 3:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Bloquear Usuario      ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 4:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Remover Usuario        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 5:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Mostrar Usuario        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 6:
                                 System.out.println("║          VOLTANDO           ║");
                            break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                break;
                case 3:
                    escolha = 0;
                    while(escolha != 4)
                    {
                        Menu("Emprestimos");
                        escolha = pega.nextInt();
                        switch(escolha)
                        {
                            case 1:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Registar Emprestimo     ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();
                                System.out.println("Dados do leitor");
                            break;
                            case 2:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Devolver Emprestimo     ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 3:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Mostrar Emprestimo      ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 4:
                                 System.out.println("║          VOLTANDO           ║");
                            break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                break;
                default:
                    System.out.println("A opção inválida");
            }
        }
        */
        return 0;
    }
        
    public static int AdministradorDasboard()
    {
         //Objecto para pegar os dados digitados pelo usuário
        Scanner pega = new Scanner(System.in);
        
        //Variaveis de decisão
        int opcao = -1;
        int escolha = -1;
        
        while(opcao != 0)
        {
            //Exibindo o menu principal
            Menu("Administrador");
            opcao = pega.nextInt();

            switch(opcao)
            {
                case 1:
                    escolha = 0;
                    while(escolha != 6)
                    {
                        Menu("Livros");
                        escolha = pega.nextInt();
                        switch(escolha)
                        {
                            case 1:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Registar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 2:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 3:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Pesquisar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 4:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Mostrar Livro         ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 5:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Remover Livro         ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 6:
                                 System.out.println("║          VOLTANDO           ║");
                            break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                break;
                case 2:
                    escolha = 0;
                    while(escolha != 6)
                    {
                        Menu("Usuarios");
                        escolha = pega.nextInt();
                        switch(escolha)
                        {
                            case 1:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Registar Usuario       ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 2:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Usuario      ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 3:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Bloquear Usuario      ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 4:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Remover Usuario        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 5:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Mostrar Usuario        ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 6:
                                 System.out.println("║          VOLTANDO           ║");
                            break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                break;
                case 3:
                    escolha = 0;
                    while(escolha != 4)
                    {
                        Menu("Emprestimos");
                        escolha = pega.nextInt();
                        switch(escolha)
                        {
                            case 1:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Registar Emprestimo     ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();
                                System.out.println("Dados do leitor");
                            break;
                            case 2:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Devolver Emprestimo     ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 3:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║      Mostrar Emprestimo      ║");
                                System.out.println("╚══════════════════════════════╝");
                            break;
                            case 4:
                                 System.out.println("║          VOLTANDO           ║");
                            break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
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
    
    public static int bbtc()
    {
       if(verificaAcesso() == 1)
           AdministradorDasboard();
       else if(verificaAcesso() == 2)
           LeitorDasboard();
           
        return 0;
    }
    
    
    public static void Menu(String qual)
    {
     switch(qual)
     {
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
                System.out.println("│   [0]  SAIR DO SISTEMA                        │");
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
                System.out.println("│   [2]  PESQUISAR LIVRO                        │");
                System.out.println("│   [2]  SOLICITAR EMPRÉSTIMO                   │");
                System.out.println("│   [2]  DEVOLVER LIVRO                         │");
                System.out.println("│   [3]  VER MEUS EMPRÉSTIMOS                   │");
                System.out.println("│                                               │");
                System.out.println("│   [0]  SAIR DO SISTEMA                        │");
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
                System.out.println("║  [3] Bloquear                ║");
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
         
     }
    }
}
