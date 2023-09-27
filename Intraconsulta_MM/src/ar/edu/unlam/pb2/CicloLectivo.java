package ar.edu.unlam.pb2;

import java.util.Date;

public class CicloLectivo {
	
	private Integer Id;
	private Date fechaInicioCicloLectivo;
	private Date fechaFinalizacionCicloLectivo; 
	private Date fechaInicioInscripcion; 
	private Date fechaFinalizacionInscripcion;
	
	public CicloLectivo(Integer id, Date fechaInicioCicloLectivo, 
			Date fechaFinalizacionCicloLectivo,
			Date fechaInicioInscripcion, Date fechaFinalizacionInscripcion) {
		
		Id = id;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Date getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}

	public void setFechaInicioCicloLectivo(Date fechaInicioCicloLectivo) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
	}

	public Date getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}

	public void setFechaFinalizacionCicloLectivo(Date fechaFinalizacionCicloLectivo) {
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}

	public Date getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public void setFechaInicioInscripcion(Date fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	public Date getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

	public void setFechaFinalizacionInscripcion(Date fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}
	
	
	

}
