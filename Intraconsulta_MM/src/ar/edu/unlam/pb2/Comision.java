package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Comision {

		private Integer id;
		private Materia materia;
		private Aula aula;
		private CicloLectivo cicloLectivo;
		private Dia dia;
		private Horario horario;
		private ArrayList<Alumno> alumnos;
		
		public Comision(Integer id, Materia materia, CicloLectivo cicloLectivo, Dia dia, Horario horario, Aula aula) {
			this.id = id;
			this.materia = materia;
			this.cicloLectivo = cicloLectivo;
			this.dia = dia;
			this.horario = horario;
			this.aula = aula;
			this.alumnos = new ArrayList<Alumno>();
		}
		public Comision(Integer id, Materia materia, CicloLectivo cicloLectivo, Dia dia, Horario horario) {
			this.id = id;
			this.materia = materia;
			this.cicloLectivo = cicloLectivo;
			this.dia = dia;
			this.horario = horario;
			this.alumnos = new ArrayList<Alumno>();
		}

		public Integer getId() {
			return id;
		}

		public Materia getMateria() {
			return materia;
		}

		public void setMateria(Materia materia) {
			this.materia = materia;
		}

		public Aula getAula() {
			return aula;
		}

		public void setAula(Aula aula) {
			this.aula = aula;
		}

		public CicloLectivo getCicloLectivo() {
			return cicloLectivo;
		}

		public void setCicloLectivo(CicloLectivo cicloLectivo) {
			this.cicloLectivo = cicloLectivo;
		}

		public Dia getDia() {
			return dia;
		}

		public void setDia(Dia dia) {
			this.dia = dia;
		}

		public Horario getHorario() {
			return horario;
		}

		public void setHorario(Horario horario) {
			this.horario = horario;
		}
		
		public Integer cantidadDeAlumnos() {
			return this.alumnos.size();
		}

		public void agregarAlumnosAlComision(Alumno alumno) {
			this.alumnos.add(alumno);
			
		}
		public Boolean contieneAlumno(Alumno alumno) {			
			return this.alumnos.contains(alumno);			
		}
		
}
