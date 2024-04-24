package model;

public class Produtoimplenta{
    private String nome;
    private double preco;

    public Produtoimplenta(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
