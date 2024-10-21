
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SimpleServerBiTest {
    public static final String endereco = "127.0.0.1";
    public static final int porta = 3334;

    private static ServerSocket servidor;
    private static Socket clientAccepted;
    private static Scanner input;
    private static PrintStream output;


    public static void main(String[] args) {
        System.out.println("*v*v*v* CONSOLE DO SERVIDOR *v*v*v*");
        try {
            startServer();
            waitClientConection();
            talkToClient();
            killConectionWithClient();
            stopServer();
        } catch (Exception e) {
            System.out.println("ERRO NO SERVIDOR: " + e.getMessage());
        }
    }


    public static void stopServer() throws IOException {
        servidor.close();
        System.out.println("Servidor finalizado!");
    }


    public static void killConectionWithClient() {
        input.close();
        System.err.println("Cliente se desconectou do Servidor!");
    }


    public static void talkToClient() {
        String msg;

        while (input.hasNextLine()) {
            msg = readClientMessage();
            returnClientMessage(msg);
        }
    }


    public static void returnClientMessage(String msg) {
        output.println(msg);
        System.out.println("Ecoou ao cliente: ");
        System.out.println(msg);
    }


    public static String readClientMessage() {
        String msg = input.nextLine();
        System.out.println("Chegou do cliente: ");
        System.out.println(msg);
        return msg;
    }


    public static void waitClientConection() throws IOException {
        clientAccepted = servidor.accept();
        System.out.println("Cliente IP: " + clientAccepted.getInetAddress().getHostAddress() + " conectado ao servidor pela porta " + porta);
        input = new Scanner(clientAccepted.getInputStream());
        output = new PrintStream(clientAccepted.getOutputStream());
    }


    public static void startServer() throws IOException {
        servidor = new ServerSocket(porta);
        System.out.println("Servidor iniciado e escutando a porta " + porta);
    }
}