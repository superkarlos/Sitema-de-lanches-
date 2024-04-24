package model;
import java.util.LinkedList;
public class Gerente extends Usuario {

    private int countId = 0;
    private int qntProd = 0;
    //ArrayList<Produto> listaProduto;
    LinkedList<Produto> listaProduto;


   public Gerente(){
        this.user = "";
        this.senha = "";
        this.nome = "";
        this.numeroCel = "";
        this.funcao = "GERENTE";
        listaProduto  = new LinkedList<>();
    }

   protected Gerente(String user, String senha, String nome, String numero){
        this.user = user;
        this.senha = senha;
        this.nome = nome;
        this.numeroCel = numero;
        this.funcao = "GERENTE";
        listaProduto = new LinkedList<>();
    }

   protected Gerente(String nome, String numero, LinkedList<Produto> lista){
        this.nome = nome;
        this.numeroCel = numero;
        this.funcao = "GERENTE";
        listaProduto = lista;
    }


 protected void cadastraProduto(Produto p){
        qntProd++;
        countId++;
        p.setId(countId);
        listaProduto.add(p);
    }

    protected void alterarValorProduto(int id, double valor){
        for(Produto p : listaProduto){
            if(p.getId() == id){
                p.setValor(valor);
            }
        }
    }

    protected void inativarProduto(int id){
        for(Produto p : listaProduto){
            if(p.getId() == id){
                p.setStatus("INATIVO");
            }
        }
        qntProd--;
    }

    protected void listaProdutosAtivos(){
        if(qntProd > 0){
              System.out.println("--------------------------------------------------------------------");
            for(Produto p : listaProduto){
                if(p.getStatus() == "ATIVO"){
                    System.out.printf("Nome do Produto: %s  | Descrição: %s | Preço: %.2f | id: %d\n" , p.getNomeProduto().toUpperCase(),p.getDescricao().toUpperCase(),p.getValor(),p.getId());             
                    
                 }}
              System.out.println("--------------------------------------------------------------------");
                }else{
                    System.out.println("Cardapio vazio.");
                }
                
    }


 protected LinkedList<Produto> getListaProduto() {
        return listaProduto;
    }

  protected void setListaProduto(LinkedList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

 protected int getQntProd() {
        return qntProd;
    }

   protected void setQntProd(int qntProd) {
        this.qntProd = qntProd;
    }

    protected int getCountId() {
        return countId;
    }

 protected void setCountId(int countId) {
        this.countId = countId;
    }

        
}