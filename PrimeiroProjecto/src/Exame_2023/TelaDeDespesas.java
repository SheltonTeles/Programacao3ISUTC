package Exame_2023;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.*;
public class TelaDeDespesas extends JFrame implements ActionListener{

    private Despesa despesa;

    private JButton bt_adicionarDespesa,bt_visualizarDespesa,bt_filtrarCategoria;
    private DefaultTableModel tableModel;
    private JTable table;
    private JPanel panelBotoes;
    private Vector despesas;
    private JScrollPane scrollPane;
    public TelaDeDespesas(Despesa despesa,Vector despesas){
        this.despesa = despesa;
        this.despesas=despesas;
        this.setTitle("Gestão de Despesas Pessoais");
        this.setSize(650,500);
        this.setLocation(300,300);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Valor");
        tableModel.addColumn("Data");

        table = new JTable(tableModel);


        bt_adicionarDespesa = new JButton("Adicionar Despesa");
        bt_adicionarDespesa.addActionListener(this);

        bt_visualizarDespesa = new JButton("Visualizar Despesas");
        bt_visualizarDespesa.addActionListener(this);


        bt_filtrarCategoria = new JButton("Filtrar por Categoria");
        bt_filtrarCategoria.addActionListener(this);

        panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotoes.add(bt_adicionarDespesa);
        panelBotoes.add(bt_visualizarDespesa);
        panelBotoes.add(bt_filtrarCategoria);

        scrollPane = new JScrollPane(table);

        this.add(scrollPane,BorderLayout.NORTH);
        this.add(panelBotoes,BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void listarProdutos(Vector despesas){
        for(int i=0;i<despesas.size();i++){
            String descricao = ((Despesa)despesas.get(i)).getDescricao();
            String categoria = ((Despesa)despesas.get(i)).getCategoria();
            double valor = ((Despesa)despesas.get(i)).getValor();
            String data = ((Despesa)despesas.get(i)).getData();
            tableModel.addRow(new Object[] {descricao,categoria,valor,data});
        }
    }

    public static void main(String[] args){
        TelaDeDespesas telaDespes = new TelaDeDespesas(null,null);
        telaDespes.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt_adicionarDespesa){
            TelaAdicionarDespesa telaDespesa = new TelaAdicionarDespesa(null,null);
             telaDespesa.setVisible(true);
            this.dispose();
        }
    }
}
