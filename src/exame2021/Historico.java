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

public class Historico extends JFrame implements ActionListener{
	
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
		btInsert = new	JButton();
		btDelete = new JButton();
		
		btSelect = new JButton("Consultar");
		btSelect.addActionListener(this);
		btInsert = new JButton("Inserir");
		btInsert.addActionListener(this);
		btDelete = new JButton("Apagar");
		btDelete.addActionListener(this);
		btDelete.setBackground(Color.RED);
		
		

		tm_listagemModel = new DefaultTableModel();
		tm_listagemModel.addColumn("ID");
		tm_listagemModel.addColumn("Nome");
		tm_listagemModel.addColumn("Preço");
		tm_listagemModel.addColumn("Quantidade");
		
		tb_listagem = new JTable(tm_listagemModel);
		
		
		
		add(new JScrollPane(tb_listagem), BorderLayout.CENTER);
		add(new JScrollPane(tf_exibirTela), BorderLayout.SOUTH);
		
		
		this.setVisible(true);
		
		
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {new Historico();}
}
