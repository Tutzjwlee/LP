import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Checksum {

    // Método para calcular o checksum de um array de caracteres
    public byte[] calcularChecksum(char vet[]) {
        byte[] byVeto = new byte[vet.length + 1];
        byte total = 0;
        int i;

        for (i = 0; i < vet.length; i++) {
            byVeto[i] = (byte) vet[i];
            total = (byte) ((total + byVeto[i]) & 0xFF);
        }
        total = (byte) ~total;
        total = (byte) ((total + (byte) 1) & 0xFF);
        System.out.println("Checksum: " + total);
        byVeto[i] = total;
        return byVeto;
    }

    // Método para calcular o checksum de um arquivo texto com caracteres separados por vírgula
    public void calcularChecksumDoArquivoTexto(String arqInput, String arqOutput) throws IOException {
        // Lendo o arquivo de entrada
        BufferedReader reader = new BufferedReader(new FileReader(arqInput));
        StringBuilder sb = new StringBuilder();
        int ch;

        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        reader.close();

        // Remove as vírgulas e cria um vetor de caracteres
        String[] partes = sb.toString().split(",");
        char[] conteudo = new char[partes.length];
        for (int i = 0; i < partes.length; i++) {
            conteudo[i] = partes[i].trim().charAt(0); // Remover espaços em branco e pegar o primeiro caractere
        }

        // Calculando o checksum
        byte[] checksum = calcularChecksum(conteudo);

        // Gravando o conteúdo original (com vírgulas) e o checksum no arquivo de saída
        BufferedWriter writer = new BufferedWriter(new FileWriter(arqOutput));
        writer.write(sb.toString()); // Grava o conteúdo original com vírgulas
        writer.write("\nChecksum: " + checksum[conteudo.length]); // Grava o checksum ao final
        writer.close();
    }
}
