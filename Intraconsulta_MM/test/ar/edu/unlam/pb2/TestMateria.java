package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void creacionMateria() {
		String n = "a";
		Integer c = 111;
		
		Materia test = new Materia(c, n);
		
		assertNotNull(test);		
	}

}
