package Aula16.Ex1e2;
import java.util.Scanner;

public class TestEx2 {
    public static void main(String[] args) {
         FileModificator fm = new FileModificator();

        String nome;
        String senha;

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o usuário: ");
        nome = sc.next();
        System.out.println("Digite a senha: ");
        senha = sc.next();

        boolean achou = false;
        
        String content = fm.ReadFile("usuarios.txt");
        String[] linha = content.split("\n");
        for (String line : linha) {
            String[] aux = line.split(",");
            if (nome.equals(aux[0]) && senha.equals(aux[1])) {
                System.out.println("LOGIN REALIZADO COM SUCESSO");
                achou = true;
                break;
            }
        }

        if(!achou){
            System.out.println("LOGIN E/OU SENHA ERRADO(S");
        }

        sc.close();
    }

}

