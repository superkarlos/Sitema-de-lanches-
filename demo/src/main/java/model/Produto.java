package model;

public class Produto { 
    private int id;
    private String nomeProduto;
    private String descricao;
    private double valor;
    private String status;
    //private int qntProd = 0;
    
    public Produto(){
        this.id = -1;
        this.nomeProduto = "";
        this.descricao = "";
        this.valor = 0;
        this.status = "INATIVO";
    }
    
    public Produto(String nomeProduto, String descricao, double valor){
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.valor = valor;
        this.status = "ATIVO";
    }

    public Produto(int id, String nomeProduto, String descricao, double valor){
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.valor = valor;
        this.status = "ATIVO";
    }

    public void infoProduto(){
        System.out.println("ID: " + this.id);    
        System.out.println("Nome: " + this.nomeProduto);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Valor: " + this.valor);
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    //public String getProduto(){
    //       return this.getNomeProduto();
   // } 
   
   

}