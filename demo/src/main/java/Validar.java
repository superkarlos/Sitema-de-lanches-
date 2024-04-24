
import java.util.Scanner;

public class Validar {
    private String nome  = "admin";
    private int senha = 1234;

    private Scanner ler = new Scanner(System.in);

    private String login;
    private int senhagerente;


    public int getSenha() {
        return senha;
    }
    
    public boolean validar(){
        try {
            System.out.println("Login: ");
            login = ler.nextLine();

            System.out.println("Senha: ");
       
            senhagerente= Integer.parseInt(ler.nextLine());
            if ( (senha == senhagerente) && login.equals(nome)){
                System.out.println("Login Válido!\n");
                return true;
            }  
            else{
                System.out.println("Login Inválido! Tente novamente.\n");
                return false;
            } 
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
            return false;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
}

