package exame2021epoca1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Vector;
import exame2021epoca1.Estudante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeladeRegistro extends JFrame implements ActionListener{
	private JButton btNovoRegistro, btLista, btSobre, btGravar, btCarregar;
	private JLabel lbNome, lbIdade, lbGenero, lbImagem;
	private JTextField tfNome, tfIdade;
	private JRadioButton radioMasc, radioFem;
	private ButtonGroup group;
	private JPanel panelWest, panelEast, panelCenter;
	private ImageIcon imageProfile, imageCarregar;
	private JFileChooser jf;
	private Vector estudantes;

	public TeladeRegistro() {
		//		Obrigatório
		this.setTitle("TELA DE REGISTRO");
		this.setSize(800, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500,100);
		//		Obrigatório


		//		PanelWest Start
		panelWest = new JPanel();
		panelWest.setLayout(new GridLayout(3, 1, 5, 3));
		btNovoRegistro = new JButton("Novo Resgistro");
		btNovoRegistro.addActionListener(this);
		btLista = new JButton("Lista");
		btLista.addActionListener(this);
		btSobre = new JButton("Sobre");
		btSobre.addActionListener(this);
		panelWest.add(btNovoRegistro);
		panelWest.add(btLista);
		panelWest.add(btSobre);
		//		PanelWest end


		//		Panel East start
		panelEast = new JPanel();
		panelEast.setLayout(new GridLayout(2,1));
		imageProfile = new ImageIcon("assets/profile.png");
		imageCarregar = new ImageIcon("assets/carregar.png");
		int larguraDesejada = 280;
		int alturaDesejada = 280;
		Image imagemRedimensionada = imageProfile.getImage().getScaledInstance(larguraDesejada, alturaDesejada, Image.SCALE_SMOOTH);
		ImageIcon novoIcon = new ImageIcon(imagemRedimensionada);
		lbImagem = new JLabel(novoIcon);
		btCarregar = new JButton(imageCarregar);
		btCarregar.addActionListener(this);
		jf = new JFileChooser();
		panelEast.add(lbImagem);
		panelEast.add(btCarregar);
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
		radioFem.setSelected(true);
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


		//		Adição dos componentes da tela
		this.add(panelWest, "West");
		this.add(panelEast,"East");
		this.add(panelCenter,"Center");
		//		Adição dos componentes da tela

		this.setVisible(true);
	}





	//	Funcionalidade dos botões
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == btNovoRegistro) {
			tfNome.setText("");
			tfIdade.setText("");
			group.clearSelection();
		}

		if(e.getSource() == btLista) {

		}

		if(e.getSource() == btSobre) {
			JOptionPane.showMessageDialog(this, "Shelton Teles Uamusse");
		}

		if(e.getSource() == btGravar) {


		}


		if(e.getSource() == btCarregar) {
			
			while(carregarImagem()!=1) {
				carregarImagem();
			}
		}

	}
	
	
	public int carregarImagem() {
		
		jf.showOpenDialog(null);
		try {
			ImageIcon newImage = new ImageIcon(jf.getSelectedFile().getAbsolutePath());
			int larguraDesejada = 280;
			int alturaDesejada = 280;
			Image imagemRedimensionada = newImage.getImage().getScaledInstance(larguraDesejada, alturaDesejada, Image.SCALE_SMOOTH);
			ImageIcon novoIcon = new ImageIcon(imagemRedimensionada);
			lbImagem.setIcon(novoIcon);
			lbImagem.updateUI();
		}catch (NullPointerException ex){
			JOptionPane.showMessageDialog(this, "Selecione uma imagem");
			carregarImagem();
		}
		return 1;
		
	}



	public static void main(String[] args) {new TeladeRegistro();}
}
