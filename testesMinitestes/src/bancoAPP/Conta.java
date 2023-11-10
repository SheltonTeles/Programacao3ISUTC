package bancoAPP;

import javax.swing.JOptionPane;
import java.util.Vector;

public class Conta {
	//atributes
	private double saldo;
	private int nrConta, levantamentos;
	private String nome;
	private Vector contas;

	//Getters and setters
	public double getSaldo() {return saldo;}
	public void setSaldo(double saldo) {this.saldo = saldo;}

	public int getNrConta() {return nrConta;}
	public void setNrConta(int nrConta) {this.nrConta = nrConta;}

	public int getLevantamentos() {return levantamentos;}
	public void setLevantamentos(int levantamentos) {this.levantamentos = levantamentos;}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	//Contructer
	public Conta() {}
	public Conta(String nome, double saldo) {
		//super();
		this.saldo = saldo;
		this.nrConta = nrConta;
		this.levantamentos = levantamentos;
		this.nome = nome;
	}

	//Method to generate id
	int gerarNrConta() {

		return (int) (Math.random()*10000);
	}

	//Method to withdraw money
	private double levantar(double valor) {

		if (valor >= saldo) 
			//			JOptionPane.showMessageDialog(null, "Saldo insuficiente");
			return -1;

		else 
			saldo -= valor;

		return 1;

	}


	//method to deposit money
	private void depositar(double valor) {

		saldo += valor;
		JOptionPane.showMessageDialog(null, "Depósito feito com sucesso.\n Novo saldo: "+saldo);
	}


	@Override
	public String toString() {
		return "Conta [nrConta=" + nrConta + "nome=,"+nome+"Saldo="+saldo+" levantamentos=" + levantamentos +"]";
	}
}
