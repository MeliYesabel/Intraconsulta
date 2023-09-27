package ar.edu.unlam.pb2;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestCurso {

	@Test
	public void test() {
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
		
		CicloLectivo test = new CicloLectivo(id,a,b,f,ff);
		Aula aula = new Aula(num, cap);
		Materia materia = new Materia(c, n);
		
		Comision curso = new Comision(c, materia, test, dia, horario);
		
		assertNotNull(curso);
		
		
	}

}
