package exame2023epoca1LECC;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Autenticacao extends JFrame implements ActionListener{

	public static final String user = "admin", senha = "2222";
	
	private JButton bt_submit, bt_clear;
	private JPanel jp_form, jp_buttons, jp_Image;
	private JLabel lb_nome, lb_senha;
	private JTextField tf_nome;

	private JPasswordField tf_password;

	
	Autenticacao() {

		this.setTitle("LOGIN");// title 
		this.setSize(510, 180);// Width and Height 
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	
		jp_form = new JPanel();
		jp_buttons = new JPanel();
		jp_Image = new JPanel();


		this.setLayout(new FlowLayout());
		jp_form.setLayout(new GridLayout(2,2,2,2));
		jp_buttons.setLayout(new GridLayout(0,2,2,2));

		bt_submit = new JButton("Entrar");
		bt_submit.addActionListener(this);

		bt_clear = new JButton("Limpar");
		bt_clear.addActionListener(this);

		lb_nome = new JLabel("Usuário: ");
		lb_senha = new JLabel("Senha:   ");

		tf_nome = new JTextField(20);

		tf_password = new JPasswordField(20);		
		jp_form.setLayout(new GridLayout(2,2,2,2));
		jp_form.add(lb_nome);
		jp_form.add(tf_nome);
		jp_form.add(lb_senha);
		jp_form.add(tf_password);

		jp_buttons.add(bt_submit);
		jp_buttons.add(bt_clear);

		this.add(jp_Image,"North");
		this.add(jp_form);
		this.add(jp_buttons);
		

		this.setVisible(true);
	}

	//Methods
	public static void main(String[] args) {new Autenticacao();}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String senhaDigitada = new String(tf_password.getPassword());
		if (e.getSource() == bt_submit) {
			if(tf_nome.getText().equals(user) && senhaDigitada.equals(senha)) {
				JOptionPane.showMessageDialog(this, "Bem-Vindo");
				new TelaRegisto();
				
			} else {
				JOptionPane.showMessageDialog(this, "Utilizador ou senha incorretos", "Erro de autenticação", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource() == bt_clear) {
			tf_nome.setText("");
			tf_password.setText("");
		}

	}
	
	
	
	
	
}

