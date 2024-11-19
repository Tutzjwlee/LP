package OrientacaoObjetos.Semestre2.Aula20.Exercicio02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServerTest2 {
    public static final String endereco = "127.0.0.1";
    public static final int porta = 3334;
    static ServerSocket servidor;
    static Socket client;

    public static void createServer() {
        try {
            servidor = new ServerSocket(porta);
            System.out.println("Servidor iniciado na porta: " + porta);
        } catch (Exception e) {
            System.out.println("ERRO AO CRIAR O SERVIDOR");
        }
    }

    public static void connectClientToServer() throws IOException {
        // Espera pela conexão do cliente
        client = servidor.accept();
        System.out.println("Cliente do IP: " + client.getInetAddress() + " conectado no servidor.");

        // Cria uma thread para ouvir as mensagens do cliente
        new Thread(() -> {
            try {
                receberMensagemDoCliente(client);
            } catch (IOException e) {
                System.out.println("Erro ao receber a mensagem do cliente: " + e.getMessage());
            }
        }).start();
    }

    public static void receberMensagemDoCliente(Socket client) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String mensagemRecebida;

        while ((mensagemRecebida = input.readLine()) != null) {
            // Exibe a mensagem recebida no console
            System.out.println("Mensagem recebida do cliente: " + mensagemRecebida);
        }
    }
}
