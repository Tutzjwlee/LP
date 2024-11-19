package OrientacaoObjetos.Semestre2.Aula23.Ex2;

import javax.swing.JFrame;

import OrientacaoObjetos.Semestre2.Aula23.Ex1.SocketCliente;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.net.*;

public class WindowChat extends JFrame implements ActionListener, Runnable {
    public JTextField textMessage = new JTextField();
    public JTextField textReceivedMessage = new JTextField();
    public JLabel conectionMessage = new JLabel("Desconectado do Servidor");
    public JLabel labelMessage = new JLabel("Mensagem para enviar: ");
    public JLabel labelReceivedMessage = new JLabel("Mensagem recebida: ");
    public JButton sendButton = new JButton("Send");
    public JButton quitButton = new JButton("Quit");
    public JButton clearButton = new JButton("Clear");
    public JButton conectButton = new JButton("Connect");

    private SocketCliente clientSocket;
    public ArrayList<JButton> buttons = new ArrayList<>();

    public WindowChat() {
        super();
        this.setSize(550, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        textMessage.setBounds(120, 120, 270, 40);
        textMessage.setEnabled(false);

        textReceivedMessage.setBounds(120, 50, 270, 40);
        textReceivedMessage.setEnabled(false);
        labelReceivedMessage.setBounds(120, 20, 270, 40);

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
        this.add(textReceivedMessage);
        this.add(labelMessage);
        this.add(labelReceivedMessage);
        this.add(conectionMessage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conectButton) {
            try {
                Socket socket = new Socket("127.0.0.1", 3304);
                clientSocket = new SocketCliente(socket);
                new Thread(this).start();

                conectionMessage.setText("Conectado ao Servidor");
                conectionMessage.setForeground(Color.GREEN);
                textMessage.setEnabled(true);

                // Habilitar outros botões após a conexão
                sendButton.setEnabled(true);
                clearButton.setEnabled(true);
                quitButton.setEnabled(true);
                conectButton.setEnabled(false); // Desabilitar o botão de conexão
            } catch (IOException ex) {
                conectionMessage.setText("Falha na conexão!");
                conectionMessage.setForeground(Color.RED);
                ex.printStackTrace();
            }
        } else if (e.getSource() == sendButton) {
            clientSocket.sendMsg(WindowChat.this.textMessage.getText());
        } else if (e.getSource() == clearButton) {
            textMessage.setText("");
        } else if (e.getSource() == quitButton) {
            if (clientSocket != null)
                clientSocket.close();
            conectionMessage.setText("Desconectado do Servidor");
            conectionMessage.setForeground(Color.RED);
            textMessage.setEnabled(false);
            sendButton.setEnabled(false);
            clearButton.setEnabled(false);
            quitButton.setEnabled(false);
            conectButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        WindowChat tela = new WindowChat();
    }

    @Override
    public void run() {
        String msg;
        while ((msg = clientSocket.getMessage()) != null) {
            WindowChat.this.textReceivedMessage.setText(msg);

        }
    }
}
