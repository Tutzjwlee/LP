import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.CRC32;

public class testChecksum {
    public static int calcularChecksum(char vet[]) {
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
        return total;
    }

        public static void calcularChecksumDoArquivoTexto(String arqInput, String arqOutput) throws IOException {
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
            int checksum = calcularChecksum(conteudo);
            
            // Gravando o conteúdo original (com vírgulas) e o checksum no arquivo de saída
            BufferedWriter writer = new BufferedWriter(new FileWriter(arqOutput));
            writer.write(sb.toString()); // Grava o conteúdo original com vírgulas
            writer.write(","+(char)checksum); // Grava o checksum ao final
            writer.close();
        }
        
         public static long calcularCRC32(char[] texto) {
        CRC32 crc = new CRC32();
        for (char c : texto) {
            crc.update((byte) c); 
        }
        return crc.getValue(); 
    }

    
    public static void main(String[] args) {
        char vet[] = {'A','B','C'};
        
        System.out.println(calcularChecksum(vet));

        try {
            calcularChecksumDoArquivoTexto("InputFile.txt", "OutputFile.txt");
            System.out.println("Checksum calculado e gravado no arquivo.");
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        System.out.println(calcularChecksum(vet));
    }
}
