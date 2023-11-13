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

public class CambioGUI extends JFrame implements ActionListener{
	public static final double usd=64.46 , eur=72.67, zar =4.09;//taxas de câmbio

	private JLabel labelValorMoeda, labelMoeda, labelValorMT, labelCambio;
	private JTextField tf_valorMoeda, tf_moeda, tf_cambio;
	private JButton bt_converter;
	private JComboBox optionsMoedas;
	private JPanel panel1, panel2;

	String moedas []= {"USD", "EUR","ZAR"};


	public CambioGUI (){
		this.setTitle("Conversão para metical: ");
		this.setSize(520, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel1 = new JPanel();
//		JSeparator sep = new JSeparator(); 
//		sep.setPreferredSize(getPreferredSize());

		panel2 = new JPanel();
		panel1.setLayout(new GridLayout(0, 2, 2, 4));

		panel2.setLayout(new GridLayout(0, 2, 2, 4));
		this.add(panel1);
		
		this.add(panel2);
		this.setLayout(new FlowLayout());

		labelValorMoeda = new JLabel("Valor em moeda");
		this.add(labelValorMoeda);

		tf_valorMoeda = new JTextField(20);
		this.add(tf_valorMoeda);

		labelMoeda = new JLabel("Moeda: ");
		this.add(labelMoeda);
		optionsMoedas = new JComboBox (moedas);
		this.add(optionsMoedas);

		labelValorMT = new JLabel("Valor em MT: ");
		this.add(labelValorMT);
		
		tf_moeda = new JTextField(20);
		this.add(tf_moeda);

		labelCambio = new JLabel("Câmbio: ");
		this.add(labelCambio);


		tf_cambio = new JTextField(8);
		this.add(tf_cambio);
		panel1.add(labelValorMoeda);
		panel1.add(tf_valorMoeda);
		panel1.add(labelMoeda);
		panel1.add(optionsMoedas);

		
		
		panel2.add(labelValorMT);
		panel2.add(tf_moeda);
		panel2.add(labelCambio);
		panel2.add(tf_cambio);

		bt_converter = new JButton("Converter");
		this.add(bt_converter);
		
		

		this.setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


	public static void main(String[] args) {new CambioGUI();}
}