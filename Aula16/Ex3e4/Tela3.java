package Aula16.Ex3e4;

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

public class Tela3 extends JFrame implements ActionListener {

    private JPanel panel;
    private JPanel bpanel;
    private JTextField RATextField;
    private JTextField nomeTextField;
    private JTextField SobrenomeTextField;
    private JTextField p1JTextField;
    private JTextField p2TextField;
    private JTextField p3JTextField;
    private JTextField p4JTextField;
    
    // Campos de entrada para o usuário
    private JTextField inputRATextField;
    private JTextField inputNomeTextField;
    private JTextField inputSobrenomeTextField;
    private JTextField inputP1TextField;
    private JTextField inputP2TextField;
    private JTextField inputP3TextField;
    private JTextField inputP4TextField;
    
    private JButton submitButton;

    private Aluno aluno;

    public Tela3() {
        super("Cadastro de Aluno");
        this.setBounds(0, 0, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);

        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10)); 
        panel.setBackground(Color.white);

      
        RATextField = new JTextField("RA");
        RATextField.setHorizontalAlignment(SwingConstants.CENTER);
        RATextField.setEditable(false);

        nomeTextField = new JTextField("Nome");
        nomeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        nomeTextField.setEditable(false);

        SobrenomeTextField = new JTextField("Sobrenome");
        SobrenomeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        SobrenomeTextField.setEditable(false);

        p1JTextField = new JTextField("P1");
        p1JTextField.setHorizontalAlignment(SwingConstants.CENTER);
        p1JTextField.setEditable(false);

        p2TextField = new JTextField("P2");
        p2TextField.setHorizontalAlignment(SwingConstants.CENTER);
        p2TextField.setEditable(false);

        p3JTextField = new JTextField("P3");
        p3JTextField.setHorizontalAlignment(SwingConstants.CENTER);
        p3JTextField.setEditable(false);

        p4JTextField = new JTextField("P4");
        p4JTextField.setHorizontalAlignment(SwingConstants.CENTER);
        p4JTextField.setEditable(false);

        inputRATextField = new JTextField();
        inputNomeTextField = new JTextField();
        inputSobrenomeTextField = new JTextField();
        inputP1TextField = new JTextField();
        inputP2TextField = new JTextField();
        inputP3TextField = new JTextField();
        inputP4TextField = new JTextField();
  
        panel.add(RATextField);
        panel.add(inputRATextField);
        panel.add(nomeTextField);
        panel.add(inputNomeTextField);
        panel.add(SobrenomeTextField);
        panel.add(inputSobrenomeTextField);
        panel.add(p1JTextField);
        panel.add(inputP1TextField);
        panel.add(p2TextField);
        panel.add(inputP2TextField);
        panel.add(p3JTextField);
        panel.add(inputP3TextField);
        panel.add(p4JTextField);
        panel.add(inputP4TextField);


        bpanel = new JPanel();
        bpanel.setLayout(new FlowLayout());  
   
        submitButton = new JButton("Enviar");
        submitButton.addActionListener(this);  

        
        bpanel.add(submitButton);

        this.setLayout(new GridLayout(2, 1));  
        this.add(panel);
        this.add(bpanel);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            
            aluno = new Aluno();
            aluno.setRa(inputRATextField.getText());
            aluno.setNome(inputNomeTextField.getText());
            aluno.setSobrenome(inputSobrenomeTextField.getText());
            aluno.setP1(inputP1TextField.getText());
            aluno.setP2(inputP2TextField.getText());
            aluno.setP3(inputP3TextField.getText());
            aluno.setP4(inputP4TextField.getText());
    
         
            System.out.println("RA: " + aluno.getRa());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Sobrenome: " + aluno.getSobrenome());
            System.out.println("P1: " + aluno.getP1());
            System.out.println("P2: " + aluno.getP2());
            System.out.println("P3: " + aluno.getP3());
            System.out.println("P4: " + aluno.getP4());
    
            FileModificator2 fileModificator = new FileModificator2();
            fileModificator.saveAluno(aluno);

          
            inputRATextField.setText("");
            inputNomeTextField.setText("");
            inputSobrenomeTextField.setText("");
            inputP1TextField.setText("");
            inputP2TextField.setText("");
            inputP3TextField.setText("");
            inputP4TextField.setText("");
        

        }
    }

    public static void main(String[] args) {
        new Tela3();
    }
}
