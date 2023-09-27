package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Profesor {

	private String nombre;
	private Integer dni;
	private ArrayList<Comision> comisiones;
	
	
	public Profesor(String nombre, Integer dni) {
		this.comisiones = new ArrayList<Comision>();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}


	public void agregarComision(Comision comision) {
		this.comisiones.add(comision);		
	}
	public void eliminarComision(Comision comision) {
		this.comisiones.remove(comision);
	}

}
