package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void test() {
		String n = "a";
		Integer c = 111;
		Date ins = new Date (1111 - 11 - 11);
		Date nac = new Date (1111 - 11 - 11);
		
		Alumno test = new Alumno(n, c, ins, nac);
		
		assertNotNull(test);
	}

}
