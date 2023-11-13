package templatesTelas;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//adicionar funcionalidade ao botao Sair
public class TPC_MENU extends JFrame implements ActionListener{
	private JFrame frame;
	private JMenu menu;
	private JMenu submenu;
	private JMenuBar menuBar;
	private JCheckBox data;
	private JCheckBox tipo;
	private JRadioButton verificacao, compilador; 
	private JMenuItem texto, sair;
	
	public TPC_MENU()  {
		
		frame = new JFrame();
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		menu = new JMenu("MENU");
		
		data = new JCheckBox("Data");
		tipo = new JCheckBox("Tipo");
		
		texto = new JMenuItem("Texto");
		sair = new JMenuItem("Sair");
		
		verificacao = new JRadioButton("Verificação de Sintax");
		compilador = new JRadioButton("Compilador");
		
		submenu = new JMenu("SubMenu");
		
		menu.add(texto);
		menu.addSeparator();
		menu.add(data);
		menu.add(tipo);
		menu.addSeparator();
		menu.add(verificacao);
		menu.add(compilador);
		menu.addSeparator();
		menu.add(submenu);
		menu.addSeparator();
		menuBar.add(menu);
		menu.add(sair);
		
		frame.setTitle("MENU");
		frame.setLocation(50,50);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		sair.addActionListener(this);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new TPC_MENU();
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == sair) {
			
			System.exit(0);
		}
	}
	
}
