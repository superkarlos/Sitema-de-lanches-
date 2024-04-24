package model;
//import java.util.ArrayList;
import java.util.LinkedList;
public class Carrinho extends Produto  {

    private int countId = 0;
    private int qntProd = 0;
    LinkedList<Produto> carrinho;
  //  LinkedList<Produto> listaProduto;


    public Carrinho(){
        this.carrinho = new LinkedList<>();
    }

    public Carrinho(LinkedList<Produto> lista){
        this.carrinho = lista;
    }

    public boolean buscarProduto(int id){
        if(qntProd > 0){
            for(Produto p : carrinho){
                if(p.getId() == id){
                    //System.out.println("Produto encontrado.");
                    return true;
                }
            }

            //System.out.println("Produto não encontrado.");
            return false;
        }else{
            System.out.println("Carrinho vazio.");
            return false;
        }
    }
   

    public void addProduto(Produto p){
        if(p.getStatus() == "ATIVO"){
            qntProd++;

            if(p.getId() == 0 ){
                if(qntProd > 0){
                    countId = carrinho.getLast().getId();
                    countId++;
                    p.setId(countId);
                }else{
                    countId++; 
                    p.setId(countId);
                }
                
            } 

            carrinho.add(p);
    
        }
    }

     public void removerProduto(Produto p){
        carrinho.remove(p);
        qntProd--;
     }
    

    public void listarProdutos(){
        if(qntProd > 0){
        System.out.println("--------------------------------------------------------------------");
          for(Produto p : carrinho){
              if(p.getStatus() == "ATIVO"){
                  System.out.printf("Nome do Produto: %s  | Descrição: %s | Preço: %.2f | id: %d\n" , p.getNomeProduto().toUpperCase(),p.getDescricao().toUpperCase(), p.getValor(), p.getId());             
                  //p.infoProduto();
               }}
            System.out.println("--------------------------------------------------------------------");
              }else{
                  System.out.println("Cardapio vazio.");
              }
              
    }
    public void listarProdutos_compras(){
        System.out.println("------------------CARRINHO DE COMPRAS-----------------------------");
       
        if(qntProd > 0){
         System.out.println("\n");
          for(Produto p : carrinho){
              if(p.getStatus() == "ATIVO"){
                  System.out.printf("ID:%d ->ADICIONADO: %s| Descrição: %s | Preço: %.2f |\n" , p.getId(),p.getNomeProduto().toUpperCase(),p.getDescricao().toUpperCase(),p.getValor());             
                  
               }}
               System.out.println("\n");
            System.out.println("--------------------------------------------------------------------");
              }else{
                  System.out.println("------------------------------------------------------");
                  System.out.println("Carrinho vazio.");
              }
              
    }
     public void compras(){
        if(qntProd > 0){
            System.out.println("--------------------------------------------------------------------");
          for(Produto p : carrinho){
              if(p.getStatus() == "ATIVO"){
                  System.out.printf("Adicionado: %s  |  Preço: %.2f | cod: %d \n" , p.getNomeProduto().toUpperCase(),p.getValor(),p.getId());             
                  
               }}
            System.out.println("--------------------------------------------------------------------");
              }else{
                  System.out.println("Cardapio vazio.");
              }
              
    }

    public void esvaziarCarrinho(){
        carrinho = new LinkedList<>();
        qntProd = 0;
    }


    public double calcularTotalDaCompra(){
        double total = 0;
        
        if(qntProd > 0){
            for(Produto p : carrinho){
                total = total + p.getValor();
            }
        }

        return total;
    }

    public void gerarNotaFiscal(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("NOTA FISCAL");
    
        listarProdutos();
        System.out.printf("Total = R$ %.2f", calcularTotalDaCompra());
        System.out.println("\n");

    }

    public void inativarProduto(int id){
        for(Produto p : carrinho){
            if(p.getId() == id){
                p.setStatus("INATIVO");
            }
        }
        qntProd--;
    }

     public void listaCarrinho(){
        listarProdutos();
    }
    public void listarCarrinhoCompras(){
        listarCarrinhoCompras();
    }

    public LinkedList<Produto> getCarrinho() {
        return carrinho;
    }
    public void alterarValorProduto(int id, double valor){
        for(Produto p : carrinho){
            if(p.getId() == id){
                p.setValor(valor);
            }
        }
    }
    public void setCarrinho(LinkedList<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public int getQntProd() {
        return qntProd;
    }

    public void setQntProd(int qntProd) {
        this.qntProd = qntProd;
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }
    
}
