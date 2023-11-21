package exame2023;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaAutenticacao extends JFrame implements ActionListener {



	private JPanel jp_Form;
	private JPanel jp_Buttons;

	private JLabel lb_nome;
	private JLabel lb_senha;

	private TextField tf_nome;
	private TextField tf_senha;

	private JButton bt_sair;
	private JButton bt_submeter;

	TelaAutenticacao() {

		jp_Form = new JPanel();
		jp_Buttons = new JPanel();

		lb_nome = new JLabel("Nome: ");
		lb_senha = new JLabel("Senha: ");

		bt_sair = new JButton("Sair");
		bt_submeter = new JButton("Submeter");

		tf_nome = new TextField(25);
		tf_senha = new TextField(25);
	
		this.setTitle("Linguagem de Programação II");
		this.setSize(500, 300);
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Listeners
		bt_submeter.addActionListener(this);
		bt_sair.addActionListener(this);
		
		this.setLayout(new FlowLayout());
		jp_Form.setLayout(new GridLayout(2,2,2,2));
		jp_Buttons.setLayout(new GridLayout(0,2,2,2));;
		
		
		jp_Form.add(lb_nome);
		jp_Form.add(tf_nome);
		jp_Form.add(lb_senha);
		jp_Form.add(tf_senha);
		
		jp_Buttons.add(bt_sair);
		jp_Buttons.add(bt_submeter);
		this.add(jp_Form,BorderLayout.CENTER);
		this.add(jp_Buttons, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String user = "Admin", senha = "Admin123";
		if (e.getSource() == bt_submeter) {
			if (tf_nome.getText().equals(user) && tf_senha.getText().equals(senha)) {
				JOptionPane.showMessageDialog(this, tf_nome.getText()+"Bem vindo");
				new TelaRegisto();
			} else {
				JOptionPane.showMessageDialog(this, "Senha ou user errado");
			}
		}
		if (e.getSource() == bt_sair) {
			JOptionPane.showMessageDialog(this, "Adeus");
			System.exit(0);
		}
	}
	
	

}
