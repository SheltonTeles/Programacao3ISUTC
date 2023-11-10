package bancoAPP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import bancoAPP.*;

public class Menu extends JFrame implements ActionListener{
	private JButton bt_extracto, bt_levantamento, bt_depositar, bt_sair;
	private JPanel jp_buttons, jp_imagem;
	private ImageIcon imageBanner;
	private JLabel lb_imagem;
	private Conta conta;
	private JMenu menu1, submenu;
	private JMenuBar jmb;
	private JMenuItem items1, item_sair;


	Menu(Conta conta){
		this.conta = conta;
		this.setTitle("Menu");// title 
		this.setSize(760, 380);// Width and Height 
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		jp_buttons = new JPanel();
		jp_buttons.setLayout(new GridLayout(3,1,5,3));
		jp_imagem = new JPanel();
		imageBanner = new ImageIcon("C:/Users/DELL/Downloads/Untitled.png");
		lb_imagem = new JLabel(imageBanner);
		jp_imagem.add(lb_imagem);


		menu1 = new JMenu("MENU");
		jmb = new JMenuBar();
		jmb.add(menu1); // Adicione o menu principal à barra de menus

		// Adicione o submenu ao menu principal
		submenu = new JMenu("Submenu");
		items1 = new JMenuItem("Ficheiro");
		item_sair = new JMenuItem("Sair");
		item_sair.addActionListener(this);
		submenu.add(item_sair);

		// Adicione os itens ao menu principal
		menu1.add(items1);
		menu1.add(submenu); // Adicione o submenu ao menu principal
		jmb.add(menu1); // Adicione o menu principal à barra de menus

		this.setJMenuBar(jmb);

		bt_extracto = new JButton("Extracto");
		bt_extracto.addActionListener(this);
		jp_buttons.add(bt_extracto);


		bt_levantamento = new JButton("Levantamento");
		bt_levantamento.addActionListener(this);
		jp_buttons.add(bt_levantamento);

		bt_depositar = new JButton("Depositar");
		bt_depositar.addActionListener(this);
		jp_buttons.add(bt_depositar);

		this.add(jp_imagem,"North");
		this.add(jp_buttons);

		this.setVisible(true);

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == bt_extracto) {
			JOptionPane.showMessageDialog(this, "Extracto: " + conta.toString());
		}

		if(e.getSource()== bt_levantamento) {
			String valorLevantamentoString = JOptionPane.showInputDialog(this, "Insira o valor a ser levantado:");

			if (valorLevantamentoString != null) {
				try {
					double valorLevantamento = Double.parseDouble(valorLevantamentoString);
					// Agora você tem o valor de levantamento em 'valorLevantamento'

					// Verifique se o saldo é suficiente para o levantamento
					if (valorLevantamento > 0 && valorLevantamento <= conta.getSaldo()) {
						// Se o valor de levantamento é válido e o saldo é suficiente, prossiga com o levantamento
						conta.levantar(valorLevantamento);
						JOptionPane.showMessageDialog(this, "Levantamento de " + valorLevantamento + " realizado com sucesso.\nNovo saldo: " + conta.getSaldo());
						
						JOptionPane.showMessageDialog(this, "Novo extracto: " + conta.toString());
					} else {
						JOptionPane.showMessageDialog(this, "Valor de levantamento inválido ou saldo insuficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Valor inválido. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}


		if(e.getSource() == bt_depositar) {

			String valorADepositarString = JOptionPane.showInputDialog(this, "Insira o valor a ser depositado:");
			if (valorADepositarString != null) {
				try {
					double valorPorDepositar1 = Double.parseDouble(valorADepositarString);
					// Agora você tem o valor a ser depositado em 'valorADepositar'

					// Adicione sua lógica para depositar o valor aqui, atualizando a conta, etc.
					// Por exemplo:
					conta.depositar(valorPorDepositar1);

					JOptionPane.showMessageDialog(this, "Depósito de " + valorPorDepositar1 + " realizado com sucesso.");
					JOptionPane.showMessageDialog(this, "Novo extracto: " + conta.toString());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Valor inválido. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		if (e.getSource() == item_sair) {

			this.dispose();
		}

	}




}
