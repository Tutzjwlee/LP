package OrientacaoObjetos.Semestre2.Aula20.Exercicio01;
import java.net.*;
import java.util.Scanner;
public class SimpleServerTest {
    public static final String endereco = "127.0.0.1";
    public static final int porta = 3334;

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(porta);
            System.out.println("Servidor iniciado na porta: " + porta);

            Socket cliente = servidor.accept();
            System.out.println("Cliente do IP: " + cliente.getInetAddress() + " conectado no servidor.");
            
            Scanner sc = new Scanner(cliente.getInputStream());
            System.out.println("Mensagem do Cliente: ");
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            System.err.println("Servidor finalizado");
            sc.close();
            servidor.close();
        
        } catch (Exception e) {
            System.out.println("ERRO AO CRIAR O SERVIDOR");
        }
    }
}
