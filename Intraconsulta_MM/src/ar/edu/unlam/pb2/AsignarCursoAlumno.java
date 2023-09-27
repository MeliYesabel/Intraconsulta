package ar.edu.unlam.pb2;

public class AsignarCursoAlumno {

	private static Integer id = 0;
	private Alumno alumno;
	private Comision curso;
	private Nota primerParcial;
	private Nota segundoParcial;
	private Nota notaFinal;
	private Boolean promocion;
	private Boolean aprobado;
	private Boolean recursa;	

	
	
	public AsignarCursoAlumno(Alumno alumno, Comision curso) {
		this.id= ++id;
		this.alumno = alumno;
		this.curso = curso;
	}


	public Integer getId() {
		return id;
	}


	public Alumno getAlumno() {
		return alumno;
	}


	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	public Comision getCurso() {
		return curso;
	}


	public void setCurso(Comision curso) {
		this.curso = curso;
	}


	public Boolean getAprobado() {
		return aprobado;
	}


	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}


	public Nota getPrimerParcial() {
		return primerParcial;
	}


	public void setPrimerParcial(Nota primerParcial) {
		this.primerParcial = primerParcial;
	}


	public Nota getSegundoParcial() {
		return segundoParcial;
	}


	public void setSegundoParcial(Nota segundoParcial) {
		this.segundoParcial = segundoParcial;
	}


	public Boolean getPromocion() {
		return promocion;
	}


	public void setPromocion(Boolean promocion) {
		this.promocion = promocion;
	}


	public Boolean getRecursa() {
		return recursa;
	}


	public void setRecursa(Boolean recursa) {
		this.recursa = recursa;
	}


	public Nota getFinaln() {
		return notaFinal;
	}


	public void setFinaln(Nota finaln) {
		this.notaFinal = finaln;
	}


	public Nota getNotaFinal() {
		return notaFinal;
	}


	public void setNotaFinal(Nota notaFinal) {
		this.notaFinal = notaFinal;
	}

}
