package bancoAPP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import bancoAPP.*;

public class Menu extends JFrame implements ActionListener{
	private JButton bt_extracto, bt_levantamento, bt_depositar;
	private JPanel jp_buttons, jp_imagem;
	private ImageIcon imageBanner;
	private JLabel lb_imagem;
	private Conta conta;	
	
	

	Menu(Conta conta){
		this.conta = conta;
		
		this.setTitle("Menu");// title 
		this.setSize(760, 380);// Width and Height 
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jp_buttons = new JPanel();
		jp_buttons.setLayout(new GridLayout(3,1,5,3));
		jp_imagem = new JPanel();
		imageBanner = new ImageIcon("C:/Users/DELL/Downloads/Untitled.png");
		lb_imagem = new JLabel(imageBanner);
		jp_imagem.add(lb_imagem);


		bt_extracto = new JButton("Extracto");
		bt_extracto.addActionListener(this);
		jp_buttons.add(bt_extracto);

		bt_levantamento = new JButton("Levantamento");
		bt_levantamento.addActionListener(this);
		jp_buttons.add(bt_levantamento);

		bt_depositar = new JButton("Depositar");
		bt_depositar.addActionListener(this);
		jp_buttons.add(bt_depositar);

		this.add(jp_imagem,"North");
		this.add(jp_buttons);

		this.setVisible(true);

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == bt_extracto) {
			JOptionPane.showMessageDialog(this, "Extracto: " + conta.toString());
		}
		
		if(e.getSource()== bt_levantamento) {
			double valorPorlevantar = 0;
		}
		
		if(e.getSource() == bt_depositar) {
			double valorPorDepositar = 0;
		}

	}



}
