package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Date;

public class Alumno {
	private static Integer id = 0;
	private String nombre;
	private Integer dni;
	private Date inscripcion;
	private Date nacimiento;
	private ArrayList<Nota> notas;
	private ArrayList<Materia> materiasaprobadas;
	private ArrayList<Materia> planDeEstudio;
	private ArrayList<Comision> comisiones;
	
	public Alumno(String nombre, Integer codigo, Date inscripcion, Date nacimiento) {
		Alumno.id++;
		this.nombre = nombre;
		this.dni = codigo;
		this.inscripcion = inscripcion;
		this.nacimiento = nacimiento;
		this.notas = new ArrayList<Nota>();
		this.materiasaprobadas = new ArrayList<Materia>();
		this.comisiones = new ArrayList <Comision>();
		this.planDeEstudio = new ArrayList<Materia>();
		
	}
	
	public Alumno(Integer dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.notas = (new ArrayList<Nota>());
		
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
	public void setDni(Integer codigo) {
		this.dni = codigo;
	}
	public Date getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(Date inscripcion) {
		this.inscripcion = inscripcion;
	}
	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
	public void agregarMateriasAprobadas(Materia materia) {
		this.materiasaprobadas.add(materia);
	}
	public void agregarMaterias(Materia materia) {
		this.planDeEstudio.add(materia);
	}
	public ArrayList<Materia> obtenerMateriasNoAprobadas() {
        ArrayList<Materia> materiasNoAprobadas = new ArrayList<>();
        for (Materia materia : planDeEstudio) {
            if (!materiasaprobadas.contains(materia)) {
                materiasNoAprobadas.add(materia);
            }
        }
        return materiasNoAprobadas;
    }
	
	public ArrayList<Materia> getMateriasaprobadas() {
		return materiasaprobadas;
	}

	public void setMateriasaprobadas(ArrayList<Materia> materiasaprobadas) {
		this.materiasaprobadas = materiasaprobadas;
	}

	public void agregarComisiones(Comision comision) {
		this.comisiones.add(comision);
	}
	public void eliminarComisiones(Comision comision) {
		this.comisiones.remove(comision);
	}
	public Boolean estaEnComision(Comision comision) {
		return this.comisiones.contains(comision);	}
	public void agregarNotas(Nota nota) {
		this.notas.add(nota);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + ", inscripcion=" + inscripcion + ", nacimiento="
				+ nacimiento + ", notas=" + notas + ", materiasaprobadas=" + materiasaprobadas + ", planDeEstudio="
				+ planDeEstudio + ", comisiones=" + comisiones + "]";
	}

	
}
