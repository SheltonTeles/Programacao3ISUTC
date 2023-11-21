package exame2023;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaRegisto extends JFrame implements ActionListener {



	private JPanel jp_Form;
	private JPanel jp_Buttons;

	private JLabel lb_nome;
	private JLabel lb_matricula;
	private JLabel lb_tipoProp;
	private JLabel lb_tipoViatura;
	private JLabel lb_marca;
	private JLabel lb_cor;
	private JLabel lb_tempoEstabel;
	
//	private Viatura viatura;

	private TextField tf_nome;
	private TextField tf_matricula;
	private TextField tf_marca;
	private TextField tf_cor;
	private TextField tf_tempo;

	private JComboBox tipoProp;
	private JComboBox tipoViaturasCombo;
	
	private JButton bt_sair;
	private JButton bt_submeter;
	String proprietario [] = {"Escolha proprietario", "Estudante","Funcionario"," Outro"};
	String tipoViatura []  = {"Escolha", "Blindada","Ligeira de Transporte Pessoal","LigeiraTransporte Publico","Pesada de Trans pessoal","Pesada de tranp publico","Especial"};
	TelaRegisto() {

		jp_Form = new JPanel();
		jp_Buttons = new JPanel();

		lb_nome = new JLabel("Nome: ");
		lb_tipoProp = new JLabel("Tipo de Prop");
		lb_matricula = new JLabel("Matricula: ");
		lb_tipoViatura = new JLabel("Tipo viatura:");
		lb_marca = new JLabel("Marca:");
		lb_cor = new JLabel("Cor:");
		lb_tempoEstabel = new JLabel("Tempo em hora");
		bt_sair = new JButton("Sair");
		bt_submeter = new JButton("Submeter Ficha");

		tf_nome = new TextField(25);
		tf_matricula = new TextField(25);
		tf_marca = new TextField(25);
		tf_cor = new TextField(25);
		tf_tempo = new TextField(25);
		
		tipoProp = new JComboBox (proprietario);
		tipoViaturasCombo = new JComboBox(tipoViatura);
		

		this.setTitle("EXAME");// O tittulo da janela.
		this.setSize(500, 300);// Width and Height 
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//Listeners
		bt_submeter.addActionListener(this);
		bt_sair.addActionListener(this);
		
		this.setLayout(new FlowLayout());
		jp_Form.setLayout(new GridLayout(7,2,2,2));
		jp_Buttons.setLayout(new GridLayout(0,2,2,2));;
		
		
		jp_Form.add(lb_nome);
		jp_Form.add(tf_nome);
		jp_Form.add(lb_tipoProp);
		jp_Form.add(tipoProp);
		jp_Form.add(lb_tipoViatura);
		jp_Form.add(tipoViaturasCombo);
		jp_Form.add(lb_matricula);
		jp_Form.add(tf_matricula);
		jp_Form.add(lb_marca);
		jp_Form.add(tf_marca);
		jp_Form.add(lb_cor);
		jp_Form.add(tf_cor);
		jp_Form.add(lb_tempoEstabel);
		jp_Form.add(tf_tempo);
		
		
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
			Viatura viatura = new Viatura();
			viatura.setTempoEst(Integer.parseInt(tf_tempo.getText()));
			viatura.setNomeProp(tf_nome.getText().toString());
			if(tipoProp.getSelectedItem().toString().equals("Estudante") || tipoProp.getSelectedItem().toString().equals("Funcionario")) {
				
				JOptionPane.showMessageDialog(null, viatura.toString());
			} else {
				if(viatura.getTempoEst() < 24) {
					JOptionPane.showMessageDialog(null, viatura.toString()+ "deve pagar "+10*viatura.getTempoEst());
				} else {
					JOptionPane.showMessageDialog(null, viatura.toString()+ "deve pagar 45 MT");
				}
			}
			
		}
		if (e.getSource() == bt_sair) {
			new TelaAutenticacao();
		}
	}
	
	public static void main(String[] args) {
		new TelaRegisto();
	}

}