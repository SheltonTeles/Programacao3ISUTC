package exame2021;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import exame2021.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela1 extends JFrame implements ActionListener {

	private JLabel labelNome, labelApelido;
	private JButton btSubmeter, btApagar;
	private JPanel panelForm, panelButtons;
	private JTextField tf_nome, tf_apelido;


	public Tela1() {


		this.setTitle("Conversão para metical: ");
		this.setSize(500, 180);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLocation(300,300);
		this.setLayout(new FlowLayout());

		panelForm = new JPanel();
		panelForm.setLayout(new GridLayout());

		panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout());

		labelNome = new JLabel("Nome");
		tf_nome = new JTextField(10);

		labelApelido = new JLabel("Apelido");
		tf_apelido = new JTextField(10);

		btSubmeter = new JButton ("Submeter");
		btSubmeter.addActionListener(this);
		btApagar = new JButton ("Apagar");
		btApagar.addActionListener(this);

		panelForm.add(labelNome);
		panelForm.add(tf_nome);
		panelForm.add(labelApelido);
		panelForm.add(tf_apelido);

		panelButtons.add(btSubmeter);
		panelButtons.add(btApagar);


		this.add(panelForm);
		this.add(panelButtons);

		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == btSubmeter) {

			Pessoa p = new Pessoa();
			p.setNome(tf_nome.getText().toString());
			p.setApelido(tf_apelido.getText().toString());



			if(tf_nome.getText().length()>0 && tf_apelido.getText().length()>0) {

				JOptionPane.showMessageDialog(this, "Bem vindo:"+tf_nome.getText()+" "+tf_apelido.getText());
				this.setVisible(true);
				new Menu(p);

			}	else {

				JOptionPane.showMessageDialog(this, "Preencha todos os campos:", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}		
		if(e.getSource() == btApagar) {
			tf_nome.setText("");
			tf_apelido.setText("");
		}
	}

	public static void main(String[] args) {new Tela1();}
}
