package exame2021;

public class Pessoa {
//Esta seria a classe objecto	
	private String nome, apelido;
	
	
	//GETTERS AND SETTERS
	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public String getApelido() {return apelido;}

	public void setApelido(String apelido) {this.apelido = apelido;}

	
	public Pessoa() {}
	
	public Pessoa(String nome, String apelido) {
		
		this.nome = nome;
		this.apelido = apelido;
	}

	
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", apelido=" + apelido + "]";
	}
	
	
	
	
	
	
	
}
