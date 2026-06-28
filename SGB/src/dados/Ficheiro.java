package dados;

import Utilizadores.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import sgb.Emprestimo;
import sgb.Livro;

public class Ficheiro {

    private static final String LIVROS = "livros.txt";
    private static final String UTILIZADORES = "utilizadores.txt";
    private static final String EMPRESTIMOS = "emprestimos.txt";

    // ===================== LIVROS =====================
    public static void salvarLivros(ArrayList<Livro> livros) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(LIVROS))) {
            pw.println("# isbn;titulo;autor;genero;disponivel");
            for (Livro l : livros) {
                pw.println(l.getId() + ";" + l.getTitulo() + ";" + l.getAutor()
                        + ";" + l.getGenero() + ";" + l.isDisponivel());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar livros: " + e.getMessage());
        }
    }

    public static void carregarLivros(ArrayList<Livro> livros) {
        livros.clear();
        if (!new File(LIVROS).exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(LIVROS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.startsWith("#")) continue;
                String[] p = linha.split(";");
                if (p.length < 5) continue;
                Livro l = Livro.inserirLivro(
                        Long.parseLong(p[0].trim()),
                        p[1], p[2], p[3],
                        Boolean.parseBoolean(p[4].trim()));
                if (l != null) livros.add(l);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler " + LIVROS + ": " + e.getMessage());
        }
    }

    // ===================== UTILIZADORES =====================
    public static void salvarUsuarios(ArrayList<Usuario> usuarios) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(UTILIZADORES))) {
            pw.println("# id;nome;email;senha;bi;nivelacesso;ativo");
            for (Usuario u : usuarios) {
                pw.println(u.getId() + ";" + u.getNome() + ";" + u.getEmail()
                        + ";" + u.getSenha() + ";" + u.getBi()
                        + ";" + u.getNivelacesso() + ";" + u.isAtivo());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar utilizadores: " + e.getMessage());
        }
    }

    public static void carregarUsuarios(ArrayList<Usuario> usuarios) {
        usuarios.clear();
        if (!new File(UTILIZADORES).exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(UTILIZADORES))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.startsWith("#")) continue;
                String[] p = linha.split(";");
                if (p.length < 7) continue;
                Usuario u = Usuario.inserirUsuario(
                        Integer.parseInt(p[0].trim()),
                        p[1], p[2], p[3], p[4],
                        Integer.parseInt(p[5].trim()),
                        Boolean.parseBoolean(p[6].trim()));
                if (u != null) usuarios.add(u);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler " + UTILIZADORES + ": " + e.getMessage());
        }
    }

    // ===================== EMPRESTIMOS =====================
    public static void salvarEmprestimos(ArrayList<Emprestimo> emprestimos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(EMPRESTIMOS))) {
            pw.println("# id;livro;usuario;dataEmprestimo;dataDevolucao;dataRegistro;devolvido");
            for (Emprestimo e : emprestimos) {
                pw.println(e.getId() + ";" + e.getLivro() + ";" + e.getUsuario()
                        + ";" + e.getDataEmprestimo() + ";" + e.getDataDevolucao()
                        + ";" + e.getDataRegistro() + ";" + e.isDevolvido());
            }
        } catch (IOException ex) {
            System.out.println("Erro ao salvar emprestimos: " + ex.getMessage());
        }
    }

    public static void carregarEmprestimos(ArrayList<Emprestimo> emprestimos) {
        emprestimos.clear();
        if (!new File(EMPRESTIMOS).exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(EMPRESTIMOS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.startsWith("#")) continue;
                String[] p = linha.split(";");
                if (p.length < 7) continue;
                Emprestimo e = Emprestimo.inserirEmprestimo(
                        Integer.parseInt(p[0].trim()),
                        p[1], p[2], p[3], p[4], p[5],
                        Boolean.parseBoolean(p[6].trim()));
                if (e != null) emprestimos.add(e);
            }
        } catch (IOException ex) {
            System.out.println("Erro ao ler " + EMPRESTIMOS + ": " + ex.getMessage());
        }
    }

    // ===================== TUDO =====================
    public static void salvarTudo() {
        salvarLivros(Livro.ALL);
        salvarUsuarios(Usuario.ALU);
        salvarEmprestimos(Emprestimo.AEMP);
        System.out.println("Todos os dados foram salvos.");
    }

    public static void carregarTudo() {
        carregarLivros(Livro.ALL);
        carregarUsuarios(Usuario.ALU);
        carregarEmprestimos(Emprestimo.AEMP);
        System.out.println("Todos os dados foram carregados.");
    }
}