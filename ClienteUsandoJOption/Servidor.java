package ClienteUsandoJOption;
import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {
    private static final int PORTA = 12345;
    private static final int MAX_CLIENTES = 2;
    private final List<ClienteHandler> clientes = new ArrayList<>();

    public static void main(String[] args) {
        new Servidor().executar();
    }

    public void executar() {
        System.out.println("Servidor iniciado. Aguardando conexões...");
        try (ServerSocket servidor = new ServerSocket(PORTA)) {
            while (true) {
                Socket socket = servidor.accept(); // Sempre aceita a conexão inicial.
                if (clientes.size() < MAX_CLIENTES) {
                    // Aceita o cliente se o limite não foi atingido
                    ClienteHandler clienteHandler = new ClienteHandler(socket, this);
                    clientes.add(clienteHandler);
                    new Thread(clienteHandler).start();
                    System.out.println("Novo cliente conectado.");
                } else {
                    // Rejeita o cliente extra
                    System.out.println("Tentativa de conexão excedida. Servidor já possui dois clientes.");
                    PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
                    escritor.println("Servidor cheio. Desconectando...");
                    socket.close(); // Fecha a conexão do cliente novo
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    public synchronized void encaminharMensagem(String mensagem, ClienteHandler remetente) {
        for (ClienteHandler cliente : clientes) {
            if (cliente != remetente) {
                cliente.enviarMensagem(mensagem);
            }
        }
        System.out.println("Mensagem enviada por " + remetente.getNome() + ": " + mensagem);
    }

    public synchronized void removerCliente(ClienteHandler cliente) {
        clientes.remove(cliente);
        System.out.println("Cliente desconectado.");
    }
}

class ClienteHandler implements Runnable {
    private Socket socket;
    private Servidor servidor;
    private PrintWriter escritor;
    private String nome;

    public ClienteHandler(Socket socket, Servidor servidor) {
        this.socket = socket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            escritor = new PrintWriter(socket.getOutputStream(), true);
            escritor.println("Bem-vindo ao chat! Digite seu nome:");
            nome = leitor.readLine();
            System.out.println(nome + " entrou no chat.");
            String mensagem;
            while ((mensagem = leitor.readLine()) != null) {
                servidor.encaminharMensagem(nome + ": " + mensagem, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            servidor.removerCliente(this);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void enviarMensagem(String mensagem) {
        escritor.println(mensagem);
    }

    public String getNome() {
        return nome;
    }
}
