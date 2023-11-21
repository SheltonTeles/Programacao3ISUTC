package teste2;

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

public class ProdutoGUI extends JFrame implements ActionListener {
	private JTextField tf_nome;
	private JTextField tf_quantidade;
	private JTextField tf_preco;
	

	private JTextArea tf_exibirTela;
	private JLabel lb_nome, lb_quantidade, lb_preco;

	private JButton button_select;
	private JButton button_insert;
	private JButton button_delete;
	private JTable tb_listagem;
	private DefaultTableModel tm_listagemModel;//tabela

	public ProdutoGUI() {

		this.setTitle("Gestão de produtos");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		lb_nome = new JLabel("Nome:");
		lb_preco = new JLabel("Preço:");
		lb_quantidade = new JLabel("Quantidade:");

		
		tf_nome = new JTextField();
		tf_preco = new JTextField();
		tf_quantidade = new JTextField();
		

		tf_exibirTela = new JTextArea();
		button_select = new JButton("Consultar");
		button_insert = new JButton("Inserir");
		button_delete = new JButton("Apagar");
		button_delete.setBackground(Color.RED);

		tm_listagemModel = new DefaultTableModel();
		tm_listagemModel.addColumn("ID");
		tm_listagemModel.addColumn("Nome");
		tm_listagemModel.addColumn("Preço");
		tm_listagemModel.addColumn("Quantidade");

		tb_listagem = new JTable(tm_listagemModel);//
		
		JPanel panel = new JPanel(new GridLayout(6, 2));

		panel.add(lb_nome);
		panel.add(tf_nome);
		panel.add(lb_preco);
		panel.add(tf_preco);
		panel.add(lb_quantidade);
		panel.add(tf_quantidade);
		//panel.add(lb_nota2);
		//panel.add(tf_nota2);
		panel.add(button_select);
		panel.add(button_insert);
		panel.add(button_delete);

		tf_exibirTela.setEditable(false);

		button_select.addActionListener(this);
		button_insert.addActionListener(this);
		button_delete.addActionListener(this);

		add(panel, BorderLayout.NORTH);
		add(new JScrollPane(tb_listagem), BorderLayout.CENTER);
//		add(new JScrollPane(tf_exibirTela), BorderLayout.SOUTH);

	}

	private void consultarDados(ProdutoOperacoes al) {
		tm_listagemModel.setRowCount(0); 
		try {
			
			Connection connection = DriverManager.getConnection(al.jdbcURL, al.username, al.password);
			

			
			String selectQuery = "SELECT * FROM produto";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			
			tf_exibirTela.setText("");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				double precoString = resultSet.getDouble("preco");
				int quantidadeS = resultSet.getInt("quantidade");

				tf_exibirTela.append("Nome: " + nome + ", "+ "Preço:" + precoString +", Quantidade: " + quantidadeS + "\n");
				tm_listagemModel.addRow(new Object[] { id, nome,precoString, quantidadeS});
			}

			
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			tf_exibirTela.setText("Erro: " + e.getMessage());
		}
	}

	private void inserirDados(ProdutoOperacoes al) {
		String nome = tf_nome.getText();

		String preco = tf_preco.getText();
		String quantidadeStr = tf_quantidade.getText();
		
		try {
			int quantidade = Integer.parseInt(quantidadeStr);

			Connection connection = DriverManager.getConnection(al.jdbcURL, al.username, al.password);

			final String query = "INSERT INTO produto(nome, preco, quantidade) VALUES (?, ?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, preco);
			preparedStatement.setString(3, quantidadeStr);
			

			preparedStatement.executeUpdate();
			System.out.println("Inserido com sucesso");
			connection.close();
			preparedStatement.close();


			consultarDados(al);

		} catch (SQLException | NumberFormatException e) {
			tf_exibirTela.setText("Erro: " + e.getMessage());
		}
	}

	private void apagarDados(ProdutoOperacoes al) {
		String nome = tf_nome.getText();

		try {

			Connection connection = DriverManager.getConnection(al.jdbcURL, al.username, al.password);

			final String query = "DELETE FROM produto WHERE nome = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nome);

			preparedStatement.executeUpdate();
			System.out.println("Removido com sucesso");
			connection.close();
			preparedStatement.close();


			consultarDados(al);

		} catch (SQLException | NumberFormatException e) {
			tf_exibirTela.setText("Erro: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		ProdutoGUI app = new ProdutoGUI();
		app.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ProdutoOperacoes al = new ProdutoOperacoes();
		if (e.getSource() == button_select) {
			consultarDados(al);
		}
		if (e.getSource() == button_insert) {
			inserirDados(al);
		}
		if (e.getSource() == button_delete) {
			apagarDados(al);
		}

	}
	
	
	
}
