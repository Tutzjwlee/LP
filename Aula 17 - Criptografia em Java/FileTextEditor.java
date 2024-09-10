import java.io.*;

public class FileTextEditor {
    public static String readFileMsg(String fileName) throws IOException {
        StringBuilder result = new StringBuilder();  

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {  
                result.append(line).append(System.lineSeparator());  
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }

        return result.toString();  
    }
    public static void writeFileMsg(String fileName, String msgString) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            fileWriter.write(msgString + "\n");
            fileWriter.close();
            System.out.println("Deu certo :)");
        } catch (IOException e) {
            System.out.println("Erro no writer: " + e.getMessage());
        }
    }
}

