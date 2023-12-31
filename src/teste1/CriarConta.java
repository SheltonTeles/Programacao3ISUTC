package teste1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CriarConta extends JFrame implements ActionListener{
	public static final String user = "admin", senha = "0000";
	
	private JButton bt_entrar, bt_clear;
	private JPanel jp_form, jp_buttons, jp_Image;
	private JLabel lb_nome, lb_valorInicial, lb_image;
	private JTextField tf_nome, tf_valorInicial;
	private JTextField tf_password;


	CriarConta() {

		this.setTitle("Criação de conta");// title 
		this.setSize(510, 180);// Width and Height 
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon icon = new ImageIcon("assets/autenticacao.png");
		int larguraDesejada = 40;
		int alturaDesejada = 40;
		Image imagemRedimensionada = icon.getImage().getScaledInstance(larguraDesejada, alturaDesejada, Image.SCALE_SMOOTH);
		ImageIcon novoIcon = new ImageIcon(imagemRedimensionada);
		lb_image = new JLabel(novoIcon);
		jp_form = new JPanel();
		jp_buttons = new JPanel();
		jp_Image = new JPanel();
		jp_Image.add(lb_image);

		this.setLayout(new FlowLayout());
		jp_form.setLayout(new GridLayout(2,2,2,2));
		jp_buttons.setLayout(new GridLayout(1,2,2,2));

		bt_entrar = new JButton("Submeter");
		bt_entrar.addActionListener(this);

		bt_clear = new JButton("Limpar");
		bt_clear.addActionListener(this);

		lb_nome = new JLabel("Usuário: ");
		lb_valorInicial = new JLabel("Valor inicial:   ");

		tf_nome = new JTextField(20);
		tf_valorInicial = new JTextField(20);

		tf_password = new JPasswordField(20);		
		jp_form.setLayout(new GridLayout(2,2,2,2));
		jp_form.add(lb_nome);
		jp_form.add(tf_nome);
		jp_form.add(lb_valorInicial);
		jp_form.add(tf_valorInicial);

		jp_buttons.add(bt_entrar);
		jp_buttons.add(bt_clear);

		this.add(jp_Image,"North");
		this.add(jp_form);
		this.add(jp_buttons);
		

		this.setVisible(true);
	}

	//Methods
	public static void main(String[] args) {new CriarConta();}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		String senhaDigitada = new String(tf_password.getPassword());
		if (e.getSource() == bt_entrar) {
			Conta conta = new Conta();
			conta.setNome(tf_nome.getText().toString());
			conta.setNrConta(conta.gerarNrConta());
			conta.setSaldo(Double.parseDouble(tf_valorInicial.getText()));
			
			JOptionPane.showMessageDialog(this, "Detalhes da conta"+conta.toString());
			
			new Menu(conta);
		}
		
		if (e.getSource() == bt_clear) {
			tf_nome.setText("");
			tf_password.setText("");
		}

	}
}

//crie aplicação em java usando conceitos de programação orientada a objectos, interface gráfica (JFrame, JPanel, Gerenciadores de Layout e eventos) para ser implementado em uma Agência Bancária. O programa deve funcionar da seguinte forma:
//1.	O programa deve estar protegido por uma tela de autenticação através do controlo de acesso baseado em utilizador e senha (utilizador: admin e senha: 0000)
//2.	O programa deve solicitar ao utilizador o seu nome e o valor inicial para abrir uma conta, atribuindo assim seguidamente um número e esta conta de forma automática e ilustrar o número atribuído ao utilizador do programa. Estes dados serão usados para criar um objecto da classe “Conta.java”
//3.	3 Criar um menu em forma de uma tela que deve estar disponível ao utilizador do programa (este menu só deve ser apresentado ao utilizador caso o utilizador entro no sistema com as credencias correctas) com as seguintes opções
//a.	Extracto: exibe o nome, número da conta, saldo e número de levantamentos feitos durante a execução do programa
//b.	Levantar valor: receber o valor a levantar informando se está disponível e mostra o saldo final no extrato
//c.	Depositar valor: recebe o valor a depositar e mostra o novo saldo no extrato
//d.	Um menu bar com o item “ficheiro” e submenu “Sair”, para sair do programa
