package exame2023epoca2LECCC;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Resolução do exercício 2 Parte B do exame de recorrência da LECC

public class TelaInscricao extends JFrame implements ActionListener {

	private JLabel lb_inscricao, lb_estudante, lb_curso, lb_idade, lb_diasEstudo, labelDireitosAutor, lb_genero;
	private JPanel panelJanela, panel1, panel2, panel3, panel4, panelDiretosAutor, panelDiasSemana;
	private JTextField tf_estudante;
	private JComboBox cb_cursos, cb_idades;
	private JButton submeter, sair;
	private JRadioButton masc, fem;
	private ButtonGroup group;

	String cursos [] = {"Educação Física","Gastronomia", "Engenharia e Ciências de Computação", "Engenharia Electrónica", "Engenharia Informática e Telecomunicaçõe"};
	String idades [] = {"16","17","18","19","20","21","22","23"};

	public TelaInscricao() {

		this.setTitle("Panel");
		this.setSize(760,400);
		this.setLocation(50,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(6,1));

		//Panel "Janela de Inscrição do ISUTC"	
		panelJanela = new JPanel();
		lb_inscricao = new JLabel("==============================Janela de inscrição do ISUTC==============================");
		panelJanela.add(lb_inscricao);

		//Centro da tela: nome estudante, nome curso, idade, gridlayout		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,2,1,1));
		lb_estudante = new JLabel("Nome do estudante");
		tf_estudante = new JTextField();
		lb_curso = new JLabel("Nome do curso");
		cb_cursos = new JComboBox(cursos);
		cb_cursos.addActionListener(this);
		cb_cursos.setSelectedIndex(4);//coloca por padrão LEIT como curso selecionado
		lb_idade = new JLabel("Idade do estudante");
		cb_idades = new JComboBox(idades);
		cb_idades.addActionListener(this);
		panel1.add(lb_estudante);
		panel1.add(tf_estudante);
		panel1.add(lb_curso);
		panel1.add(cb_cursos);
		panel1.add(lb_idade);
		panel1.add(cb_idades);

		//Panel dos dados dos estudantes
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		lb_diasEstudo = new JLabel("Dias de estudo");
		JCheckBox c1 = new JCheckBox("2a. Feira"); 
		JCheckBox c2 = new JCheckBox("3a. Feira"); 
		JCheckBox c3 = new JCheckBox("4a. Feira"); 
		JCheckBox c4 = new JCheckBox("5a. Feira"); 
		JCheckBox c5 = new JCheckBox("6a. Feira"); 
		JCheckBox c6 = new JCheckBox("Sábado"); 

		panelDiasSemana = new JPanel();
		panelDiasSemana.setLayout(new GridLayout(2,1,4,4));
		panel2.add(lb_diasEstudo);
		panelDiasSemana.add(c1);
		panelDiasSemana.add(c2);
		panelDiasSemana.add(c3);
		panelDiasSemana.add(c4);
		panelDiasSemana.add(c5);
		panelDiasSemana.add(c6);
		panel2.add(panelDiasSemana);


		//	panel com genero
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,3));
		lb_genero = new JLabel("Genero");
		masc = new JRadioButton("Masculino");
		masc.setSelected(true);//coloca masculino como padrão
		fem = new JRadioButton("Feminino");
		group = new ButtonGroup();
		group.add(masc);
		group.add(fem);
		panel3.add(lb_genero);
		panel3.add(masc);
		panel3.add(fem);

		//panel botoes
		panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1,2));
		labelDireitosAutor = new JLabel("==========Direitos reservados ao ISuTUC==========");
		submeter = new JButton("Submeter");
		submeter.addActionListener(this);
		sair = new JButton("Sair");
		sair.addActionListener(this);
		panel4.add(submeter);
		panel4.add(sair);
		panelDiretosAutor = new JPanel();
		panelDiretosAutor.setLayout(new FlowLayout(FlowLayout.CENTER));
		labelDireitosAutor.setForeground(Color.BLUE);
		panelDiretosAutor.add(labelDireitosAutor);


		this.add(panelJanela);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panelDiretosAutor);
		this.setVisible(true);
	}

	//Métodos
	public int verificarIdade() throws IdadeInvalidaException {
		int idade = Integer.parseInt(cb_idades.getSelectedItem().toString());

		if (idade < 18) {
			throw new IdadeInvalidaException("Não é permitida a inscrição devido a idade do estudante "+tf_estudante.getText());
		}

		return idade;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == submeter) {
			try {
				verificarIdade();
				JOptionPane.showMessageDialog(null, "O/A estudante " + tf_estudante.getText() + " está inscrito/a no curso " + cb_cursos.getSelectedItem().toString());
			} catch (IdadeInvalidaException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}

		if(e.getSource() == sair) {

			JOptionPane.showMessageDialog(null, "Fechando");

			new Autenticacao();
		}


	}
}
