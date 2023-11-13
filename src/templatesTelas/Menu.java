package templatesTelas;
import javax.swing.*;



import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener{
	private JButton bt_extracto, bt_levantamento, bt_depositar, bt_sair;
	private JPanel jp_buttons, jp_imagem;
	private ImageIcon imageBanner;
	private JLabel lb_imagem;

	private JMenu menu1, submenu;
	private JMenuBar jmb;
	private JMenuItem items1, item_sair;


	Menu(){

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



	public static void main(String[] args) {
		new Menu();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == bt_extracto) {

		}

		if(e.getSource()== bt_levantamento) {
			//implementar funcionalidades
		}


		if(e.getSource() == bt_depositar) {

			// implementar funcionalidades
		}

		if (e.getSource() == item_sair) {

			this.dispose();
		}

	}




}
