package model;

public class Usuario {
    
    protected String user;
    protected String senha;
    protected String nome;
    protected String numeroCel;
    protected String funcao;//se é gerente ou cliente
    
    
    public Usuario(){
        this.user = "";
        this.senha = "";
        this.nome = "";
        this.numeroCel = "";
        this.funcao = "";
    }
    
    public Usuario(String user, String senha, String nome, String numero){
        this.user = user;
        this.senha = senha;
        this.nome = nome;
        this.numeroCel = numero;
        this.funcao = "";
    }

    public String getNumeroCel() {
        return numeroCel;
    }

    public void setNumeroCel(String numeroCel) {
        this.numeroCel = numeroCel;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


   
}