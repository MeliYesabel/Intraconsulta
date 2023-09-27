package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestUniversidad {

	
		@Test
		public void queSePuedaRegistrarUnAlumnoALaUniversidad() {
			 String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	nombre = "Marta";
	    	String apellido = "perez";
	    	Integer dni= 44555; 
	    	Alumno alumno = new Alumno (dni,apellido);
			Boolean registroExitoso = unlam.registracionAlumno(alumno);
	    	assertTrue(registroExitoso);	
		}	
		@Test
		public void queNoSePuedaRegistrarUnAlumnoCuandoElAlumnoYaEsteRegistradoALaUniversidad() {
			String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	nombre = "Marta";
	    	String apellido = "perez";
	    	Integer dni= 44555; 
	    	Alumno alumno = new Alumno (dni,apellido);
	    	Alumno alumno2 = new Alumno (dni,"Lopez");
	  
	    	unlam.registracionAlumno(alumno);
			Boolean registroExitoso = unlam.registracionAlumno(alumno2);
	    	assertFalse(registroExitoso);   	
	}
		@Test
		public void queSePuedaRegistrarUnsMateria() {
			String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	nombre = "PB2 ";
	        Integer codigo = 1;
	        Materia pb2 = new Materia (codigo,nombre);
	        assertTrue (unlam.registraMateria(pb2));
		}		
		@Test
		public void queNOSePuedaRegistrarDosMateriaConElMismoCodigo() {
			String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	nombre = "PB2 ";
	        Integer codigo = 1;
	        Materia pb2 = new Materia (codigo,nombre);
	        Materia pb1 = new Materia (codigo, nombre);
	        unlam.registraMateria(pb2);
	        boolean test = unlam.registraMateria(pb1);
	        assertFalse (test);
			
		}		
		@Test
		public void queSePuedaRegistrarUnCicloLectivoYNOcrearOtroConElMismoID() {
			String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
			Integer id = 1;
			Date a = new Date (1111 - 11 -11);
			Date b = new Date (1112 - 11 -11);
			Date c = new Date (1113 - 11 -11);
			Date n = new Date (1114 - 11 - 11);
			
			CicloLectivo cicloLectivo1 = new CicloLectivo(id,a,b,c,n);
			CicloLectivo cicloLectivo2 = new CicloLectivo(id,a,b,c,n);
		
			boolean testregistro = unlam.registraCicloLectivo(cicloLectivo1);
			boolean testMismoId = unlam.registraCicloLectivo(cicloLectivo2);
			
			assertFalse(testMismoId);
			
			assertTrue(testregistro);
			
		}
		@Test
		public void queSePuedaRegistrarUnProfeALaUniversidad() {
			 String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	nombre = "Marta";
	    	String apellido = "perez";
	    	Integer dni= 44555; 
	    	Profesor profe = new Profesor (apellido,dni);
			Boolean registroExitoso = unlam.registracionProfesor(profe);
	    	assertTrue(registroExitoso);
	    	}
		@Test
		public void queSePuedaRegistrarDosProfesConElMismoALaUniversidad() {
			 String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	nombre = "Marta";
	    	String apellido = "perez";
	    	Integer dni= 44555; 
	    	Profesor profe = new Profesor (apellido,dni);
	    	Profesor profeTest = new Profesor ( apellido, dni);
			Boolean registroExitoso = unlam.registracionProfesor(profe);
			Boolean registroTest = unlam.registracionProfesor(profeTest);
			
	    	assertFalse(registroTest);
	    	}		
		@Test
		public void queSePuedaRegistrarUnaComision() {
			String n = "a";
			Integer c = 111;			
			Integer id = 1;
			Date a = new Date (1111 - 11 -11);
			Date b = new Date (1112 - 11 -11);
			Date f = new Date (1113 - 11 -11);
			Date ff = new Date (1114 - 11 - 11);
			Dia dia = Dia.JUEVES;
			Horario horario = Horario.MAÑANA;
			Integer cap = 10;
			Integer num = 1;
			Aula aula = new Aula(num,cap);
			CicloLectivo cl = new CicloLectivo(id,a,b,f,ff);
			Materia materia = new Materia(c, n);
			
			
			Comision curso = new Comision(c, materia, cl, dia, horario, aula);
			String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    		    	
	    	boolean test = unlam.registracionComision(curso);
	    	
	    	assertTrue(test);
	    	
			
			
		}
		@Test
		public void queNOSePuedaRegistrarDOSComisionesmismaMateriaCLTurno() {
			String n = "a";
			Integer c = 111;
			Integer cap = 1;
			Integer num = 1;			
			Integer id = 1;
			Date a = new Date (1111 - 11 -11);
			Date b = new Date (1112 - 11 -11);
			Date f = new Date (1113 - 11 -11);
			Date ff = new Date (1114 - 11 - 11);
			Dia dia = Dia.JUEVES;
			Horario horario = Horario.MAÑANA;
			
			CicloLectivo cl = new CicloLectivo(id,a,b,f,ff);
			Aula aula = new Aula(num, cap);
			Materia materia = new Materia(c, n);
			
			Comision curso = new Comision(c, materia, cl, dia, horario, aula);
			String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	Comision curso2 = new Comision(c, materia, cl, dia, horario, aula);
	    	
	    	unlam.registracionComision(curso);
	    	boolean test = unlam.registracionComision(curso2);
	    	
	    	assertFalse(test);
	    				
		}
		@Test
		public void agregarCorrelativasAUnaMateriaSiEstasExisten() {
			String n = "a";
			Integer d= 222;
			Integer c = 111;
			String  nombre = "Unlam";
			Materia materia = new Materia(c, n);
			Materia correlativa = new Materia(d, nombre);
			Universidad unlam = new Universidad (nombre);
			
			unlam.registraMateria(materia);
			unlam.registraMateria(correlativa);
			
			boolean test = unlam.agregarCorrelatividad(c, d);
			assertTrue(test);
		}		
		@Test
		public void eliminadarCorrelativasAUnaMateriaSiEstasSonCorrelativas() {
			String n = "a";
			Integer d= 222;
			Integer c = 111;
			String  nombre = "Unlam";
			Materia materia = new Materia(c, n);
			Materia correlativa = new Materia(d, nombre);
			Universidad unlam = new Universidad (nombre);
			
			unlam.registraMateria(materia);
			unlam.registraMateria(correlativa);
			unlam.agregarCorrelatividad(d, c);
			boolean test = unlam.eliminarCorrelatividad(d, c);
			assertTrue(test);
		}		
		@Test
		
		public void inscribirAlumnoAComision() {
			String n = "a";
			Integer c = 111;
			Date ins = new Date (1111 - 11 - 11);
			Date nac = new Date (1111 - 11 - 11);
			
			Alumno alum = new Alumno(n, c, ins, nac);
			Integer cap = 10;
			Integer num = 1;			
			Integer id = 1;
			Date a = new Date (1111 - 11 -11);
			Date b = new Date (1112 - 11 -11);
			Date f = new Date (1113 - 11 -11);
			Date ff = new Date (1114 - 11 - 11);
			Dia dia = Dia.JUEVES;
			Horario horario = Horario.MAÑANA;
			
			CicloLectivo test = new CicloLectivo(id,a,b,f,ff);
			Aula aula = new Aula(num, cap);
			Materia materia = new Materia(c, n);
			
			Comision curso = new Comision(c, materia, test, dia, horario, aula);
			String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	
	    	unlam.registracionAlumno(alum);
	    	unlam.registracionComision(curso);
	    	unlam.registrarAula(aula);
	    	
			Boolean tests = unlam.inscribirAlumnoAUnCurso(c, c);
			assertTrue(tests);
		
		}		
		public void asignarProfesorAComision() {
			String n = "a";
			Integer c = 111;
			
			Profesor prof = new Profesor(n, c);
			Integer cap = 10;
			Integer num = 1;			
			Integer id = 1;
			Date a = new Date (1111 - 11 -11);
			Date b = new Date (1112 - 11 -11);
			Date f = new Date (1113 - 11 -11);
			Date ff = new Date (1114 - 11 - 11);
			Dia dia = Dia.JUEVES;
			Horario horario = Horario.MAÑANA;
			
			CicloLectivo test = new CicloLectivo(id,a,b,f,ff);
			Aula aula = new Aula(num, cap);
			Materia materia = new Materia(c, n);
			
			Comision curso = new Comision(c, materia, test, dia, horario, aula);
			String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	
	    	unlam.registracionProfesor(prof);
	    	unlam.registracionComision(curso);
	    	unlam.registrarAula(aula);
	    	
			Boolean tests = unlam.inscribirAlumnoAUnCurso(c, c);
			
			assertTrue(tests);
		}
		public void asignarAulaComision() {
			String n = "a";
			Integer c = 111;
			Integer cap = 10;
			Integer num = 1;			
			Integer id = 1;
			Date a = new Date (1111 - 11 -11);
			Date b = new Date (1112 - 11 -11);
			Date f = new Date (1113 - 11 -11);
			Date ff = new Date (1114 - 11 - 11);
			Dia dia = Dia.JUEVES;
			Horario horario = Horario.MAÑANA;
			
			CicloLectivo test = new CicloLectivo(id,a,b,f,ff);
			Aula aula = new Aula(num, cap);
			Materia materia = new Materia(c, n);
			
			Comision curso = new Comision(c, materia, test, dia, horario);
			String  nombre = "Unlam";
	    	Universidad unlam = new Universidad (nombre);
	    	
	    	unlam.registracionComision(curso);
	    	unlam.registrarAula(aula);
			Boolean tests = unlam.asignarAula(c, num);
			
			assertTrue(tests);
		}

}

