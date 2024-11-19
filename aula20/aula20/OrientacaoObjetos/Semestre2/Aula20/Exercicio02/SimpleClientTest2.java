package OrientacaoObjetos.Semestre2.Aula20.Exercicio02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClientTest2 {

    public static Socket cliente;
    private static String msg;

    public static void setMsg(String msg) {
        SimpleClientTest2.msg = msg;
    }

    public static String getMsg() {
        return msg;
    }

    public static void createClient() {
        try {
            iniciaCliente();
        } catch (IOException e) {
            System.out.println("Falha na comunicação: " + e.getMessage());
        }
    }

    public static void enviarMensagem() throws IOException {
        if (cliente != null && !cliente.isClosed()) {
            PrintStream output = new PrintStream(cliente.getOutputStream());
            output.println(msg); // Envia a mensagem
        } else {
            System.out.println("Cliente não conectado.");
        }
    }

    static void iniciaCliente() throws UnknownHostException, IOException {
        cliente = new Socket(SimpleServerTest2.endereco, SimpleServerTest2.porta);
        System.out.println("Cliente: " + SimpleServerTest2.endereco + ":" + SimpleServerTest2.porta + " conectado ao servidor!");
    }
}