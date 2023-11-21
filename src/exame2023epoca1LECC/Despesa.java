package exame2023epoca1LECC;

public class Despesa {
	
	private String descricao, categoria, valor, data;

	
	//GETTERS AND SETTERS INICIO
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	//GETTERS AND SETTERS FIM

	
	//Construtores
	public Despesa(String descricao, String categoria, String valor, String data) {
//		super();
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = valor;
		this.data = data;
	}
	
	public Despesa() {}

	@Override
	public String toString() {
		return "Despesa [descricao=" + descricao + ", categoria=" + categoria + ", valor=" + valor + ", data=" + data
				+ "]";
	}
	
	
	
	
	
}
