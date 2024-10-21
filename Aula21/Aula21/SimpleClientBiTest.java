
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SimpleClientBiTest {
    public static Socket client;
    private static Scanner input;
    private static PrintStream output;


    public static void main(String[] args) {
        System.out.println("*v*v*v* CONSOLE DO CLIENTE *v*v*v*");
        try {
            startClient();
            talkToServer();
            killConectionWithServer();
        } catch (IOException e) {
            System.out.println("Erro no Cliente: " + e.getMessage());
        }
    }

    public static void killConectionWithServer() {
        System.out.println("Cliente se desconectou do Servidor!");
        System.out.println("Cliente finalizado!");
    }

    public static void talkToServer() throws IOException {
        String msg, echo = "";

        do {
            System.out.println("Digite na Entrada a mensagem para o servidor!");
            msg = JOptionPane.showInputDialog("Digite aqui a pensagem para o servidor (ou <sair> para encerrar)");
            if(!msg.equalsIgnoreCase("sair"))
            {
                sendMessageToServer(msg);
                echo = readMessageFromServer();
                verifyCommunication(echo,msg);
            }
        } while (!msg.equalsIgnoreCase("sair"));
    }

    public static void verifyCommunication(String echo, String msg) {
        if(echo.equals(msg))
        {
            System.out.println("Comunicacao OK!");
        }
        else
        {
            System.out.println("Comunicacao com problema!");
        }
    }

    public static String readMessageFromServer() {
        String msg = input.nextLine();
        System.out.println("Ecoou do Servidor: ");
        System.out.println(msg);
        return msg;
    }

    public static void sendMessageToServer(String msg) throws IOException {
        output = new PrintStream(client.getOutputStream());
        output.println(msg);
        System.out.println("Enviou ao Servidor: ");
        System.out.println(msg);
    }

    public static void startClient() throws IOException {
        client = new Socket(SimpleServerBiTest.endereco, SimpleServerBiTest.porta);
        System.out.println("Cliente IP: " + SimpleServerBiTest.endereco + " conectado ao servidor pela porta " + SimpleServerBiTest.porta);
        input = new Scanner(client.getInputStream());
    }


}
