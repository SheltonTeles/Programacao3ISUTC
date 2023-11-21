package exame2021epoca1;

public class Estudante {

	private String nome, genero;
	private	int idade;


	//Construtor
	public Estudante() {}
	public Estudante(String nome, String genero, int idade) {
		//		super();
		this.nome = nome;
		this.genero = genero;
		this.idade = idade;
	}

	//Getters and Setters
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getGenero() {return genero;}
	public void setGenero(String genero) {this.genero = genero;}
	public int getIdade() {return idade;}
	public void setIdade(int idade) {this.idade = idade;}




	//	Metodo to String
	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", genero=" + genero + ", idade=" + idade + "]\n";
	}


}
