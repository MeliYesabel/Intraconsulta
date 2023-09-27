package ar.edu.unlam.pb2;

public class AsignacionCursoProfesor {
	private static Integer id;
	private Comision comision;
	private Profesor profesor;
	
	
	public AsignacionCursoProfesor(Comision curso, Profesor profesor) {
		AsignacionCursoProfesor.id = id++;
		this.comision = curso;
		this.profesor = profesor;
	}

	public Integer getId() {
		return id;
	}

	public Comision getAlumno() {
		return comision;
	}

	public void setAlumno(Comision curso) {
		this.comision = curso;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
}
