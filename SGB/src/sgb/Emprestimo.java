package sgb;

import Utilizadores.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class Emprestimo {

    // Lista usada durante a execucao (a "dona" dos emprestimos)
    public static ArrayList<Emprestimo> AEMP = new ArrayList<>();

    private int id;
    private String livro;
    private String usuario;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String dataRegistro;
    private boolean devolvido;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLivro() { return livro; }
    public void setLivro(String livro) { this.livro = livro; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(String dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

    public String getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(String dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    public String getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(String dataRegistro) { this.dataRegistro = dataRegistro; }

    public boolean isDevolvido() { return devolvido; }
    public void setDevolvido(boolean devolvido) { this.devolvido = devolvido; }

    // <editor-fold defaultstate="collapsed" desc="Funcoes dos emprestimos">

    public static Emprestimo inserirEmprestimo(int id, String livro, String usuario,
            String dataEmprestimo, String dataDevolucao, String dataRegistro, boolean devolvido) {
        try {
            Emprestimo e = new Emprestimo();
            e.setId(id);
            e.setLivro(livro);
            e.setUsuario(usuario);
            e.setDataEmprestimo(dataEmprestimo);
            e.setDataDevolucao(dataDevolucao);
            e.setDataRegistro(dataRegistro);
            e.setDevolvido(devolvido);
            return e;
        } catch (Exception ex) {
            System.out.println("Erro ao criar um emprestimo: " + ex);
        }
        return null;
    }

    public static void adicionarEmprestimo(ArrayList<Emprestimo> lista,
            ArrayList<Usuario> usuarios, String livro,
            String email, String senha, String dataDevolucao) {

        int idUser = Usuario.validarAcesso(usuarios, email, senha);
        if (idUser == -1) {
            System.out.println("Email ou senha invalidos. Emprestimo nao realizado.");
            return;
        }

        String nome = usuarios.get(Usuario.procuraUsuarioId(idUser, usuarios)).getNome();

        int id = lista.size() + 1;
        String hoje = LocalDate.now().toString();

        Emprestimo novo = inserirEmprestimo(id, livro, nome, hoje, dataDevolucao, hoje, false);
        if (novo != null) {
            lista.add(novo);
            System.out.println("Emprestimo adicionado para " + nome + "!");
        }
    }

    public static void mostrarEmprestimos(ArrayList<Emprestimo> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum emprestimo encontrado.");
            return;
        }
        for (Emprestimo e : lista) {
            System.out.println("\nID: " + e.getId());
            System.out.println("Livro: " + e.getLivro());
            System.out.println("Usuario: " + e.getUsuario());
            System.out.println("Data Emprestimo: " + e.getDataEmprestimo());
            System.out.println("Data Devolucao: " + e.getDataDevolucao());
            System.out.println("Data Registro: " + e.getDataRegistro());
            System.out.println("Devolvido: " + e.isDevolvido());
        }
    }

    public static void devolverLivro(ArrayList<Emprestimo> lista, int id) {
        for (Emprestimo e : lista) {
            if (e.getId() == id) {
                if (e.isDevolvido()) {
                    System.out.println("Livro ja devolvido.");
                } else {
                    e.setDevolvido(true);
                    System.out.println("Livro devolvido com sucesso!");
                }
                return;
            }
        }
        System.out.println("Emprestimo nao encontrado.");
    }

    public static final double MULTA_POR_DIA = 100.0;

    public static double calcularMulta(Emprestimo e) {
        if (e.isDevolvido()) {
            return 0.0;
        }

        LocalDate prazo = LocalDate.parse(e.getDataDevolucao());
        LocalDate hoje = LocalDate.now();

        if (!hoje.isAfter(prazo)) {
            return 0.0;
        }

        long diasAtraso = ChronoUnit.DAYS.between(prazo, hoje);
        return diasAtraso * MULTA_POR_DIA;
    }

    public static void mostrarMulta(ArrayList<Emprestimo> lista, int id) {
        for (Emprestimo e : lista) {
            if (e.getId() == id) {
                double multa = calcularMulta(e);
                if (multa == 0.0) {
                    System.out.println("Sem multa para este emprestimo.");
                } else {
                    long dias = ChronoUnit.DAYS.between(
                            LocalDate.parse(e.getDataDevolucao()), LocalDate.now());
                    System.out.println("Atraso de " + dias + " dia(s).");
                    System.out.println("Multa a pagar: " + multa + " Kz");
                }
                return;
            }
        }
        System.out.println("Emprestimo nao encontrado.");
    }

    // </editor-fold>
}