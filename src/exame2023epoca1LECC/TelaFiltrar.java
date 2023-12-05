package exame2023epoca1LECC;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TelaFiltrar extends JFrame implements ActionListener{

	private JLabel lb_filtrar;
	private JButton bt_filtrar;
	private JComboBox cb_categoria;

	String [] categorias = {"Alimentação","Transporte","Lazer","Outros"};
	TelaFiltrar(){
		this.setTitle("LOGIN");// title 
		this.setSize(300, 100);// Width and Height 
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new FlowLayout());

		lb_filtrar = new JLabel("Selecione a Categoria");
		cb_categoria = new JComboBox(categorias);
		bt_filtrar = new JButton("Filtrar");

		this.add(lb_filtrar);
		this.add(cb_categoria);
		this.add(bt_filtrar);



		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TelaFiltrar();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == bt_filtrar) {


		}

	}
}


