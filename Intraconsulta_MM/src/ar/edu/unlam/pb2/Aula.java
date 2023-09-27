package ar.edu.unlam.pb2;

public class Aula {
	private Integer nuemero;
	private Integer capacidad;
	
	public Aula(Integer nuemero, Integer capacidad) {
		this.nuemero = nuemero;
		this.capacidad = capacidad;
	}

	public Integer getNuemero() {
		return nuemero;
	}

	public void setNuemero(Integer nuemero) {
		this.nuemero = nuemero;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	
}
