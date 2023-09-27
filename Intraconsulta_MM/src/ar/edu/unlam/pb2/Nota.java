package ar.edu.unlam.pb2;

public class Nota {
	private Integer valor;
	private Instancia instacia;
	
	
	public Nota(Integer valor, Instancia instacia) {
		this.valor = valor;
		this.instacia = instacia;
	}


	public Nota() {
		// TODO Auto-generated constructor stub
	}


	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
	}


	public Instancia getInstacia() {
		return instacia;
	}


	public void setInstacia(Instancia instacia) {
		this.instacia = instacia;
	}
	
	
}
