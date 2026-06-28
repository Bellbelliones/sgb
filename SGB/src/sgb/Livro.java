package sgb;

import java.util.ArrayList;
import static sgb.Biblioteca.limitarTexto;

public class Livro {

    // Lista usada durante a execucao (a "dona" dos livros)
    public static ArrayList<Livro> ALL = new ArrayList<>();

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    private long id;
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponivel;

    // <editor-fold defaultstate="collapsed" desc="Funcoes dos livros">
    public static Livro inserirLivro(long id, String titulo, String autor, String genero, boolean disponivel) {
        try {
            Livro livro = new Livro();
            livro.setId(id);
            livro.setTitulo(titulo);
            livro.setAutor(autor);
            livro.setGenero(genero);
            livro.setDisponivel(disponivel);
            return livro;
        } catch (Exception e) {
            System.out.println("Erro ao criar um livro: " + e);
        }
        return null;
    }

    public static void mostrarLivros(ArrayList<Livro> ALL, int nivelAcesso) {
        System.out.println();
        if (ALL.isEmpty() && nivelAcesso == 1) {
            System.out.println("Não há livros, faça a inserção de um");
            return;
        } else if (ALL.isEmpty() && nivelAcesso == 2) {
            System.out.println("Ainda nao foram resgistados livros");
            return;
        }

        System.out.printf("%-15s %-25s %-20s %-15s %-10s%n",
                "ISBN", "TITULO", "AUTOR", "GENERO", "ESTADO");
        System.out.println("════════════════════════════════════════════════════════════════════════════");

        if (nivelAcesso == 1)
            for (Livro livro : ALL) {
                System.out.printf("%-15d %-25s %-20s %-15s %-10s%n",
                        livro.getId(),
                        limitarTexto(livro.getTitulo(), 25),
                        limitarTexto(livro.getAutor(), 20),
                        limitarTexto(livro.getGenero(), 15),
                        (livro.isDisponivel() ? "Ativo" : "Inativo"));
            }
        else if (nivelAcesso == 2)
            for (Livro livro : ALL) {
                if (livro.isDisponivel())
                    System.out.printf("%-15d %-25s %-20s %-15s%n",
                            livro.getId(),
                            limitarTexto(livro.getTitulo(), 25),
                            limitarTexto(livro.getAutor(), 20),
                            limitarTexto(livro.getGenero(), 15));
            }
    }

    public static int procuraLivroId(long id, ArrayList<Livro> ALL) {
        for (int i = 0; i < ALL.size(); i++) {
            if (ALL.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public static int procuraLivroTitulo(String titulo, ArrayList<Livro> ALL) {
        for (int i = 0; i < ALL.size(); i++) {
            if (ALL.get(i).getTitulo().compareTo(titulo) == 0)
                return i;
        }
        return -1;
    }

    public static int atualizarLivro(ArrayList<Livro> ALL, long id, long novoId, String titulo, String autor, String genero) {
        int index = procuraLivroId(id, ALL);
        if (index == -1)
            return 1;

        try {
            if (novoId != 0)
                ALL.get(index).setId(novoId);
            ALL.get(index).setTitulo(titulo);
            ALL.get(index).setAutor(autor);
            ALL.get(index).setGenero(genero);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar os dados do livro: " + e);
            return -1;
        }
        return 0;
    }

    public static int pesquisarLivro(ArrayList<Livro> ALL, long id, String titulo) {
        if (id != -1) {
            int idx = procuraLivroId(id, ALL);
            if (idx != -1) {
                System.out.println("ISBN: " + ALL.get(idx).getId());
                System.out.println("Titulo: " + ALL.get(idx).getTitulo());
                System.out.println("Autor: " + ALL.get(idx).getAutor());
                System.out.println("Genero: " + ALL.get(idx).getGenero());
                System.out.println("Estado: " + ALL.get(idx).isDisponivel());
            } else {
                System.out.println("Livro nao encontrado");
                return 1;
            }
        } else if (titulo.compareTo(" ") != 0) {
            int idx = procuraLivroTitulo(titulo, ALL);
            if (idx != -1) {
                System.out.println("ISBN: " + ALL.get(idx).getId());
                System.out.println("Titulo: " + ALL.get(idx).getTitulo());
                System.out.println("Autor: " + ALL.get(idx).getAutor());
                System.out.println("Genero: " + ALL.get(idx).getGenero());
                System.out.println("Estado: " + ALL.get(idx).isDisponivel());
            } else {
                System.out.println("Livro nao encontrado");
                return 1;
            }
        } else {
            System.out.println("Sem ISBN ou Titulo para verificar\n");
        }
        return 0;
    }

    public static int bloquearDesbloquearLivro(ArrayList<Livro> ALL, long id, String titulo) {
        int index = -1;

        if (id != -1)
            index = procuraLivroId(id, ALL);

        if (index == -1 && titulo != null && !titulo.trim().isEmpty())
            index = procuraLivroTitulo(titulo, ALL);

        if (index == -1) {
            System.out.println("Livro nao encontrado!!!");
            return -1;
        }

        Livro livro = ALL.get(index);

        if (!livro.isDisponivel()) {
            reativarLivro(ALL, index);
            return 2;
        }

        livro.setDisponivel(false);
        return 0;
    }
public static boolean removerLivro(ArrayList<Livro> ALL, long id) {
        int index = procuraLivroId(id, ALL);
        if (index == -1)
            return false;

        ALL.remove(index);
        return true;
    }
    public static void reativarLivro(ArrayList<Livro> ALL, int index) {
        ALL.get(index).setDisponivel(true);
    }
    // </editor-fold>
}