package exame2021;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*Resolução da tela de conversão do exame de programação 3, 2021 ISUTC
 * 
 * A tela abaixo serve para converter um valor em moeda estrangeira para metical. 
 * Ao selecionar a moeda o respectivo câmbio deve ser preenchido;
 * Os campos do Valor em MT e Câmbio não podem ser editáveis
 * O botão converter serve para calcular e ilustrar o valor em meticais de acordo com
 * a taxa de câmbio da  moeda selecionada
 * 
 * O botão histórico foi um acréscimo pedido pelo docente para podermos implementar a base de
 * dados*/
public class CambioGUI extends JFrame implements ActionListener{
	public static final double usd=64.46 , eur=72.67, zar =4.09;
	public static final String usdString="64.46" , eurString="72.67", zarString ="4.09";//taxas de câmbio
	public static double valorInserido, valorConvertido;

	private JLabel labelValorMoeda, labelMoeda, labelValorMT, labelCambio;
	private JTextField tf_valorMoeda, tf_moeda, tf_cambio;
	private JButton bt_converter, ver_historico, bt_apagar;
	private JComboBox optionsMoedas;
	private JPanel panel1, panelButtons;

	String moedas []= {"USD", "EUR","ZAR"};


	public CambioGUI (){
		Font font= new Font("Helvetica", Font.BOLD, 15); 
		this.setFont(font);
		this.setTitle("Conversão para metical: ");
		this.setSize(920, 180);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLocation(300,300);
		panel1 = new JPanel();
		panelButtons = new JPanel();
		panel1.setLayout(new GridLayout(2, 0, 0, 8));
		panelButtons.setLayout(new GridLayout(1,3,8,8));
		this.setLayout(new FlowLayout());
		Color color = new Color(255, 255, 255);
		
		this.add(panel1, BorderLayout.CENTER);
		this.add(panelButtons, BorderLayout.SOUTH);
		
		panel1.setBackground(Color.WHITE);
		panelButtons.setBackground(Color.WHITE);
		
		labelValorMoeda = new JLabel("Valor em moeda:",0);//o zero fez com que a label e o tf ficassem proximos um do outro
		labelValorMoeda.setFont(font);
		tf_valorMoeda = new JTextField(20);

		labelMoeda = new JLabel("Moeda",0);
		labelMoeda.setFont(font);
		optionsMoedas = new JComboBox (moedas);
		optionsMoedas.addActionListener(this);

		labelValorMT = new JLabel("Valor em MT",0);
		labelValorMT.setFont(font);
		tf_moeda = new JTextField(20);
		tf_moeda.setBackground(color);
		tf_moeda.setEditable(false);

		labelCambio = new JLabel("Câmbio",0);
		labelCambio.setFont(font);
		tf_cambio = new JTextField(8);
		tf_cambio.setBackground(color);
		tf_cambio.setEditable(false);


		panel1.add(labelValorMoeda);
		panel1.add(tf_valorMoeda);
		panel1.add(labelMoeda);
		panel1.add(optionsMoedas);

		panel1.add(labelValorMT);
		panel1.add(tf_moeda);
		panel1.add(labelCambio);
		panel1.add(tf_cambio);
		
		
		

		bt_converter = new JButton("Converter");
		bt_converter.setFont(font);
		ver_historico = new JButton("Historico");
		ver_historico.setFont(font);
		bt_apagar = new JButton ("Apagar");
		bt_apagar.setFont(font);
		
		bt_converter.addActionListener(this);
		ver_historico.addActionListener(this);
		bt_apagar.addActionListener(this);
		
		panelButtons.add(bt_converter);
		panelButtons.add(ver_historico);
		panelButtons.add(bt_apagar);

		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//		if(e.getSource() == optionsMoedas) {
		//			
		//			
		//		}

		valorInserido = Double.parseDouble(tf_valorMoeda.getText());



		switch(optionsMoedas.getSelectedItem().toString()) {
		case "USD":
			tf_cambio.setText(usdString);
			valorConvertido = valorInserido*usd;
			break;

		case "EUR":
			tf_cambio.setText(eurString);
			valorConvertido = valorInserido*eur;
			break;

		case "ZAR":
			tf_cambio.setText(zarString);
			valorConvertido = valorInserido*zar;
			break;
		}



		if(e.getSource() == bt_converter) {

			tf_moeda.setText(valorConvertido+"MT");

		}

		if(e.getSource() == ver_historico) {
			
			new Historico();
		}

	}
	
	


	public static void main(String[] args) {
	CambioGUI c= new CambioGUI();
		c.setVisible(true);
		
	}
}