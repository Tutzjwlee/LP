package Aula16.Ex3e4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Tela3Consulta extends JFrame implements ActionListener {

    private JTextField raField;
    private JTextField nomeField;
    private JTextField sobrenomeField;
    private JTextField mediaField;

    private JTextField raTextField;
    private JTextField nomeTextField;
    private JTextField sobrenomeTextField;
    private JTextField mediaTextField;

    private JPanel panel;
    private JPanel bPanel;
    private JButton button;

    public Tela3Consulta() {
        super("Consulta de Aluno");
        this.setBounds(100, 100, 600, 300); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());

        
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));  
        panel.setBackground(Color.white);

        raTextField = new JTextField("RA");
        raTextField.setHorizontalAlignment(SwingConstants.CENTER);
        raTextField.setEditable(false);

        nomeTextField = new JTextField("Nome");
        nomeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        nomeTextField.setEditable(false);

        sobrenomeTextField = new JTextField("Sobrenome");
        sobrenomeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        sobrenomeTextField.setEditable(false);

        mediaTextField = new JTextField("Média");
        mediaTextField.setHorizontalAlignment(SwingConstants.CENTER);
        mediaTextField.setEditable(false);

        raField = new JTextField();
        raField.setHorizontalAlignment(SwingConstants.CENTER);

        nomeField = new JTextField();
        nomeField.setHorizontalAlignment(SwingConstants.CENTER);
        

        sobrenomeField = new JTextField();
        sobrenomeField.setHorizontalAlignment(SwingConstants.CENTER);
       

        mediaField = new JTextField();
        mediaField.setHorizontalAlignment(SwingConstants.CENTER);
        mediaField.setEditable(false);

        // Adiciona os componentes ao painel
        panel.add(raTextField);
        panel.add(raField);
        panel.add(nomeTextField);
        panel.add(nomeField);
        panel.add(sobrenomeTextField);
        panel.add(sobrenomeField);
        panel.add(mediaTextField);
        panel.add(mediaField);

        // Painel para o botão
        bPanel = new JPanel();
        bPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bPanel.setBackground(Color.white);

        button = new JButton("Consultar");
        button.addActionListener(this);

        bPanel.add(button);

        // Adiciona os painéis ao frame
        this.add(panel, BorderLayout.CENTER);
        this.add(bPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String ra = raField.getText();
            FileModificator2 fileModificator = new FileModificator2();
            String result = fileModificator.readAluno(ra);

            if (result.isEmpty()) {
                raField.setText("RA NÃO CADASTRADO");
                sobrenomeField.setText("");
                mediaField.setText("");
                raTextField.setText("RA");
                nomeField.setText("");
            } else {
                String[] parts = result.split(", ");
                raTextField.setText(parts[0].split(": ")[1]);
                nomeField.setText(parts[1].split(": ")[1]);
                sobrenomeField.setText(parts[2].split(": ")[1]);
                mediaField.setText(parts[3].split(": ")[1]);
            }
        }
    }
    public static void main(String[] args) {
        new Tela3Consulta();
    }
}



