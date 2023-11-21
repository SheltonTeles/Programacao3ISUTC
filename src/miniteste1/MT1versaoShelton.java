package miniteste1;

import java.awt.*;
import javax.swing.*;

public class MT1versaoShelton {

	private JLabel labelBanner, labelNome, labelSexo, labelDiversao, labelCurso, labelDireitosAutor;
	private JFrame frame;
	private JPanel panelBanner, panelDiretosAutor, panelWest, panelEast,panelCenter;
	private JButton submeter, limpar, programador;
	private JRadioButton masc, fem;
	private ButtonGroup group;//
	private JComboBox comboBox;
	private JTextField nomeText;
	private JList lista;
	private ImageIcon imageBanner;
	private JTextArea areaEst;
	private JScrollPane scrollPaneEst;



	String options [] = {"Escolha opção","Informática", "Contabilidade", "Civil", "Auditoria"};
	String listaConteudo [] = {"Futebol", "Andebol", "Internet", " Ler"};

	public MT1versaoShelton () {
		frame = new JFrame();
		frame.setTitle("Panel");
		frame.setSize(760,360);
		frame.setLocation(50,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//North Start (Banner);

		panelBanner = new JPanel();
		imageBanner = new ImageIcon("C:/Users/DELL/Downloads/Untitled.png");
		labelBanner = new JLabel(imageBanner);
		panelBanner.add(labelBanner);
		//North End (Banner);


		//South Start 
		labelDireitosAutor = new JLabel("==========Direitos reservados ao autor @Mujahid==========");
		panelDiretosAutor = new JPanel();
		panelDiretosAutor.setLayout(new FlowLayout(FlowLayout.CENTER));
		labelDireitosAutor.setForeground(Color.BLUE);

		panelDiretosAutor.add(labelDireitosAutor);
		//South End


		//West Start
		submeter = new JButton("Submeter");
		limpar = new JButton("Limpar");
		programador = new JButton("Programador");

		panelWest = new JPanel();
		panelWest.setLayout(new GridLayout(3, 1, 5, 3));
		panelWest.add(submeter);
		panelWest.add(limpar);
		panelWest.add(programador);
		//West End

		//Center Start
		panelCenter = new JPanel();					
		panelCenter.setLayout(new FlowLayout());

		labelNome = new JLabel("Nome:  ");
		nomeText = new JTextField(12);

		labelCurso = new JLabel("Curso: ");
		comboBox = new JComboBox(options);

		labelSexo = new JLabel("Sexo: ");
		masc = new JRadioButton("Masculino");
		fem = new JRadioButton("Feminino");
		group = new ButtonGroup();
		group.add(masc);
		group.add(fem);

		labelDiversao = new JLabel("Diversao");
		lista = new JList(listaConteudo);


		panelCenter.add(labelNome);
		panelCenter.add(nomeText);
		panelCenter.add(labelCurso);
		panelCenter.add(comboBox);
		panelCenter.add(labelSexo);
		panelCenter.add(masc);
		panelCenter.add(fem);
		panelCenter.add(labelDiversao);
		panelCenter.add(lista);
		//Center End



		//EAST START
		panelEast = new JPanel();
		panelEast.setLayout(new GridLayout(1,1));
		areaEst = new JTextArea(10,25);
		areaEst.setBackground(Color.CYAN);
		scrollPaneEst = new JScrollPane(areaEst,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		panelEast.add(scrollPaneEst);
		//EAST END





		//Adições na frame
		frame.add(panelBanner,"North");
		frame.add(panelDiretosAutor,"South");
		frame.add(panelWest,"West");
		frame.add(panelEast,"East");
		frame.add(panelCenter,"Center");
		frame.setVisible(true);
	}


	public static void main(String[] args) {
		new MT1versaoShelton();
	}



}
