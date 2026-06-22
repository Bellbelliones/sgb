/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilizadores;

import java.util.ArrayList;
import static sgb.Biblioteca.limitarTexto;
import sgb.Livro;

/**
 *
 * @author critical-trojan
 */
public class Usuario {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public int getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(int nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String bi;
    private int nivelacesso;
    private boolean ativo;
    
  
    // <editor-fold defaultstate="collapsed" desc="Funcoes dos Usuarios">
            
    public static Usuario inserirUsuario(int id_usuario, String nome, String email, String senha, String bi, int nivelAcesso, boolean ativo)
    {
        Usuario usr = new Usuario();
        usr.setId(id_usuario);
        usr.setNome(nome);
        usr.setEmail(email);
        usr.setSenha(senha);
        usr.setBi(bi);
        usr.setNivelacesso(nivelAcesso);
        usr.setAtivo(ativo);
        
        return(usr);
    }
    public static int procuraUsuarioId(int id, ArrayList <Usuario> ALU)
    {
        for(int i = 0; i< ALU.size(); i++)
        {
            if(ALU.get(i).getId() == id)
                return i;
        }
        return -1;//Caso não encontre o usuario na lista
    }
    public static int procuraUsuarioGmail(String gmail, ArrayList <Usuario> ALU)
    {
        for(int i = 0; i< ALU.size(); i++)
        {
            if(ALU.get(i).getEmail().compareTo(gmail) == 0)
                return i;
        }
        return -1;//Caso não encontre o usuario na lista
    }
    public static boolean atualizarUsuario(ArrayList<Usuario> ALU,int id, String nome, String email, String senha, String bi, int nivelAcesso, boolean ativo)
        {
            int index = procuraUsuarioId(id, ALU);
            if(index == -1)
                return false;
            
            
            ALU.get(index).setNome(nome);
            ALU.get(index).setEmail(email);
            ALU.get(index).setSenha(senha);
            ALU.get(index).setBi(bi);
            ALU.get(index).setNivelacesso(nivelAcesso);
            ALU.get(index).setAtivo(ativo);
            return true;
        }
    public static void mostrarUsuarios(ArrayList<Usuario> ALU, int nivelAcesso)
    {
        System.out.println();
        if(ALU.isEmpty())
        {
            System.out.println("Não há usuarios, faça a inserção de um");
            return;
        }
        
        
        
        
        if(nivelAcesso > -1 && nivelAcesso <2)
        System.out.printf("%-5s %-20s %-20s %-15s %-20s %-15s %-10s%n",
                "ID", "NOME", "EMAIL", "SENHA","BI","ACESSO", "ESTADO");
        else
            
        System.out.printf("%-5s %-20s %-20s %-20s%n",
                "ID", "NOME", "EMAIL","BI");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════");

        for (Usuario usuario : ALU) {

            String nivel = switch (usuario.getNivelacesso()) {
            case 1 -> "Administrador";
            case 2 -> "Funcionário";
            case 3 -> "Leitor";
            default -> "Desconhecido";
            };
            
            if(nivelAcesso> -1 && nivelAcesso < 2)
            System.out.printf("%-5s %-20s %-20s %-15s %-20s %-15s %-10s%n",
            usuario.getId(),
            limitarTexto(usuario.getNome(), 20),
            limitarTexto(usuario.getEmail(), 20),
            limitarTexto(usuario.getSenha(), 15),
            limitarTexto(usuario.getBi(), 20),
            limitarTexto(nivel, 15),
            (usuario.isAtivo() ? "Ativo" : "Inativo")
          );
            else if(nivelAcesso == 2 && usuario.nivelacesso == 3 && usuario.isAtivo())
            System.out.printf("%-5s %-20s %-20s %-20s %n",
            usuario.getId(),
            limitarTexto(usuario.getNome(), 20),
            limitarTexto(usuario.getEmail(), 20),
            limitarTexto(usuario.getBi(), 20)
          );
        }
    }
    public static int bloquearDesbloquearUsuario(ArrayList<Usuario> ALU, int id, String email)
    {
        int index = -1;

    // Procurar por ID primeiro
    if (id != -1) {
        index = procuraUsuarioId(id, ALU);
    }

    // Se não encontrou por ID, procurar por título
    if (index == -1 && email != null && !email.trim().isEmpty()) {
        index = procuraUsuarioGmail(email, ALU);
    }

    // Se não encontrou
    if (index == -1) {
        return -1;
    }

    Usuario usuario = ALU.get(index);

    // Se estiver inativo  reativar
    if (!usuario.isAtivo()) {
         usuario.setAtivo(true);
        return 2;
    }

    // Se estiver ativo  desativar
    usuario.setAtivo(false);
    return 0;
    
    }
    public static boolean removerUsuario(ArrayList<Usuario> ALU, int id)
    {
        if(procuraUsuarioId(id, ALU) == -1)
        return false;
        
        ALU.remove(id);
        return true;
    }
    public static int gmailVerificacao(String email)
    {
        
           
           if(email.compareTo("@") !=0)
           {
               
            String[] divida = email.split("@");
            if(email.compareTo("@"+divida[divida.length-1]) == 0)
            {
                System.out.println("Voce esqueceu de colocar o seu nome antes do @gmail.com");
            }
            else if(divida[divida.length-1].compareTo("gmail.com") == 0 && email.compareTo("@"+divida[divida.length-1]) != 0)
            {
                return 0;
            }
            else if(divida[divida.length-1].compareTo(email) == 0){
                System.out.println("Ausencia do @ ");
            }
            else if(email.compareTo(divida[divida.length-1]+"@") == 0){
                System.out.println("Voce esqueceu de adicionar o gmail.com depois do @");
            }
            else if(divida[divida.length-1].compareTo("gmail.com") != 0){
                   System.out.println("Depois do @, coloca-se o gmail.com");
            }
            return 1;

           }
           else
           {
               System.out.println("Coloque o nome que usou para criar o email antes do @");
               return 1;
           }
    }
    
    
    public static int senhaVerificacao(String senha)
    {
        char primeiraLetra = senha.charAt(0);
        if(senha.length() < 9){
            System.out.println("A senha deve ter no minimo 9 caracteres");
            return 1;
        }
        else
        if(!Character.isDigit(primeiraLetra))
        {
            if(primeiraLetra != Character.toUpperCase(primeiraLetra))
            {
                System.out.println("A primeira letra deve ser Maiuscula");
                return 1;
            }
            else
            {
                for(int i =0 ; i < senha.length(); i++)
                    //Verifiando se a senha tem um numero
                    if(!Character.isDigit(senha.charAt(i)) && i == senha.length()-1)
                    {
                        System.out.println("A senha deve conter ao menos um numero");
                        return 1;
                    }
                    else if(Character.isDigit(senha.charAt(i)))
                        break;
                
                //verifica se a senha tem um simbolo
                for(int i =0 ; i < senha.length(); i++)
                    if(Character.isLetterOrDigit(senha.charAt(i)) && !Character.isWhitespace(senha.charAt(i)) && i == senha.length()-1)
                    {
                        System.out.println("A senha deve conter ao menos um simbolo '@,#,$'");
                        return 1;
                    }
                    else if(!Character.isLetterOrDigit(senha.charAt(i)) && !Character.isWhitespace(senha.charAt(i)))
                        break;
            }   
                    
            
        }
        
        return 0;
    }
    
    
    public static int validarAcesso(ArrayList<Usuario> ALU, String email, String senha)
    {
        int index = procuraUsuarioGmail(email, ALU);
        //Se nao encontrar um usuario com o email fornecido retorna -1
        if(index == -1)
            return -1;
        ///Se a senha estiver errada retorna -1
        else if(ALU.get(index).senha.compareTo(senha) != 0)
            return -1;
            
        //Se encontrou tudo e bate correspondencia, retorna o id do usuario
        return ALU.get(index).id;
    }
        public static int contaUsuarios(ArrayList<Usuario> ALU)
    {
            return ALU.size();
    }
    
    public static void mascararSenha()    
    {
        
    }
    // </editor-fold>
 
}
