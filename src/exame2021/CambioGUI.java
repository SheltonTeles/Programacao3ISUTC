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
		bt_converter.addActionListener(this);
		this.add(bt_converter);

		this.setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == optionsMoedas) {
			
			
		}
		
		if(e.getSource() == bt_converter) {
			
		}

	}


	public static void main(String[] args) {new CambioGUI();}
}