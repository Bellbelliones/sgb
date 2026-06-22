/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgb;

import java.util.ArrayList;
import static sgb.Biblioteca.limitarTexto;

/**
 *
 * @author critical-trojan
 */
public class Livro {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    private int id;
    private String titulo;
    private String  autor;
    private String genero;
    private boolean disponivel;
  
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
    
    public static void mostrarLivros(ArrayList<Livro> ALL, int nivelAcesso)
    {
        System.out.println();
        if(ALL.isEmpty() && nivelAcesso == 1)
        {
            System.out.println("Não há livros, faça a inserção de um");
            return;
        }
        else if(ALL.isEmpty() && nivelAcesso == 2)
        {
            System.out.println("Ainda nao foram resgistados livros");
            return;
        }
        
        
        

        System.out.printf("%-5s %-25s %-20s %-15s %-10s%n",
                "ID", "TITULO", "AUTOR", "GENERO", "ESTADO");

        System.out.println("════════════════════════════════════════════════════════════════════════════");
        
        if(nivelAcesso == 1)
            for (Livro livro : ALL) {

                System.out.printf("%-5d %-25s %-20s %-15s %-10s%n",
                        livro.getId(),
                        limitarTexto(livro.getTitulo(), 25),
                        limitarTexto(livro.getAutor(), 20),
                        limitarTexto(livro.getGenero(), 15),
                        (livro.isDisponivel() ? "Ativo" : "Inativo")
                );
            }
        else if(nivelAcesso == 2)
            for (Livro livro : ALL) {
                if(livro.isDisponivel())
                System.out.printf("%-5d %-25s %-20s %-15s%n",
                        livro.getId(),
                        limitarTexto(livro.getTitulo(), 25),
                        limitarTexto(livro.getAutor(), 20),
                        limitarTexto(livro.getGenero(), 15)
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
        int index=procuraLivroId(id, ALL);
        if(index==-1)
            return 1; // Significa que o livro não existe
        
        try {
            if(novoId != 0)
                ALL.get(index).setId(novoId);
                ALL.get(index).setTitulo(titulo);
                ALL.get(index).setAutor(autor);
                ALL.get(index).setGenero(genero);
            
                
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
    
    
  
}
