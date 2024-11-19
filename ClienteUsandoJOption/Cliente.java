package ClienteUsandoJOption;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Cliente {
    private static final String HOST = "localhost";
    private static final int PORTA = 12345;

    public static void main(String[] args) {
        new Cliente().executar();
    }

    public void executar() {
        try (Socket socket = new Socket("localhost", PORTA);
             BufferedReader leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true)) {
    
            // Verifica se o servidor está cheio
            String resposta = leitor.readLine();
            if ("Servidor cheio. Desconectando...".equals(resposta)) {
                System.out.println("Servidor cheio. Encerrando cliente...");
                return; // Finaliza o cliente
            }
    
            System.out.println("Conexão estabelecida!");
            // Continua com a lógica do cliente para enviar/receber mensagens
            while (true) {
                String mensagem = JOptionPane.showInputDialog("Digite sua mensagem (ou sair para encerrar):");
                if (mensagem == null || mensagem.equalsIgnoreCase("sair")) {
                    System.out.println("Encerrando cliente...");
                    break;
                }
                escritor.println(mensagem); // Envia mensagem ao servidor
                String respostaServidor = leitor.readLine();
                System.out.println("Resposta do servidor: " + respostaServidor);
            }
        } catch (IOException e) {
            System.out.println("Erro ao conectar ao servidor: " + e.getMessage());
        }
    }
    
}
