package exame2021;
import exame2021.*;
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

public class Historico extends JFrame {
	
	private Pessoa p;
	private JTable tb_listagem;
	private DefaultTableModel tm_listagemModel;
	private JTextArea tf_exibirTela;
	private JButton btSelect, btInsert, btDelete;
	
	/*
	 * Bilhete para um? Se eu e ela somos 1 - Grácio K*/
	
	public Historico()  {
		
		
		this.setTitle("Gestão de produtos");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btSelect = new JButton();
		
		
		
	}
	

}
