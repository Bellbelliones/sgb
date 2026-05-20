/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgb;

/**
 *
 * @author critical-trojan
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String bi;
    private int nivelacesso;
    private boolean ativo;
    
    public Usuario(int id, String nome, String email,String senha, String bi, int nivelacesso, boolean ativo)
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.bi = bi;
        this.nivelacesso = nivelacesso;
        this.ativo = ativo;
    }
 
}
