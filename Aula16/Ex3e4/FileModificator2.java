package Aula16.Ex3e4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileModificator2 {

    
    public void saveAluno(Aluno aluno) {
        String fileName = "estudantes.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String data = aluno.getRa() + "," + aluno.getNome() + "," + aluno.getSobrenome() + ","+ aluno.getP1() + "," + aluno.getP2() + "," + aluno.getP3() + "," + aluno.getP4();
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    // Método para ler os dados do aluno a partir do RA
    public String readAluno(String ra) {
        String fileName = "estudantes.txt";
        String result = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                
                if (data[0].equals(ra)) {
                    // Calcula a média
                    double p1 = Double.parseDouble(data[3]);
                    double p2 = Double.parseDouble(data[4]);
                    double p3 = Double.parseDouble(data[5]);
                    double p4 = Double.parseDouble(data[6]);
                    double media = (p1 + p2 + p3 + p4) / 4;

                    result = String.format("RA: %s, Nome: %s, Sobrenome: %s, Média: %.2f", data[0], data[1], data[2], media);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
        
        return result;
    }
}
