package Ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckSumTest {
    public static String readFileMsg(String fileName) throws IOException {
        StringBuilder result = new StringBuilder();  

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {  
                result.append(line);  
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }

        return result.toString();  
    }

    @Test
    @DisplayName("Ex4: ")
    public void deveCheckSumFile() throws IOException{
        String input = "src/test/java/Ex4/InputFile.txt";
        String output = "src/test/java/Ex4/OutputFile.txt";

        CheckSumFile checkSumFile = new CheckSumFile();
    

        
        try {
            CheckSumFile.calcularChecksumDoArquivoTexto(input, output);
            assertEquals("C,a,s,a,1,W",readFileMsg(output));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
