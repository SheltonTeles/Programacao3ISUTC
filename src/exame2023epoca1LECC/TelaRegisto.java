package exame2023epoca1LECC;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaRegisto extends JFrame implements ActionListener {



	private JPanel jp_Form;
	private JPanel jp_Buttons;

	private JLabel lb_descricao;
	
	private JLabel lb_categoria;
	
	private JLabel lb_valor;
	private JLabel lb_data;
	
	
	private JTextField tf_descricao;

	
	private JTextField tf_matricula;
	private JTextField tf_valor;
	private JTextField tf_data;
	

	private JComboBox categoria;

	
	private JButton bt_sair;
	private JButton bt_submeter;
	String categorias [] = {"Alimentação","Transporte","Lazer","Outros"};
	
	TelaRegisto() {

		jp_Form = new JPanel();
		jp_Buttons = new JPanel();

		lb_descricao = new JLabel("Descricao: ");
		lb_categoria = new JLabel("Categoria");
	
		lb_valor = new JLabel("Valor:");
		lb_data = new JLabel("Data (DD-MM-AAAA):");

		bt_sair = new JButton("Sair");
		bt_submeter = new JButton("Adicionar Despesa");

		tf_descricao = new JTextField(20);
		tf_matricula = new JTextField(20);
		tf_valor = new JTextField(20);
		tf_data = new JTextField(20);
		
		
		categoria = new JComboBox (categorias);
		
		

		this.setTitle("EXAME");// O tittulo da janela.
		this.setSize(500, 200);// Width and Height 
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//Listeners
		bt_submeter.addActionListener(this);
		bt_sair.addActionListener(this);
		
		this.setLayout(new FlowLayout());
		jp_Form.setLayout(new GridLayout(4,2,2,2));
		jp_Buttons.setLayout(new GridLayout(0,2,2,2));;
		
		
		jp_Form.add(lb_descricao);
		jp_Form.add(tf_descricao);
		jp_Form.add(lb_categoria);
		jp_Form.add(categoria);

	
		jp_Form.add(lb_valor);
		jp_Form.add(tf_valor);
		jp_Form.add(lb_data);
		jp_Form.add(tf_data);
	
		
		jp_Buttons.add(bt_sair);
		jp_Buttons.add(bt_submeter);
		this.add(jp_Form,BorderLayout.NORTH);
		this.add(jp_Buttons, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bt_submeter) {
			Despesa despesa = new Despesa();
			String desc =  tf_descricao.getText();
			String cat = categoria.getSelectedItem().toString();
			String valor = tf_valor.getText();
			String data = tf_data.getText();
			
			despesa.setDescricao(desc);
			despesa.setCategoria(cat);
			despesa.setValor(valor);
			despesa.setData(data);
			
			new TelaInsercao(despesa);
			
			
			
		}
		if (e.getSource() == bt_sair) {
			JOptionPane.showMessageDialog(this, "Fechando Sistema");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new TelaRegisto();
	}

}