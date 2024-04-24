import java.util.LinkedList;
import java.util.Scanner;

import model.Carrinho;
import model.Cliente;
import model.Gerente;
import model.Produto;
import model.Usuario;
import model.Login;

public class Main {
     static  Scanner input = new Scanner(System.in);

     static Login login = new Login();

      static Gerente gerente = new Gerente();
      static Carrinho estoque = new Carrinho();
      static Cliente cliente = new Cliente();
      static Produto Produto = new Produto();
      

      public static void main(String[] args) {
  
          
          Produto cachorro = new Produto(1,"Cachorro quente","Tradicional",7.5);
          Produto coxinha= new Produto(2,"coxinha","carne de cachorro",4.5);
          Produto sopa = new Produto(3,"sopa ","verde",6);
          Produto bolo = new Produto(4,"bolo de uva","doce",12.5);
          Produto  x_tudo = new Produto(5,"x-tudo","completo",15.5);
          Produto  x_salada = new Produto(6,"x-salada","salada",12.5);

          Produto  sorvete = new Produto(7,"sorvete","sorvete",5);
          
          

          estoque.addProduto(cachorro);
          estoque.addProduto(coxinha);
          estoque.addProduto(sopa);
          estoque.addProduto(bolo);
          estoque.addProduto(x_tudo);
          estoque.addProduto(x_salada);
          estoque.addProduto(sorvete);

            
          System.out.println("######################################################"); 
            menu_login();

          System.out.println("######################################################");
     
         
  }
      
  static void menu_cliente(Cliente c){
    try {
        cliente = c;
        cliente.cardapio(estoque);
        int opcao;
        System.out.println("------------------------------------------------------");
        System.out.println("-                      CLIENTE                       -");
        System.out.println("-                 Selecione uma opcao                -");
        System.out.println("======================================================");
        System.out.println("=                [1] -> Colocar no carrinho          =");
        System.out.println("=                [2] -> Mostar carrinho              =");
        System.out.println("=                [3] -> Remover do carrinho          =");
        System.out.println("=                [4] -> Finalizar                    =");
        System.out.println("=                [5] -> Sair                         =");
        System.out.println("======================================================");
        System.out.print("Qual Opção? ");
        opcao = Integer.parseInt(input.nextLine());
        String nome_p;
        int id;
        switch (opcao) {
            case 1:
                System.out.print("Qual id? ");      
                id = Integer.parseInt(input.nextLine());
                cliente.addProdutoNoCarrinho(estoque.getCarrinho().get(id-1));
                System.out.println("------------------------->ADCIONADO<------------------------");
                menu_cliente(c);
                break;
            case 2:
                cliente.listarCarrinhoCompras();
                menu_cliente(c);
                break;
            case 3:
                System.out.print("Qual id? ");      
                id= Integer.parseInt(input.nextLine());
                cliente.removerProdutoNoCarrinho(estoque.getCarrinho().get(id-1));
                System.out.println("------------------------>REMOVIDO<------------------------");
                menu_cliente(c);
                break;
            case 4: 
                System.out.println("Método de pagamento: ");   
                nome_p= input.nextLine();
                cliente.finalizarCompra(nome_p);
                menu_cliente(c);
                break;
            case 5:
                System.out.println("===================>Volte sempre! <===================");
                menu_login();
                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
                menu_cliente(c);
                break;
        }
    } catch (NumberFormatException e) {
        System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
        menu_cliente(c);
    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
        menu_cliente(c);
    }
}



static void menu_gerente(){
    try {
        int opcao;
        System.out.println("------------------------------------------------------");
        System.out.println("-                      GERENTE -");
        System.out.println("-                Selecione uma opcao -");
        System.out.println("======================================================");
        System.out.println("=               [1] -> Cadastar produto              =");
        System.out.println("=               [2] -> Listar produtos               =");
        System.out.println("=               [3] -> Alterar preço                 =");
        System.out.println("=               [4] -> Remover produto               =");
        System.out.println("=               [5] -> Sair                          =");
        System.out.println("======================================================");
        System.out.print("Qual Opção? ");
        opcao = Integer.parseInt(input.nextLine());
        String nome_p,descrever;
        int valor ,id;
        switch (opcao) {
            case 1:
                System.out.print("Nome: ");      nome_p= input.nextLine();
                System.out.print("Descrição: "); descrever= input.nextLine();
                System.out.print("Preço: ");     valor= Integer.parseInt(input.nextLine());
                Produto p = new Produto(nome_p,descrever,valor);
                estoque.addProduto(p);
                menu_gerente();
                break;
            case 2:
                estoque.listarProdutos();
                menu_gerente();
                break;
            case 3:
                System.out.print("Id:"); id= Integer.parseInt(input.nextLine());
                System.out.print("Preço: "); valor= Integer.parseInt(input.nextLine());
                estoque.alterarValorProduto(id, valor);
                menu_gerente();
                break;
            case 4:
                System.out.print("Id:"); id= Integer.parseInt(input.nextLine());
                estoque.inativarProduto(id);
                menu_gerente();
                break;
            case 5:
                System.out.println("===================>Volte sempre<===================");
                menu_login();
                break;
            default:
                System.out.println("Opção inválida! Escolha outra.");
                menu_gerente();
                break;
        }
    } catch (NumberFormatException e) {
        System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
        menu_gerente();
    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
        menu_gerente();
    }
}



  static void menu_login(){
          int opcao = 0;
          boolean entradaValida = false;
      
          while (!entradaValida) {
              try {
                  System.out.println("------------------------------------------------------");
                  System.out.println("-                  ÁREA DE LOGIN                     -");
                  System.out.println("-               Selecione uma opcao                  -");
                  System.out.println("======================================================");
                  System.out.println("=                  [1] -> Entrar                     =");
                  System.out.println("=                  [2] -> Cadastre-se                =");
                  System.out.println("=                  [3] -> Sair                       =");
                  System.out.println("======================================================");
                  System.out.print("Qual Opção? ");
                  opcao = Integer.parseInt(input.nextLine());
                  entradaValida = true;
              } 
              catch (NumberFormatException e) {
                  System.out.println("Opção inválida. Por favor, insira um número. Palavras não são permitidas.");
              }
          }
          

          switch(opcao) {
          case 1:
            String user, senha;
            System.out.println("------------------------------------------------------");
            System.out.println("- Username:                                          -");
            user = input.nextLine();
            System.out.println("- Senha:                                             -");
            senha = input.nextLine();
        
            try {
                if(login.logar(user, senha)) {
                    Usuario u1 = login.retornarUsuario(user, senha);
                    Cliente c = login.retornarCliente(user, senha);
                    if("CLIENTE".equals(u1.getFuncao())) {
                        menu_cliente(c);
                    } else if("GERENTE".equals(u1.getFuncao())) {
                        menu_gerente();
                    }
                } else {
                    System.out.println("------------------------------------------------------");
                    System.out.println("Usuário ou senha inválida.");
                    menu_login();
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante o processo de login: " + e.getMessage());
                menu_login();
            }
            break;
          case 2:{
            try {
              int op;
              System.out.println("------------------------------------------------------");
              System.out.println("-                  ÁREA DE LOGIN                     -");
              System.out.println("-               Selecione uma opcao                  -");
              System.out.println("======================================================");
              System.out.println("=               [1] -> Cadastrar Gerente             =");
              System.out.println("=               [2] -> Cadastrar Cliente             =");
              System.out.println("=               [3] -> Voltar                        =");
              System.out.println("======================================================");
              System.out.print("Qual Opção? ");
              op = Integer.parseInt(input.nextLine());
              
              if(op == 1){
                  System.out.println("Digite o codigo de cadastro de Gerente:");
                  String cod = input.nextLine();
                  if (cod.equals("****")){
                       if(login.isExisteGerente() == false){
                      Gerente u2 = new Gerente();
                      System.out.println("======================================================");
                      System.out.println("                  Cadastro Gerente                    ");
                      System.out.println("======================================================");
                      System.out.println("- Username:                                          -");
                      u2.setUser(input.nextLine());
                      System.out.println("- Senha:                                             -");
                      u2.setSenha(input.nextLine());
                      System.out.println("- Nome:                                              -");
                      u2.setNome(input.nextLine());
                      System.out.println("- Numero de celular:                                 -");
                      u2.setNumeroCel(input.nextLine());
                      u2.setFuncao("GERENTE");
                      System.out.println("======================================================");
                  
                      login.cadastraUser(u2);
                      login.setExisteGerente(true);
                      menu_login();
                  }else{
                      System.out.println("------------------------------------------------------");
                      System.out.println("Já existe um gerente cadastrado!");
                      menu_login();
                  }
                  
                  }else{
                    System.out.println("!!!ACESSO NEGADO,APENAS ADM PODEM TER ACESSO!!!");
                    menu_login();
                  }
                  
              }
              else if(op == 2){
                  LinkedList<Cliente> listaClientes = new LinkedList<>();
                  
                  listaClientes = login.getClientesCadastrados();
                  Cliente u3 = new Cliente();
                  System.out.println("======================================================");
                  System.out.println("                  Cadastro Cliente                    ");
                  System.out.println("======================================================");
                  System.out.println("- Username:                                          -");
                  u3.setUser(input.nextLine());
                  System.out.println("- Senha:                                             -");
                  u3.setSenha(input.nextLine());
                  System.out.println("- Nome:                                              -");
                  u3.setNome(input.nextLine());
                  System.out.println("- Numero de celular:                                 -");
                  u3.setNumeroCel(input.nextLine());
                  u3.setFuncao("CLIENTE");
                  System.out.println("======================================================");
                  login.cadastraUser(u3);
                  listaClientes.add(u3);
                  menu_login();
              }else{
                  menu_login();
              }
          } catch (NumberFormatException e) {
              System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
              menu_login();
          } catch (Exception e) {
              System.out.println("Erro: " + e.getMessage());
              menu_login();
          }
              }
          case 3:
              System.out.println("===================>Volte sempre<===================");
              break;
            default:
                System.out.println("Opção inválida! Escolha outra.");
                menu_login();
              break;
          }
          
        }





  }
