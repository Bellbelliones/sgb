/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgb;

import javax.sound.sampled.DataLine;

/**
 *
 * @author critical-trojan
 */
public class Emprestimo {
    private int id;
    private String livro;
    private String usuario;
    private DataLine dataEmprestimo;
    private DataLine dataDevolucao;
    private boolean devolvido;

    public Emprestimo(int id, String livro, String usuario, DataLine dataEmprestimo, DataLine dataDevolucao,
            boolean devolvido) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
    }
}
