package exame2023;

public class Viatura {

	private String nomeProp, tipoProp, tipoViatura, matricula, marca, color;
	private int tempoEst;
	
	public Viatura(String nomeProp, int tempoEst) {
		super();
		this.nomeProp = nomeProp;
		this.tempoEst = tempoEst;
	}
	public Viatura() {
		super();
	}
	public String getNomeProp() {
		return nomeProp;
	}
	public void setNomeProp(String nomeProp) {
		this.nomeProp = nomeProp;
	}
	public String getTipoProp() {
		return tipoProp;
	}
	public void setTipoProp(String tipoProp) {
		this.tipoProp = tipoProp;
	}
	public String getTipoViatura() {
		return tipoViatura;
	}
	public void setTipoViatura(String tipoViatura) {
		this.tipoViatura = tipoViatura;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getTempoEst() {
		return tempoEst;
	}
	public void setTempoEst(int tempoEst) {
		this.tempoEst = tempoEst;
	}
	@Override
	public String toString() {
		return "O condutor " + nomeProp + ",entrou no estacionamento do ISUTC e ficará por" + tempoEst +" horas";
	}
	
	
}
