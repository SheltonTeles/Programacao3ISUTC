package exame2023epoca1LECC;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.UpdateOperation.UpdateType;


public class TelaInsercao extends JFrame implements ActionListener {
	private JButton bt_add, bt_view, bt_filter;
	private JPanel panelButtons, panelTable;
	private JTable jt_listagem;
	private DefaultTableModel tm_listagemModel;
	private Vector temp;
	private Despesa despesa;
	private String[] coluna = { "Descrição", "Categoria", "Valor", "Data"};
	TelaInsercao (Despesa despesa){
		this.despesa = despesa;
		temp = new Vector();
		temp.add(despesa);
		
		this.setTitle("Gestão de Despesas Pessoais");// title 
		this.setSize(700, 700);// Width and Height 
		this.setLocation(100, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelTable = new JPanel();
		panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(1,3));

		bt_add = new JButton("Adcionar Despesas");
		bt_add.addActionListener(this);
		bt_view = new JButton("Visualizar Despesas");
		bt_view.addActionListener(this);
		bt_filter = new JButton("Filtrar por Categoria");
		bt_filter.addActionListener(this);;
		
		tm_listagemModel = new DefaultTableModel();
		
		

		if (temp != null) {

			jt_listagem = new JTable(listagem(temp), coluna);
			jt_listagem.setAutoCreateRowSorter(true);

		} else {
			
			jt_listagem = new JTable(null);
		}

		jt_listagem.setEnabled(false);
		JScrollPane sp = new JScrollPane(jt_listagem);
		this.add(sp);
		panelTable.add(jt_listagem);



		panelButtons.add(bt_add);

		panelButtons.add(bt_view);
		panelButtons.add(bt_filter);

		panelTable.add(jt_listagem);



		this.add(panelTable,"North");


		this.add(panelButtons, "South");

		this.setVisible(true);
	}



	private String[][] listagem(Vector temp) {
		//ESTA IMPLEMENTAÇÃO COLOCA TODOS OS DADOS DO VECTOR NUMA LISTA MULTIDIMENSIONAL PARA A TABELA
		this.despesa = despesa;
//				String[][] dados = new String[temp.size()][5];
		Object rowData[] = new Object[4];
				for (int i = 0; i < temp.size(); i++) {
					rowData[i] = (((Despesa) temp.get(i)).getDescricao()) + "";
					rowData[i] = (((Despesa) temp.get(i)).getCategoria()) + "";
					rowData[i] = (((Despesa) temp.get(i)).getValor()) + "";
					rowData[i] = (((Despesa) temp.get(i)).getData()) + "";

						System.out.println(((Despesa) temp.get(i)).toString());
					
				}
				return (String[][]) rowData;// O CONSTRUTOR RETORNA A LISTA MULTIDIMENSIONAL

			}

			



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bt_add) {
			new TelaRegisto();

		}

		if(e.getSource() == bt_view) {
			new TelaInsercao(despesa);
		}

		if(e.getSource() == bt_filter) {
			//			tm_listagemModel.setRowCount(0); 
			new TelaFiltrar();
		}

	}
}
