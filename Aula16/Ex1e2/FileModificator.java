package Aula16.Ex1e2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileModificator {
    
    public void WriteOnFile(String fileName, String nome, String senha) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            fileWriter.write(nome + "," + senha);
            fileWriter.newLine();
            System.out.println("Deu certo :)");
        } catch (IOException e) {
            System.out.println("Erro no writer: " + e.getMessage());
        }
    }

    public String ReadFile(String fileName) {
        String content = "";  // String para armazenar a última linha lida

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String linha;  // Variável para armazenar cada linha lida
            
            while ((linha = fileReader.readLine()) != null) {
                content = linha;  

                String[] spliter = linha.split(",");  // Divide a linha em nome e senha
                String nome = spliter[0];
                String senha = spliter[1];
                // System.out.println("Nome: " + nome + ", Senha: " + senha);
            }
        } catch (IOException e) {
            System.out.println("Erro no reader: " + e.getMessage());
        }
        return content; 
    }


}
