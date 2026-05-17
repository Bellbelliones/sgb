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
    
    public static int bbtc()
    {
        //Objecto para pegar os dados digitados pelo usuário
        Scanner pega = new Scanner(System.in);
        
        //Variaveis principais
        int opcao = 0;
        int escolha = 0;
        
        while(opcao != -1)
        {
            //Exibindo o menu principal
            Menu("Principal");
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
                case -1:
                    System.out.println("Encerrando o sistema...");
                break;
                default:
                    System.out.println("A opção inválida");
            }
        }
        
        
        return 0;
    }
    
    
    public static void Menu(String qual)
    {
     switch(qual)
     {
         case "Principal":
                System.out.println("═════════════════════════════════════════════════");
                System.out.println("       SISTEMA DE GESTÃO DE BIBLIOTECA");
                System.out.println("═════════════════════════════════════════════════");
                System.out.println();

                System.out.println("┌───────────────────────────────────────────────┐");
                System.out.println("│                                               │");
                System.out.println("│   [1]  LIVROS                                 │");
                System.out.println("│   [2]  LEITORES                               │");
                System.out.println("│   [3]  EMPRÉSTIMOS                            │");
                System.out.println("│                                               │");
                System.out.println("│   [-1]  SAIR DO SISTEMA                       │");
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
