package model;

import java.util.LinkedList;

//cliente add ao carrinho, remove do carrinho, finaliza compra

public class Cliente extends Usuario{
    
    private String StatusCompra = "EM ANDAMENTO";
    private Carrinho carrinho;
    private Carrinho lista;
   // private LinkedList<Produto>p;
    //private Gerente gerente;
   
    
    public Carrinho getLista() {
        return lista;
    }

    public void setLista(Carrinho lista) {
        this.lista = lista;
    }

    public Cliente(){
        this.user = "";
        this.senha = "";
        this.nome = "";
        this.numeroCel = "";
        this.funcao = "CLIENTE";
        this.carrinho  = new Carrinho();
        
    }

    public Cliente(Carrinho vsCarrinho){
        this.user = "";
        this.senha = "";
        this.nome = "";
        this.numeroCel = "";
        this.funcao = "CLIENTE";
        this.setCarrinho(vsCarrinho)  ;
    }

    public Cliente(String user, String senha, String nome, String numero){
        this.user = user;
        this.senha = senha;
        this.nome = nome;
        this.numeroCel = numero;
        this.funcao = "CLIENTE";
        this.carrinho = new Carrinho();
    }

    public Cliente(String user, String senha, String nome, String numero, Carrinho lista){
        this.user = user;
        this.senha = senha;
        this.nome = nome;
        this.numeroCel = numero;
        this.funcao = "CLIENTE";
        this.carrinho = lista;
    }

    public void addProdutoNoCarrinho(  Produto p){
        carrinho.addProduto(p);
    }


    public void removerProdutoNoCarrinho(Produto p){
        carrinho.removerProduto(p);
        
    }

    
     public void remover( int nome){
      if ( getCarrinho().buscarProduto(nome) ){
          System.out.println("produto removido com sucesso!!!!!!!!!!");
          getCarrinho().inativarProduto(nome);
      }else{
        System.out.println("Produto não encontrado");
      }
        
        
    }


    public void finalizarCompra(String pagamento){
        if(carrinho.getQntProd() > 0){
            StatusCompra = "FINALIZADA";

            carrinho.gerarNotaFiscal();
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Método de pagamento: " + pagamento);
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Compra finalizada com sucesso!!");
            carrinho.esvaziarCarrinho();
        }else{
            StatusCompra = "EM ANDAMENTO";
            System.out.println("Carrinho vazio, não há produtos para realizar a compra.");
            System.out.println("\n--------------------------------------------------------------------\n"); 
        }
            
            
    }
    public void cardapio(Carrinho lista){
           this.lista=lista;
           
        if(lista.getQntProd() > 0 ){
            System.out.println("==========================_CARDáPIO _====================================");
            lista.listaCarrinho();}
             System.out.println("==========================_-------- _====================================\n");

    }

    

    public String getStatusCompra() {
        return StatusCompra;
    }

    public void setStatusCompra(String statusCompra) {
        StatusCompra = statusCompra;
    }
    

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    public void listarCarrinho() {
        carrinho.listaCarrinho();
     }
    public void listarCarrinhoCompras() {
        carrinho.listarProdutos_compras();
     }
    public void mostarCompar() {
        carrinho.compras();
  }

}
