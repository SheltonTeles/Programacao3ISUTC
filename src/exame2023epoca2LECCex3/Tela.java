package exame2023epoca2LECCex3;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Tela extends JFrame implements ActionListener{
	
	private JRadioButton radioFlow, radioGrid;
	private ButtonGroup group;
	private JPanel panelRadiobuttons, panelButtons;
	private JButton bt1, bt2, bt3;
	
	Tela(){
		
		this.setTitle("Tela Principal");
		this.setSize(450, 300);
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		//panel dos radiobuttons
		panelRadiobuttons = new JPanel();
		panelRadiobuttons.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		radioFlow = new JRadioButton("FlowLayout");
		radioFlow.setSelected(true);
		radioGrid = new JRadioButton("GridLayout");
		
		radioFlow.addActionListener(this);
		radioGrid.addActionListener(this);
		
		group = new ButtonGroup();
		group.add(radioFlow);
		group.add(radioGrid);
		
		panelRadiobuttons.add(radioFlow);
		panelRadiobuttons.add(radioGrid);
		
		
		//Panel dos botões
		panelButtons = new JPanel();
		panelButtons.setLayout(new FlowLayout());
		
		bt1 = new JButton("Botão 1");
		bt2 = new JButton("Botão 2");
		bt3 = new JButton("Botão 3");
		
		panelButtons.add(bt1);
		panelButtons.add(bt2);
		panelButtons.add(bt3);
		
		
		this.add(panelRadiobuttons);
		this.add(panelButtons);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == radioFlow) {
			
			panelButtons.setLayout(new FlowLayout());
		}
		
		if(e.getSource() == radioGrid) {
			
			this.setLayout(new GridLayout(2,1,0,0));
			panelButtons.setLayout(new GridLayout(1,3,0,0));
			
		}
		
		this.validate();//Actualiza o layout da Tela
	}
	
	public static void main(String[] args) {
		new Tela();
	}
	
}


