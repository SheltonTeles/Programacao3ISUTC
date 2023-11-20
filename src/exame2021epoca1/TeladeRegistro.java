package exame2021epoca1;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeladeRegistro extends JFrame implements ActionListener{
	private JButton btNovoRegistro, btLista, btSobre, btGravar;
	private JLabel lbNome, lbIdade, lbGenero, lbImagem;
	private JTextField tfNome, tfIdade;
	private JRadioButton radioMasc, radioFem;
	private ButtonGroup group;
	private JPanel panelWest, panelEast, panelCenter;
	private ImageIcon imageProfile;
	
	
	public TeladeRegistro() {
		
		this.setTitle("TELA DE REGISTRO");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(0);
		this.setLocation(300,300);

		
		panelWest = new JPanel();
//		-------------------------------------------------------------------------------------------------------------------------------
//		Redimensionamento da imagem
		imageProfile = new ImageIcon("assets/profile.png");
		int larguraDesejada = 280;
		int alturaDesejada = 280;
		Image imagemRedimensionada = imageProfile.getImage().getScaledInstance(larguraDesejada, alturaDesejada, Image.SCALE_SMOOTH);
		ImageIcon novoIcon = new ImageIcon(imagemRedimensionada);
		lbImagem = new JLabel(novoIcon);
//		-------------------------------------------------------------------------------------------------------------------------------------
		
//		PanelWest Start
		panelWest.setLayout(new GridLayout(3, 1, 5, 3));
		btNovoRegistro = new JButton("Novo Resgistro");
		btLista = new JButton("Lista");
		btSobre = new JButton("Sobre");
		panelWest.add(btNovoRegistro);
		panelWest.add(btLista);
		panelWest.add(btSobre);
		
//		PanelWest end
		
		
//		Panel East start
		panelEast = new JPanel();
		panelEast.setLayout(new GridLayout(2,1));
		panelEast.add(lbImagem);
//		
		
		panelEast.setLayout(new GridLayout(2,1));
//		Panel East end
		
		

//		Panel Center start
		panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 0,50));
		
		lbNome = new JLabel("Nome:   ");
		tfNome = new JTextField(30);
		lbIdade = new JLabel("Idade:   ");
		tfIdade = new JTextField(30);
		lbGenero = new JLabel("Genero:    ");
		radioMasc = new JRadioButton("Masculino   ");
		radioFem = new JRadioButton("Femenino                                     ");
		group = new ButtonGroup();
		group.add(radioMasc);
		group.add(radioFem);
	
		btGravar = new JButton("Gravar");
		btGravar.addActionListener(this);
		
		panelCenter.add(lbNome);
		panelCenter.add(tfNome);
		panelCenter.add(lbIdade);
		panelCenter.add(tfIdade);
		panelCenter.add(lbGenero);
		panelCenter.add(radioMasc);
		panelCenter.add(radioFem);
		panelCenter.add(btGravar);
//		PanelCenter end
		
		
		
		
		this.add(panelWest, "West");
		this.add(panelEast,"East");
		this.add(panelCenter,"Center");
		this.setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		new TeladeRegistro();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
}
