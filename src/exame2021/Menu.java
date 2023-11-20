package exame2021;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import exame2021.*;

public class Menu extends JFrame implements ActionListener{
	private JButton bt_extracto, bt_levantamento, bt_depositar, bt_sair;
	private JPanel jp_buttons, jp_imagem;
	private ImageIcon imageBanner;
	private JLabel lb_imagem;

	private JMenu Menu, Sobre;
	private JMenuBar jmb;
	private JMenuItem itemConversor, itemSobre, itemSair;

	private Pessoa p;

	Menu(Pessoa p){
		this.p = p;
		this.setTitle("Menu");// title 
		this.setSize(760, 280);// Width and Height 
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jp_buttons = new JPanel();
		jp_buttons.setLayout(new GridLayout(3,1,5,3));
		jp_imagem = new JPanel();
		imageBanner = new ImageIcon("C:/Users/DELL/Downloads/Untitled.png");
		lb_imagem = new JLabel(imageBanner);
		jp_imagem.add(lb_imagem);


		Menu = new JMenu("Menu");
		jmb = new JMenuBar();
		jmb.add(Menu); // Adicione o menu principal à barra de menus

		
		itemConversor = new JMenuItem("Conversor");
		itemConversor.addActionListener(this);
		
		itemSobre = new JMenuItem("Sobre");
		itemSobre.addActionListener(this);
		
		itemSair = new JMenuItem("Sair");
		itemSair.addActionListener(this);

		// Adicione os itens ao menu principal
		Menu.add(itemConversor);
		Menu.add(itemSobre); // Adicione o Sobre ao menu principal
		Menu.add(itemSair);


		this.setJMenuBar(jmb);
		this.add(jp_imagem);

		this.setVisible(true);

	}



	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == itemConversor) {
			
			this.setVisible(false);
			CambioGUI c = new CambioGUI();
			c.setVisible(true);
		}

		if(e.getSource() == itemSobre) {
			//implementar funcionalidades
			JOptionPane.showMessageDialog(this, p.toString());
			
		}


		if (e.getSource() == itemSair) {

			this.dispose();
		}

	}




}

