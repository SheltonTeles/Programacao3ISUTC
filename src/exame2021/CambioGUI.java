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
	private JButton bt_converter, ver_historico;
	private JComboBox optionsMoedas;
	private JPanel panel1;

	String moedas []= {"USD", "EUR","ZAR"};


	public CambioGUI (){
		this.setTitle("Conversão para metical: ");
		this.setSize(920, 180);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 0, 0, 8));
		this.setLayout(new FlowLayout());

		labelValorMoeda = new JLabel("Valor em moeda",0);

		tf_valorMoeda = new JTextField(20);

		labelMoeda = new JLabel("Moeda",0);
		optionsMoedas = new JComboBox (moedas);
		optionsMoedas.addActionListener(this);

		labelValorMT = new JLabel("Valor em MT",0);
		tf_moeda = new JTextField(20);
		tf_moeda.setEditable(false);

		labelCambio = new JLabel("Câmbio",0);
		tf_cambio = new JTextField(8);
		tf_cambio.setEditable(false);

		this.add(panel1);
		panel1.add(labelValorMoeda);
		panel1.add(tf_valorMoeda);
		panel1.add(labelMoeda);
		panel1.add(optionsMoedas);

		panel1.add(labelValorMT);
		panel1.add(tf_moeda);
		panel1.add(labelCambio);
		panel1.add(tf_cambio);

		bt_converter = new JButton("Converter");
		ver_historico = new JButton("Historico");
		bt_converter.addActionListener(this);
		this.add(bt_converter);
		this.add(ver_historico);

		this.setVisible(true);

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
			
//			new historico();
		}

	}


	public static void main(String[] args) {new CambioGUI();}
}