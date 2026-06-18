/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgb;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author critical-trojan
 */
public class Biblioteca {

    // <editor-fold defaultstate="collapsed" desc="Funções de Acesso">
   
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
           System.out.println();
           System.out.println();
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
    
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Funções de interface exibição">
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
        
        //Lista de livros
        ArrayList<Livro> ALL = new ArrayList<>();
        
        //Variaveis de decisão
        int opcao = -1;
        int escolha = -1;
        
        while(opcao != 0)
        {
            //Exibindo o menu principal
            Menu("Administrador");
            opcao = pega.nextInt();
            
            
            //variaveis principais
            int id =0;
            String titulo = " ";
            String autor = " ";
            String genero = " ";
                                

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
                                
                                //Tentando ver se regista mesmo o livro no array
                                
                                System.out.println("Digite o ID do livro");
                                id = pega.nextInt();
                                pega.nextLine();
                                
                                System.out.println("Digite o Titulo do livro");
                                titulo = pega.nextLine();
                                
                                System.out.println("Digite o Autor do livro");
                                autor = pega.nextLine();
                                
                                System.out.println("Digite o Gênero do livro");
                                genero = pega.nextLine();
                                
                                //criando e adicionado o livro a lista
                                
                                if(ALL.add(inserirLivro(id, titulo, autor, genero, true)))
                                    System.out.println("Registo Efectuado com sucesso");
                                else
                                    System.out.println("Erro ao adicionar o livro");
                                
                                espera();
                                
                                
                                
                                    
                                    
                            break;
                            case 2:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Atualizar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                                
                                System.out.println("Digite o ID do livro");
                                id = pega.nextInt();
                                pega.nextLine();
                                
                                if(procuraLivroId(id, ALL)!= -1)
                                {
                                    int novoId= 0;
                                    System.out.println("Vai alterar o ID do livro?\ny - sim\nn - nao\n");
                                    if(pega.nextLine().charAt(0) == 'y')
                                    {
                                        System.out.println("Digite o novo ID");
                                        novoId = pega.nextInt();
                                        
                                    }
                                    else
                                    {
                                        System.out.println("Digitar outra qualquer coisa diferente de y, vai ser considerada como opcao de não alterar o ID");
                                    }
                                            
                                    System.out.println("Digite o Novo Titulo: ");
                                    titulo = pega.nextLine();

                                    System.out.println("Digite o Novo Autor do livro: ");
                                    autor = pega.nextLine();

                                    System.out.println("Digite o Novo Gênero do livro: ");
                                    genero = pega.nextLine();


                                    atualizarLivro(ALL, id, novoId, titulo, autor, genero);
                                    
                                    
                                    System.out.println("Livro Atualizado com sucesso\n");
                                }
                                else
                                {
                                    System.out.println("O livro que procura atualizar não existe\n");
                                }
                                espera();
                                
                                
                            break;
                            case 3:
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║       Pesquisar Livro        ║");
                                System.out.println("╚══════════════════════════════╝");
                                
                                System.out.println("Como vai pesquisar\n1 - ID\n2 - Titulo");
                                switch(pega.nextInt())
                                {
                                    case 1:
                                        System.out.println("Digite o ID");
                                        id= pega.nextInt();
                                        pesquisarLivro(ALL, id, " ");
                                           
                                    break;
                                    case 2:
                                        pega.nextLine();
                                        System.out.println("Digite o Titulo");
                                        titulo = pega.nextLine();
                                        pesquisarLivro(ALL, -1, titulo);
                                    break;
                                    default:
                                        System.out.println("Opcao invalida, retornando ao menu dos livros");
                                }
                                    espera();
                            break;
                            case 4:
                                
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Lista de Livros       ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println();
                                
                                //Listando os livros
                                mostrarLivros(ALL);
                                System.out.println();
                                System.out.println();
                                
                            break;
                            case 5:
                                int index =-1;
                                System.out.println("╔══════════════════════════════╗");
                                System.out.println("║        Remover Livro         ║");
                                System.out.println("╚══════════════════════════════╝");
                                System.out.println("Como vai pesquisar para remover o livro?\n1 - ID\n2 - Titulo");
                                switch(pega.nextInt())
                                {
                                    case 1:
                                        System.out.println("Digite o ID");
                                        id= pega.nextInt();
                                        index = removerLivro(ALL, id, " ");
                                        if(index == 0)
                                            System.out.println("Livro removido com sucesso");
                                           
                                        else if(index == 2)
                                            System.out.println("Livro reativado\n");
                                    break;
                                    case 2:
                                        pega.nextLine();
                                        System.out.println("Digite o Titulo");
                                        titulo = pega.nextLine();
                                        
                                        index = removerLivro(ALL, -1, titulo);
                                        if(index == 0)
                                            System.out.println("Livro removido com sucesso");
                                        else if(index==2)
                                            System.out.println("Livro reativado\n");
                                    break;
                                    default:
                                        System.out.println("Opcao invalida, retornando ao menu dos livros");
                                }
                                    espera();
                            break;
                            case 6:
                                 System.out.println("║          VOLTANDO           ║");
                            break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        id=0;
                        titulo= " ";
                        autor= " ";
                        genero= " ";
                        
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
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Utilitáios">
    
    // <editor-fold defaultstate="collapsed" desc="Funcoes dos livros">
    public static Livro inserirLivro(int id, String titulo, String autor, String genero, boolean disponivel)
    {
        try
        {
            Livro livro = new Livro();
            livro.setId(id);
            livro.setTitulo(titulo);
            livro.setAutor(autor);
            livro.setGenero(genero);
            livro.setDisponivel(disponivel);
            return livro;
        }catch(Exception e)
        {
            System.out.println("Erro ao criar um livro: "+e);
        }
        return null;
        
    }
    
    public static void mostrarLivros(ArrayList<Livro> ALL)
    {
        System.out.println();
        if(ALL.isEmpty())
        {
            System.out.println("Não há livros, faça a inserção de um");
            return;
        }
        
        
        

        System.out.printf("%-5s %-25s %-20s %-15s %-10s%n",
                "ID", "TITULO", "AUTOR", "GENERO", "ESTADO");

        System.out.println("════════════════════════════════════════════════════════════════════════════");

        for (Livro livro : ALL) {

            System.out.printf("%-5d %-25s %-20s %-15s %-10s%n",
                    livro.getId(),
                    limitarTexto(livro.getTitulo(), 25),
                    limitarTexto(livro.getAutor(), 20),
                    limitarTexto(livro.getGenero(), 15),
                    (livro.isDisponivel() ? "Ativo" : "Inativo")
            );
        }
    }
    
    public static int procuraLivroId(int id, ArrayList <Livro> ALL)
    {
        for(int i = 0; i< ALL.size(); i++)
        {
            if(ALL.get(i).getId() == id)
                return i;
        }
        return -1;//Caso não encontre o livro na lista
    }
    public static int procuraLivroTitulo(String titulo, ArrayList <Livro> ALL)
    {
        for(int i = 0; i< ALL.size(); i++)
        {
            if(ALL.get(i).getTitulo().compareTo(titulo) == 0)
                return i;
        }
        return -1;//Caso não encontre o livro na lista
    }
    
    public static int atualizarLivro(ArrayList<Livro> ALL,int id, int novoId, String titulo, String autor, String genero)
    {
        if(procuraLivroId(id, ALL)==-1)
            return 1; // Significa que o livro não existe
        
        try {
            if(novoId != 0)
                ALL.get(procuraLivroId(id, ALL)).setId(novoId);
                ALL.get(procuraLivroId(id, ALL)).setTitulo(titulo);
                ALL.get(procuraLivroId(id, ALL)).setAutor(autor);
                ALL.get(procuraLivroId(id, ALL)).setGenero(genero);
            
                
        } catch (Exception e) {
            System.out.println("Erro ao atualizar os dados do livro: "+e);
            return -1;// Caso dê erro
        }
        
        return 0;// caso foi atualizado com sucesso
    }
    
    public static int pesquisarLivro(ArrayList <Livro> ALL, int id, String titulo)
    {
        if(id != -1)
        {
            if(procuraLivroId(id, ALL) != -1)
            {
                System.out.println("ID: "+ ALL.get(procuraLivroId(id, ALL)).getId());
                System.out.println("Titulo: "+ ALL.get(procuraLivroId(id, ALL)).getTitulo());
                System.out.println("Autor: "+ ALL.get(procuraLivroId(id, ALL)).getAutor());
                System.out.println("Genero: "+ ALL.get(procuraLivroId(id, ALL)).getGenero());
                System.out.println("Estado: "+ ALL.get(procuraLivroId(id, ALL)).isDisponivel());
            }
            else
            {
                System.out.println("Livro nao encontrado");
                return 1;
            }
        }
        else if(titulo.compareTo(" ") != 0)
        {
            if(procuraLivroTitulo(titulo, ALL) != -1)
            {
                System.out.println("ID: "+ ALL.get(procuraLivroTitulo(titulo, ALL)).getId());
                System.out.println("Titulo: "+ ALL.get(procuraLivroTitulo(titulo, ALL)).getTitulo());
                System.out.println("Autor: "+ ALL.get(procuraLivroTitulo(titulo, ALL)).getAutor());
                System.out.println("Genero: "+ ALL.get(procuraLivroTitulo(titulo, ALL)).getGenero());
                System.out.println("Estado: "+ ALL.get(procuraLivroTitulo(titulo, ALL)).isDisponivel());
            }
            else
            {
                System.out.println("Livro nao encontrado");
                return 1;
            }
        }
        else
        {
            System.out.println("Sem ID ou Titulo para verificar\n");
        }
        return 0;
    }
    
   public static int removerLivro(ArrayList<Livro> ALL, int id, String titulo) {

    int index = -1;

    // Procurar por ID primeiro
    if (id != -1) {
        index = procuraLivroId(id, ALL);
    }

    // Se não encontrou por ID, procurar por título
    if (index == -1 && titulo != null && !titulo.trim().isEmpty()) {
        index = procuraLivroTitulo(titulo, ALL);
    }

    // Se não encontrou
    if (index == -1) {
        System.out.println("Livro nao encontrado!!!");
        return -1;
    }

    Livro livro = ALL.get(index);

    // Se estiver inativo  reativar
    if (!livro.isDisponivel()) {
        reativarLivro(ALL, index);
        return 2;
    }

    // Se estiver ativo  desativar
    livro.setDisponivel(false);
    return 0;
}
    public static void reativarLivro(ArrayList <Livro> ALL, int id)
    {
            ALL.get(id).setDisponivel(true);
    }
    
    // </editor-fold>
    
    
    public static void espera()
    {
        try 
        {
            Thread.sleep(3000); // 3 segundos
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
    public static int bbtc()
    {/*
       if(verificaAcesso() == 1)*/
           AdministradorDasboard();
       /*else if(verificaAcesso() == 2)
           LeitorDasboard();
         */  
           
        return 0;
    }
    
    // </editor-fold>
    
}
