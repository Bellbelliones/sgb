/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgb;

/**
 *
 * @author critical-trojan
 */
public class Livro {
    private int id;
    private String titulo;
    private String  autor;
    private String genero;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor, String genero, boolean disponivel)
    {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponivel = disponivel;
    }
}
