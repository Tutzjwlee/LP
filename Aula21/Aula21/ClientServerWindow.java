
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class ClientServerWindow extends JFrame implements ActionListener {
    public JTextField textMessage = new JTextField();
    public JLabel conectionMessage = new JLabel("Desconectado do Servidor");
    public JLabel labelMessage = new JLabel("Mensagem: ");
    public JButton sendButton = new JButton("Send");
    public JButton quitButton = new JButton("Quit");
    public JButton clearButton = new JButton("Clear");
    public JButton conectButton = new JButton("Connect");

    public ArrayList<JButton> buttons = new ArrayList<>();

    public ClientServerWindow() {
        super();
        this.setSize(550, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        textMessage.setBounds(120, 120, 270, 40);
        textMessage.setEnabled(false);

        conectionMessage.setBounds(180, 200, 270, 40);
        conectionMessage.setForeground(Color.RED);
        labelMessage.setBounds(120, 80, 270, 40);

        buttons.add(conectButton);
        buttons.add(sendButton);
        buttons.add(clearButton);
        buttons.add(quitButton);

        int i = 0;
        for (JButton jButton : buttons) {
            jButton.setBounds(30 + (120 * i), 300, 90, 50);
            jButton.setVisible(true);
            jButton.addActionListener(this);
            this.add(jButton);
            if (i >= 1) {
                jButton.setEnabled(false); // Apenas o botão "Connect" estará habilitado inicialmente
            }
            i++;
        }

        this.add(textMessage);
        this.add(labelMessage);
        this.add(conectionMessage);
    }

    public static void main(String[] args) {
        ClientServerWindow tela = new ClientServerWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conectButton) {
            // Conectar ao servidor e ao cliente
            new Thread(() -> {
                try {
                    SimpleServerBiTest.startServer();
                    try {
                        SimpleServerBiTest.waitClientConection();
                    } catch (IOException e1) {
                        conectionMessage.setText("Falha ao criar o servidor...");
                        conectionMessage.setForeground(Color.RED);
                        
                        e1.printStackTrace();
                    }
                } catch (IOException ex) {
                }
            }).start();

            new Thread(() -> {
                try {
                    SimpleClientBiTest.startClient();
                    conectionMessage.setText("Conectado ao Servidor!");
                    conectionMessage.setForeground(Color.GREEN);
                    
                    for (int j = 1; j < buttons.size(); j++) {
                        buttons.get(j).setEnabled(true); // Habilita outros botões após a conexão
                    }
                    textMessage.setEnabled(true);
                } catch (IOException ex) {
                }
            }).start();

        } else if (e.getSource() == sendButton) {
         
            try {
                SimpleClientBiTest.sendMessageToServer(textMessage.getText());;
                conectionMessage.setText("Mensagem enviada ao Servidor!");
                conectionMessage.setForeground(Color.BLACK);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == quitButton) {
            try {
                SimpleClientBiTest.client.close(); // Fecha a conexão do cliente
                conectionMessage.setText("Desconectado do Servidor");
                for (JButton button : buttons) {
                    button.setEnabled(false);
                }
                textMessage.setEnabled(false);
                conectButton.setEnabled(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == clearButton) {
            textMessage.setText(""); // Limpa o campo de texto
        }
    }
}
