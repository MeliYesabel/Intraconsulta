package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;

public class Materia {
	
	private static Integer Id = 0;
	private Integer codigo;
	private String nombreMateria;
	private ArrayList<Materia> correlativas;
	
	public Materia(Integer codigo, String nombreMateria) {
		Id++;
		this.codigo = codigo;
		this.nombreMateria = nombreMateria;
		this.correlativas = new ArrayList<Materia>();
	}
	public static Integer getId() {
		return Id;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}
	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}
	
	public Integer cantidadDeMateriasCorrelativas(){
		return this.correlativas.size();
	}
	public void agregarCorrelativas(Materia materia) {
		this.correlativas.add(materia)
		;
	}
	public void eliminarCorrelativas(Materia materia) {
		this.correlativas.remove(materia);
	}

	public boolean esCorrelativaDe(Materia correlativa) {
		boolean existencia = false;
		for (int i = 0; i < correlativas.size(); i++) {
			if (correlativas.contains(correlativa)) {
				existencia = true;
			}			
		}
		return existencia;
	}
	
}
