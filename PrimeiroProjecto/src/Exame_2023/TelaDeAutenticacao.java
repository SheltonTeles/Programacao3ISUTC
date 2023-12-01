package Exame_2023;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TelaDeAutenticacao extends JFrame implements ActionListener{

    private JButton bt_entrar;
    private JLabel lbl_nome,lbl_password;
    private JTextField txt_nome;
    private JPasswordField passwordField;
    private JPanel panel,panel1,panel2,panelBotao;
    public TelaDeAutenticacao(){
        this.setSize(450,150);
        this.setTitle("Tela de autenticação");
        this.setLocation(300,300);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_nome = new JLabel("Nome");
        txt_nome = new JTextField(10);

        lbl_password = new JLabel("Password");
        passwordField = new JPasswordField(10);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(lbl_nome);
        panel.add(txt_nome);

        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(lbl_password);
        panel1.add(passwordField);

        bt_entrar = new JButton("Enviar");
        bt_entrar.addActionListener(this);

        panelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotao.add(bt_entrar);

        panel2 = new JPanel();
        panel2.add(panel);
        panel2.add(panel1);
        panel2.add(panelBotao);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));

        this.add(panel2);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new TelaDeAutenticacao();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt_entrar){
            String nome = txt_nome.getText();
            String password = new String(passwordField.getPassword());

            if(nome.equals("admin") && password.equals("1234")){
                JOptionPane.showMessageDialog(this,"Bem-Vindo");
                TelaDeDespesas telaDespesas = new TelaDeDespesas(null,null);
                telaDespesas.setVisible(true);
                this.dispose();

            }else{
                JOptionPane.showMessageDialog(this,"O Username ou Senha está incorreto/a!","erro",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
