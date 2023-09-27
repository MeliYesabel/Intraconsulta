package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;
	private ArrayList<Materia> materias;
	private ArrayList<AsignarCursoAlumno> inscripcionACurso;
	private ArrayList<AsignacionCursoProfesor> asignacion;
	private ArrayList<CicloLectivo> cicloLectivos;
	private ArrayList<Comision> comisiones;
	private ArrayList<Aula> aulas;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<Materia>();
		this.profesores = new ArrayList<Profesor>();
		this.inscripcionACurso = new ArrayList<AsignarCursoAlumno>();
		this.cicloLectivos = new ArrayList<CicloLectivo>();
		this.comisiones = new ArrayList<Comision>();
		this.asignacion = new ArrayList<AsignacionCursoProfesor>();
		this.aulas = new ArrayList<Aula>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// ALUMNOS

	public Boolean registracionAlumno(Alumno alumno) {
		boolean exito = false;
		if (buscarAlumnoPorDni(alumno.getDni()) == null) {
			this.alumnos.add(alumno);
			exito = true;
		}
		return exito;
	}

	public Alumno buscarAlumnoPorDni(Integer dni) {
		Alumno alumno = null;
		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				alumno = this.alumnos.get(i);
			}
		}
		return alumno;
	}
	
	// AULA
	
	public Boolean registrarAula(Aula aula) {
		boolean exito = false;
		
		if (buscarAulaPorNum(aula.getNuemero())== null) {
			this.aulas.add(aula);
			exito = true;
		}
		return exito;
	}

	// MATERIA
	public Boolean registraMateria(Materia materia) {
		boolean exito = false;
		if (buscarMateriaPorCodigo(materia.getCodigo()) == null) {
			this.materias.add(materia);
			exito = true;
		}
		return exito;
	}

	private Materia buscarMateriaPorCodigo(Integer codigoMateria) {
		Materia materiaBuscada = null;
		for (int i = 0; i < materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigoMateria)) {
				materiaBuscada = this.materias.get(i);
			}
		}
		return materiaBuscada;
	}

	// CICLOLECTIVO
	public Boolean registraCicloLectivo(CicloLectivo cicloLectivo) {
		boolean exito = false;
		if (buscarCicloLectivoPorId(cicloLectivo.getId()) == null) {
			this.cicloLectivos.add(cicloLectivo);
			exito = true;
		}
		return exito;
	}

	private CicloLectivo buscarCicloLectivoPorId(Integer idCL) {
		CicloLectivo cicloLectivoBuscado = null;
		for (int i = 0; i < cicloLectivos.size(); i++) {
			if (this.cicloLectivos.get(i).getId().equals(idCL)) {
				cicloLectivoBuscado = this.cicloLectivos.get(i);
			}
		}
		return cicloLectivoBuscado;
	}

	// PROFESORES

	public Boolean registracionProfesor(Profesor profe) {
		boolean exito = false;
		if (buscarProfesorPorDni(profe.getDni()) == null) {
			this.profesores.add(profe);
			exito = true;
		}
		return exito;
	}

	public Profesor buscarProfesorPorDni(Integer dni) {
		Profesor profe = null;
		for (int i = 0; i < profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				profe = this.profesores.get(i);
			}
		}
		return profe;
	}

	public Boolean asignarProfeAlCurso(Integer idCurso, Integer dniProfe) {
		boolean asignado = false;

		Profesor profe = buscarProfesorPorDni(dniProfe);
		Comision comi = buscarComiPorId(idCurso);

		if (profe != null && comi != null) {
			if (comisionDadaDeAlta(idCurso) && !exedeCantidadDeAlumnosPermitidosEnElAula(idCurso)) {
				AsignacionCursoProfesor nuevaasig = new AsignacionCursoProfesor(comi, profe);
				this.asignacion.add(nuevaasig);
				profe.agregarComision(comi);
				asignado = true;
			}
		}
		return asignado;
	}

	public Boolean seNecesitaOtroProfe(Integer idCurso) {
		boolean necesidad = false;
		Comision comision = buscarComiPorId(idCurso);
		if (comision.cantidadDeAlumnos() > 20) {
			necesidad = true;
		}
		return necesidad;
	}
	
	//AULA
	
	public Aula buscarAulaPorNum(Integer num) {
		Aula aula= null;
		
		for (int i = 0; i < aulas.size(); i++) {
			if (aulas.get(i).getNuemero().equals(num)) {
				aula = aulas.get(i);
			}			
		}
		return aula;
	}

	public Boolean exedeCantidadDeAlumnosPermitidosEnElAula(Integer codigoComision) {
		boolean exede = false;
		Comision comision = this.buscarComiPorId(codigoComision);
		if (comision != null) {
			if (comision.cantidadDeAlumnos() > 
		comision.getAula().getCapacidad()) {
			exede = true;
		}
		}
		return exede;
	}
	
	// COMISION / CURSO

	public Boolean registracionComision(Comision comision) {
		boolean exito = false;
		if (!existeComiMismoCL(comision.getCicloLectivo()) && !existeComiMismoTurno(comision.getHorario())
				&& !existeComisionconMismaMateria(comision.getMateria())) {
			this.comisiones.add(comision);
			exito = true;
		}

		return exito;
	}

	public Boolean existeComisionconMismaMateria(Materia materia) {
		boolean existencia = false;
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getMateria().equals(materia)) {
				existencia = true;
			}
		}
		return existencia;
	}

	public Boolean existeComiMismoCL(CicloLectivo ciclo) {
		boolean existencia = false;
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getCicloLectivo().equals(ciclo)) {
				existencia = true;
			}
		}
		return existencia;
	}

	public Boolean existeComiMismoTurno(Horario turno) {
		boolean existencia = false;
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getHorario().equals(turno)) {
				existencia = true;
			}
		}
		return existencia;
	}

	public Comision buscarComiPorId(Integer id) {
		Comision comi = null;
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getId().equals(id)) {
				comi = this.comisiones.get(i);
			}
		}
		return comi;
	}

	public Boolean comisionDadaDeAlta(Integer idcomi) {
		boolean dadaDeAlta = false;

		Comision comi = buscarComiPorId(idcomi);

		if (registracionComision(comi) && !seNecesitaOtroProfe(idcomi)) {
			dadaDeAlta = true;
		}

		return dadaDeAlta;
	}
	
	public Integer cantidadDeProfesNecesarios(Integer codigoCurso) {
		Integer cantidadProfes = 1;
		Comision curso = buscarComiPorId(codigoCurso);
		if (curso != null) {
			if (curso.cantidadDeAlumnos() >20 && curso.cantidadDeAlumnos() <=40 ) {
				cantidadProfes = 2;}
			if (curso.cantidadDeAlumnos() >40 && curso.cantidadDeAlumnos() <= 20) {
				cantidadProfes = 3;				
			}			
		}
		return cantidadProfes;
	}
		
	
	// INSCRIPCION

	public Boolean inscribirAlumnoAUnCurso(Integer dni, Integer codigoComision) {
		boolean inscripto = false;
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Comision comision = this.buscarComiPorId(codigoComision);

		if (alumno != null && comision != null) {
			if (!exedeCantidadDeAlumnosPermitidosEnElAula(codigoComision)) {
				AsignarCursoAlumno inscripcionCurso = new AsignarCursoAlumno(alumno, comision);
				this.inscripcionACurso.add(inscripcionCurso);
				comision.agregarAlumnosAlComision(alumno);
				alumno.agregarComisiones(comision);
				inscripto = true;
			}
		}
		return inscripto;
	}
	
	public AsignarCursoAlumno buscarInscripcionCursoAlumno(Integer dni, Integer codigoComision){
		AsignarCursoAlumno inscripcion = null;
		
		for (int i = 0; i < this.inscripcionACurso.size(); i++) {
			if (this.inscripcionACurso.get(i).getAlumno().getDni().equals(dni) 
	&& this.inscripcionACurso.get(i).getCurso().getId().equals(codigoComision)) {
				inscripcion = this.inscripcionACurso.get(i);
			}			
		}		
		return inscripcion;
	}
	
	
	public Boolean asignarAula(Integer codigoComision, Integer numeroDeAula) {
		boolean exito = false;
		Aula aula = buscarAulaPorNum(numeroDeAula);
		Comision comision = buscarComiPorId(numeroDeAula);
		
		if (aula != null) {
			comision.setAula(aula);
		}
		return exito;
	}

	// CORRELATIVIDAD

	public Boolean agregarCorrelatividad(Integer codigoMateria, Integer codigoCorrelativa) {
		boolean agregada = false;

		Materia materia = buscarMateriaPorCodigo(codigoMateria);
		Materia correlativa = buscarMateriaPorCodigo(codigoCorrelativa);

		if (materia != null && correlativa != null) {
			materia.agregarCorrelativas(correlativa);
			agregada = true;
		}
		return agregada;
	}

	public Boolean eliminarCorrelatividad(Integer codigoMateria, Integer codigoCorrelativa) {
		boolean eliminada = false;

		Materia materia = buscarMateriaPorCodigo(codigoMateria);
		Materia correlativa = buscarMateriaPorCodigo(codigoCorrelativa);

		if (materia.esCorrelativaDe(correlativa)) {
			materia.eliminarCorrelativas(correlativa);
			eliminada = true;
		}
		return eliminada;

	}

	// NOTA
	
	public Boolean entre1y10(Integer valorNota) {
		boolean cumple = false;
		if (valorNota >= 10 && valorNota <= 1) {
			cumple = true;}
		return cumple;
	}
	
	public Boolean parcialesAprobado(AsignarCursoAlumno inscrpcion) {
		boolean aprobados = false;
		
		if (inscrpcion.getPrimerParcial().getValor() >= 4 && inscrpcion.getSegundoParcial().getValor() >= 4) {
			aprobados= true;
		}
		
		return aprobados;
	}
	
	public Boolean registarNota(Integer codigoCurso, Integer dniAlumno, Nota nota) {
		boolean registrada = false;
		
		Alumno alumno = buscarAlumnoPorDni(dniAlumno);
		Comision comi = buscarComiPorId(codigoCurso);
		AsignarCursoAlumno inscrpcion = buscarInscripcionCursoAlumno(dniAlumno, codigoCurso);
		
		if (alumno != null && comi != null && inscrpcion != null) {
			if (nota.getInstacia().equals(Instancia.PARCIAL1) || nota.getInstacia().equals(Instancia.RECU1)) {
				inscrpcion.setPrimerParcial(nota);
				registrada = true;
				}else if (nota.getInstacia().equals(Instancia.PARCIAL2) || nota.getInstacia().equals(Instancia.RECU2)) {
				inscrpcion.setSegundoParcial(nota);	
				registrada = true;
				} else if (nota.getInstacia().equals(Instancia.FINAL)) {
					if(parcialesAprobado(inscrpcion)) { 
						inscrpcion.setNotaFinal(nota);
						registrada = true;
						if (inscrpcion.getNotaFinal().getValor() > 7) {
							alumno.agregarMateriasAprobadas(inscrpcion.getCurso().getMateria());
							alumno.eliminarComisiones(comi);
						}
					}
				}
			// hacer condicion de final >d
		}
		
		return registrada;
	}
	
	
	public Nota obtenerNota(Integer idAlumno, Integer idMateria) {
		Nota nota = null;

		Materia materia = buscarMateriaPorCodigo(idMateria);
		Alumno alumno = buscarAlumnoPorDni(idMateria);

		if (alumno != null && materia != null) {
			for (int i = 0; i < this.inscripcionACurso.size(); i++) {
				if (this.inscripcionACurso.get(i).getAlumno().equals(alumno) && 
					this.inscripcionACurso.get(i).getCurso().getMateria().equals(materia)) {
					nota = this.inscripcionACurso.get(i).getNotaFinal();
				}
			}
		}
		return nota;
	}

}// ULTIMO
