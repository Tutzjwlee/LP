package OrientacaoObjetos.Semestre2.Aula20.Exercicio01;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class SimpleClientTest {

    private static Socket cliente;
    public static void main(String[] args) {
        try {
            String msg;
            iniciaCliente();
            System.out.println("Mensagem para o servidor: ");
            do {
                msg = JOptionPane.showInputDialog("Digite a mensagem (ou <sair> para encerrar)");
                if(!msg.equalsIgnoreCase("sair"))
                {
                    System.out.println(msg);
                    enviarMensagem(msg);
                }
            } while (!msg.equalsIgnoreCase("sair"));
            System.out.println("Cliente se desconectou do servidor!");
        } catch (IOException e) {
            System.out.println("Falha na comunicacao: "+ e.getMessage());
        }
    }
	private static void enviarMensagem(String msg) throws IOException {
        PrintStream output = new PrintStream(cliente.getOutputStream());
        output.println(msg);
	}
	private static void iniciaCliente() throws UnknownHostException, IOException {
        cliente = new Socket(SimpleServerTest.endereco, SimpleServerTest.porta);
        System.out.println("Cliente: " + SimpleServerTest.endereco + ":" + SimpleServerTest.porta + " conectado ao servidor!");
	}
}