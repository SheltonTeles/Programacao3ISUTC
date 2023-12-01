package Exame_2023;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TelaAdicionarDespesa extends JFrame implements ActionListener {

    private JLabel lbl_descricao,lbl_categoria,lbl_data,lbl_valor;
    private Despesa despesa;
    private JTextField txt_descricao,txt_valor,txt_data;
    private JComboBox comboBox;
    private JPanel panel,panel1,panel2,panel3,panelBotao,panelPrincipal;
    private JButton bt_adicionar;
    private Vector despesas;

    public TelaAdicionarDespesa(Despesa despesa,Vector despesas){
        despesas = new Vector();
        this.despesa=despesa;
        this.despesas = despesas;
        this.setTitle("Adicionar Despesa");
        this.setSize(300,300);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bt_adicionar = new JButton("Adicionar");
        bt_adicionar.addActionListener(this);
        panelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotao.add(bt_adicionar);

        lbl_descricao = new JLabel("Descrição");
        txt_descricao = new JTextField(10);

        String[] categoria = {"Alimentação","Transporte","Lazer","Outros"};
        comboBox = new JComboBox(categoria);
        comboBox.addActionListener(this);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(lbl_descricao);
        panel.add(txt_descricao);

        lbl_categoria = new JLabel("Categoria");

        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(lbl_categoria);
        panel1.add(comboBox);

        lbl_valor = new JLabel("Valor");
        txt_valor = new JTextField(10);

        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(lbl_valor);
        panel2.add(txt_valor);

        lbl_data = new JLabel("Data DD-MM_YYYY");
        txt_data = new JTextField(10);

        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(lbl_data);
        panel3.add(txt_data);

        panelPrincipal = new JPanel();
        panelPrincipal.add(panel);
        panelPrincipal.add(panel1);
        panelPrincipal.add(panel2);
        panelPrincipal.add(panel3);
        panelPrincipal.add(panelBotao);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));

        this.add(panelPrincipal);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new TelaAdicionarDespesa(null,null);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt_adicionar){
            String descricao = String.valueOf(txt_descricao.getText());
            String categoria = String.valueOf(comboBox.getSelectedItem().toString());
            double valor = Double.parseDouble(txt_valor.getText());
            String data =  String.valueOf(txt_data.getText());

            despesa = new Despesa(descricao,categoria,valor,data);
            despesas.add(despesa);

            TelaDeDespesas telaDespesa = new TelaDeDespesas(despesa,despesas);
            telaDespesa.setVisible(true);
            this.dispose();

        }
    }
}
