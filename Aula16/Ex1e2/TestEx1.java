package Aula16.Ex1e2;

import java.util.Scanner;

public class TestEx1 {
    public static void main(String[] args) {
        FileModificator fm = new FileModificator();

        String nome;
        String senha;

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o usuário: ");
        nome = sc.next();
        System.out.println("Digite a senha: ");
        senha = sc.next();

        fm.WriteOnFile("usuarios.txt", nome, senha);
        System.out.println("Conteúdo:\n" + fm.ReadFile("usuarios.txt"));

        sc.close();

    }
}
